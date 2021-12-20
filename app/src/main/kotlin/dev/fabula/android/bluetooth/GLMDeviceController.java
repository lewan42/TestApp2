package dev.fabula.android.bluetooth;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import dev.fabula.android.module.mtprotocol.MtConnection;
import dev.fabula.android.module.mtprotocol.MtMessage;
import dev.fabula.android.module.mtprotocol.MtProtocol;
import dev.fabula.android.module.mtprotocol.MtProtocol.MTProtocolEvent;
import dev.fabula.android.module.mtprotocol.MtProtocol.MTProtocolEventObserver;
import dev.fabula.android.module.mtprotocol.glm100C.MtProtocolBLEImpl;
import dev.fabula.android.module.mtprotocol.glm100C.MtProtocolImpl;
import dev.fabula.android.module.mtprotocol.glm100C.event.MtProtocolFatalErrorEvent;
import dev.fabula.android.module.mtprotocol.glm100C.event.MtProtocolReceiveMessageEvent;
import dev.fabula.android.module.mtprotocol.glm100C.event.MtProtocolRequestTimeoutEvent;
import dev.fabula.android.module.mtprotocol.glm100C.message.edc.EDCInputMessage;
import dev.fabula.android.module.mtprotocol.glm100C.message.edc.EDCOutputMessage;
import dev.fabula.android.module.mtprotocol.glm100C.message.laser.LaserOffMessage;
import dev.fabula.android.module.mtprotocol.glm100C.message.laser.LaserOnMessage;
import dev.fabula.android.module.mtprotocol.glm100C.message.sync.SyncInputMessage;
import dev.fabula.android.module.mtprotocol.glm100C.message.sync.SyncOutputMessage;

import dev.fabula.android.bluetooth.bluetooth.BLEConnection;
import dev.fabula.android.bluetooth.bluetooth.BluetoothUtils;
import dev.fabula.android.bluetooth.bluetooth.MTBluetoothDevice;


public class GLMDeviceController implements MTProtocolEventObserver {
    private static final String TAG = "GLMDeviceController";

    private static final String ACTION_ERROR = "ERROR";

    public static final String ACTION_SYNC_CONTAINER_RECEIVED = "SYNC_CONTAINER_RECEIVED";
    //public static final String ACTION_SYNC_CONTAINER_RECEIVED = "SYNC_CONTAINER_RECEIVED";

    public static final String EXTRA_MEASUREMENT = "MEASUREMENT";
    public static final String EXTRA_MEASUREMENT_TYPE = "MEASUREMENT_TYPE";
    public static final String EXTRA_MEASUREMENT_COMP1 = "MEASUREMENT_COMP1";
    public static final String EXTRA_MEASUREMENT_COMP2 = "MEASUREMENT_COMP2";

    private Context context;

    private MtProtocol protocol;

    private MTBluetoothDevice bluetoothDevice;

    private boolean initSyncRequest;

    private boolean ready;

    public GLMDeviceController(Context context) {
        super();
        this.context = context;
    }

    /**
     * Test utility:
     * Use this method to turn the laser of connected GLM device on
     */
    public void turnLaserOn() {
        if (isReady()) {
            ready = false;
            protocol.sendMessage(new LaserOnMessage());
        }
    }

    /**
     * Test utility:
     * Use this method to turn the laser of connected GLM device off
     */
    public void turnLaserOff() {
        if (isReady()) {
            ready = false;
            protocol.sendMessage(new LaserOffMessage());
        }
    }

    /**
     * Starts sync mode between app and GLM device
     * When sync mode is started the GLM device will send every event to the app
     */
    private void turnAutoSyncOn() {
        if (this.isReady()) {
            this.ready = false;
            if (bluetoothDevice != null) {
                if (BluetoothUtils.validateGLM100Name(bluetoothDevice)) {
                    // GLM 100 device
                    final SyncOutputMessage requestDoSync = new SyncOutputMessage();
                    requestDoSync.setSyncControl(SyncOutputMessage.MODE_AUTOSYNC_CONTROL_ON);
                    this.protocol.sendMessage(requestDoSync);
                    Log.d(TAG, "Sync started GLM 100...");
                } else if (BluetoothUtils.validateEDCDevice(bluetoothDevice)) {
                    // Exchange Data Container (EDC) based device
                    final EDCOutputMessage requestEDCSync = new EDCOutputMessage();
                    requestEDCSync.setSyncControl(EDCOutputMessage.MODE_AUTOSYNC_CONTROL_ON);
                    requestEDCSync.setDevMode(EDCOutputMessage.SINGLE_DISTANCE_REQUEST);

                    //requestEDCSync.setRemoteCtrlData(EDCOutputMessage.);

                    this.protocol.sendMessage(requestEDCSync);
                    Log.d(TAG, "Sync started EDC device...");
                }
            }
        }
    }

    public void qwe(){
        final EDCOutputMessage requestEDCSync = new EDCOutputMessage();
        requestEDCSync.setSyncControl(EDCOutputMessage.MODE_AUTOSYNC_CONTROL_ON);
        requestEDCSync.setDevMode(7);
        requestEDCSync.setKeypadBypass(EDCOutputMessage.ENABLE_KEYPAD_BYPASS);
        requestEDCSync.setRemoteCtrlData(EDCOutputMessage.REMOTE_CTRL_DATA);
        this.protocol.sendMessage(requestEDCSync);
    }

    @Override
    public void onEvent(MTProtocolEvent event) {

        ready = true;

        if (event instanceof MtProtocolFatalErrorEvent) {

            // fatal error
            Log.d(TAG, "Received MtProtocolFatalErrorEvent");
            protocol.reset();
            context.sendBroadcast(new Intent(ACTION_ERROR));

        } else if (event instanceof MtProtocolReceiveMessageEvent) {

            // received MT message -> act considering message type
            MtMessage message = ((MtProtocolReceiveMessageEvent) event).getMessage();

            if (message instanceof SyncInputMessage) { // Sync Message Type used by GLM 100 C
                SyncInputMessage syncMessage = (SyncInputMessage) message;

                if (initSyncRequest) { // Ignore first response
                    initSyncRequest = false;
                    return;
                }

                if (syncMessage.getMode() == SyncInputMessage.MEAS_MODE_SINGLE && syncMessage.getLaserOn() == 0) {
                    // Handle only distance measurements
                    broadcastMeasurement(ACTION_SYNC_CONTAINER_RECEIVED, syncMessage.getResult(), -1, -999, -999);
                }
            } else if (message instanceof EDCInputMessage) { // Exchange Data Container (EDC) Message Type used by all other connected GLM devices

                if (initSyncRequest) { // Ignore first response
                    initSyncRequest = false;
                    return;
                }

                EDCInputMessage edcMessage = (EDCInputMessage) message;
                if (edcMessage.getDevMode() == EDCInputMessage.MODE_SINGLE_DISTANCE || edcMessage.getDevMode() == EDCInputMessage.MODE_CONTINUOUS_DISTANCE) {
                    // Handle only distance measurements
                    broadcastMeasurement(ACTION_SYNC_CONTAINER_RECEIVED, edcMessage.getResult(), edcMessage.getDevMode(), edcMessage.getComp1(), edcMessage.getComp2());
                }
                else if(edcMessage.getDevMode() == EDCInputMessage.MODE_INDIRECT_HEIGHT || edcMessage.getDevMode() == EDCInputMessage.MODE_INDIRECT_LENGTH){
                    broadcastMeasurement(ACTION_SYNC_CONTAINER_RECEIVED, edcMessage.getResult(), edcMessage.getDevMode(), edcMessage.getComp1(), edcMessage.getComp2());
                }
            } else {

            }
        } else if (event instanceof MtProtocolRequestTimeoutEvent) {
            context.sendBroadcast(new Intent(ACTION_ERROR));
        } else {
            Log.e(TAG, "Received unknown event");
        }
        initSyncRequest = false;
    }

    private void broadcastMeasurement(String action, float result, int type_measure, float comp1, float comp2) {
        Log.e("broadcastMeasurement: ", result + " ///");
        Intent i = new Intent(action);
        i.putExtra(EXTRA_MEASUREMENT, result);
        i.putExtra(EXTRA_MEASUREMENT_TYPE, type_measure);
        i.putExtra(EXTRA_MEASUREMENT_COMP1, comp1);
        i.putExtra(EXTRA_MEASUREMENT_COMP2, comp2);
        context.sendBroadcast(i);
    }

    /**
     * Delivers information if MT Protocol is ready for communication
     *
     * @return TRUE, if protocol is ready and FALSE otherwise
     */
    private boolean isReady() {
        return protocol != null && ready;
    }

    /**
     * Initializes the device controller. Must be called once before using the controller
     *
     * @param connection current connection
     * @param btDevice   connected device
     */
    public void init(MtConnection connection, MTBluetoothDevice btDevice) {

        destroy();

        this.bluetoothDevice = btDevice;

        if (connection instanceof BLEConnection) {
            // MirX based device
            protocol = new MtProtocolBLEImpl();
        } else {
            // PAN 1026 based device
            protocol = new MtProtocolImpl();
        }
        protocol.addObserver(this);
        protocol.setTimeout(5000);
        protocol.initialize(connection);

        ready = true;

        initSyncRequest = true;
        turnAutoSyncOn();
    }

    /**
     * Destroys the device controller. Always call after BluetoothConnection is lost
     */
    public void destroy() {

        if (protocol != null) {
            protocol.removeObserver(this);
            protocol.destroy();
            protocol = null;
        }
    }

    /**
     * Return the current Bluetooth device
     *
     * @return connected Bluetooth device if any; null otherwise
     */
    public MTBluetoothDevice getBTDevice() {
        return bluetoothDevice;
    }
}
