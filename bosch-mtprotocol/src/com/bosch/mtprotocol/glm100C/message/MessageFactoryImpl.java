package dev.fabula.android.module.mtprotocol.glm100C.message;

import java.util.HashMap;
import java.util.Map;

// import MT protocol general classes
import dev.fabula.android.module.mtprotocol.MtFrame;
import dev.fabula.android.module.mtprotocol.MtMessage;
import dev.fabula.android.module.mtprotocol.MtMessageFactory;
import dev.fabula.android.module.mtprotocol.general.message.dev_info.DevInfoMessageFactory;
import dev.fabula.android.module.mtprotocol.general.message.echo.DoEchoMessageFactory;
import dev.fabula.android.module.mtprotocol.general.message.keypad.KeypadPatternMessageFactory;
import dev.fabula.android.module.mtprotocol.general.message.rtc.RTCTimestampMessageFactory;
// import LRF specific classes
import dev.fabula.android.module.mtprotocol.glm100C.frame.MtBaseFrame;
import dev.fabula.android.module.mtprotocol.glm100C.message.edc.EDCMessageFactory;
import dev.fabula.android.module.mtprotocol.glm100C.message.settings.SettingsMessageFactory;
import dev.fabula.android.module.mtprotocol.glm100C.message.single.SingleDistMessageFactory;
import dev.fabula.android.module.mtprotocol.glm100C.message.sync.SyncMessageFactory;
import dev.fabula.android.module.mtprotocol.glm100C.message.sync.list.SyncListMessageFactory;
import dev.fabula.android.module.mtprotocol.linelaser.message.GCLDevInfo.GCLDevInfoMessageFactory;
import dev.fabula.android.module.mtprotocol.linelaser.message.GetPowerProfile.PowerProfileMessageFactory;
import dev.fabula.android.module.mtprotocol.linelaser.message.LastCalibrationData.LastCalibrationDataMessageFactory;
import dev.fabula.android.module.mtprotocol.linelaser.message.MotorOperations.MotorOperationsMessageFactory;
import dev.fabula.android.module.mtprotocol.linelaser.message.RemoteControlKey.RemoteControlKeyMessageFactory;
import dev.fabula.android.module.mtprotocol.linelaser.message.SetLasers.SetLasersMessageFactory;
import dev.fabula.android.module.mtprotocol.linelaser.message.SyncCalibrationData.SyncCalibrationDataMessageFactory;
import dev.fabula.android.module.mtprotocol.linelaser.message.SystemStates.SystemStateMessageFactory;
import dev.fabula.android.module.mtprotocol.rotation.message.calibration.CalibrationGuardDataMessagFactory;
import dev.fabula.android.module.mtprotocol.rotation.message.calibration.SyncCalibrationMessageFactory;
import dev.fabula.android.module.mtprotocol.rotation.message.eeprom_data.EEPROMDataMessageFactory;
import dev.fabula.android.module.mtprotocol.rotation.message.grl_info.GRLDevInfoMessageFactory;
import dev.fabula.android.module.mtprotocol.rotation.message.log.LogPacketMessageFactory;
import dev.fabula.android.module.mtprotocol.rotation.message.log.LogSizeMessageFactory;
import dev.fabula.android.module.mtprotocol.rotation.message.slope.LaserSlopeMessageFactory;
import dev.fabula.android.module.mtprotocol.rotation.message.status.SyncStatusMessageFactory;
// import Thermo specific classes
import dev.fabula.android.module.mtprotocol.thermo.message.edct.EDCTMessageFactory;
import dev.fabula.android.module.mtprotocol.thermo.message.imgdata.ImgDataMessageFactory;
import dev.fabula.android.module.mtprotocol.thermo.message.imginfo.ImgInfoMessageFactory;

public class MessageFactoryImpl implements MtMessageFactory {

    // A list of supported factories
    @SuppressWarnings("rawtypes")
    private static Map<String, Class> factories = new HashMap<String, Class>();

    static {
        synchronized (factories) {
            // register General factories
            factories.put("6", DevInfoMessageFactory.class);
            factories.put("15", RTCTimestampMessageFactory.class);
            factories.put("27", KeypadPatternMessageFactory.class);
            factories.put("62", DoEchoMessageFactory.class);

            // register LRF factories
            factories.put("64", SingleDistMessageFactory.class);
            factories.put("80", SyncMessageFactory.class);
            factories.put("81", SyncListMessageFactory.class);
            factories.put("83", SettingsMessageFactory.class);
            factories.put("85", EDCMessageFactory.class);

            // register Thermo factories
            factories.put("94", EDCTMessageFactory.class);
            factories.put("95", ImgInfoMessageFactory.class);
            factories.put("96", ImgDataMessageFactory.class);

            // register Rotation factories
            factories.put("100", SyncStatusMessageFactory.class);
            factories.put("101", GRLDevInfoMessageFactory.class);
            factories.put("102", LaserSlopeMessageFactory.class);
            factories.put("105", LogSizeMessageFactory.class);
            factories.put("106", LogPacketMessageFactory.class);
            factories.put("107", CalibrationGuardDataMessagFactory.class);
            factories.put("108", SyncCalibrationMessageFactory.class);

            factories.put("109", EEPROMDataMessageFactory.class);

            // register Line Laser factories
            factories.put("70", GCLDevInfoMessageFactory.class);
            factories.put("71", SystemStateMessageFactory.class);
            factories.put("72", MotorOperationsMessageFactory.class);
            factories.put("73", SetLasersMessageFactory.class);
            factories.put("74", RemoteControlKeyMessageFactory.class);
            factories.put("75", PowerProfileMessageFactory.class);
            factories.put("76", LastCalibrationDataMessageFactory.class);
            factories.put("77", SyncCalibrationDataMessageFactory.class);
        }
    }

    @Override
    public MtMessage createMessage(MtFrame frame) {

        if (frame == null) {
            throw new IllegalArgumentException("MtFrame can't be null");
        }

        if (frame instanceof MtBaseFrame) {
            MtBaseFrame f = (MtBaseFrame) frame;
            int command = f.getCommand();
            System.err.println("=======================================: " + command);

            @SuppressWarnings("unchecked")
            Class<? extends MtMessageFactory> factoryClass = factories.get(Integer.toString(command));
            if (factoryClass == null) {
                factoryClass = SimpleMessageFactory.class;
            }

            MtMessageFactory factory;
            try {
                factory = factoryClass.newInstance();
            } catch (Exception e) {
                // fatal error
                throw new RuntimeException(e);
            }

            return factory.createMessage(frame);
        }

        throw new IllegalArgumentException("Can't create MtMessage from " + frame + "; Unknown frame!");
    }
}
