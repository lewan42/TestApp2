package dev.fabula.android.module.mtprotocol.glm100C.message.edc;

import android.util.Log;

import java.nio.charset.StandardCharsets;

import dev.fabula.android.module.mtprotocol.MtFrame;
import dev.fabula.android.module.mtprotocol.MtMessage;
import dev.fabula.android.module.mtprotocol.MtMessageFactory;
import dev.fabula.android.module.mtprotocol.glm100C.frame.MtBaseFrame;
import dev.fabula.android.module.mtprotocol.glm100C.message.edc.EDCInputMessage;
import dev.fabula.android.module.mtprotocol.type.field.BitField;
import dev.fabula.android.module.mtprotocol.type.field.Field;

/**
 * @author tos2si1
 */
public class EDCMessageFactory implements MtMessageFactory {

    @Override
    public MtMessage createMessage(MtFrame frame) {

        if (frame instanceof MtBaseFrame) {
            MtBaseFrame f = (MtBaseFrame) frame;
            f.reset();

            return createEDCInputMessage(f);
        }

        throw new IllegalArgumentException("Can't create SyncInputMessage from " + frame);
    }

    public EDCInputMessage createEDCInputMessage(MtBaseFrame f) {


        String s = new String(f.getPayloadData(), StandardCharsets.UTF_8);

        Log.e("EDCInputMessage: ", s);

        EDCInputMessage message = new EDCInputMessage();

        // byte 1
        DevModeRef devModeRef = new DevModeRef();
        devModeRef.setByte(f.popUint8FromPayloadData());

        message.setRefEdge(devModeRef.refEdge.getValue());
        message.setDevMode(devModeRef.devMode.getValue());

        // byte 2
        DevStatus devStatus = new DevStatus();
        devStatus.setByte(f.popUint8FromPayloadData());

        message.setLaserOn(devStatus.laserStatus.getValue());
        message.setTempStatus(devStatus.tempWarning.getValue());
        message.setBatLowStatus(devStatus.battWarning.getValue());
        message.setConfigUnits(devStatus.configUnits.getValue());
        message.setStatus(devStatus.deviceStatus.getValue()); // reserved; always set to 0

        // byte 3 + 4
        message.setMeasID(f.popUint16FromPayloadData());

        // bytes 5,6,7,8
        message.setResult(f.popFloatFromPayloadData());

        // bytes 9,10,11,12
        message.setComp1(f.popFloatFromPayloadData());

        // bytes 13,14,15,16
        message.setComp2(f.popFloatFromPayloadData());


        return message;
    }

    @SuppressWarnings("serial")
    class DevModeRef extends BitField {
        public Field refEdge = new Field(this, 2);
        public Field devMode = new Field(this, 6);
    }

    @SuppressWarnings("serial")
    class DevStatus extends BitField {
        public Field laserStatus = new Field(this, 1);
        public Field tempWarning = new Field(this, 1);
        public Field battWarning = new Field(this, 1);
        public Field configUnits = new Field(this, 1);
        public Field deviceStatus = new Field(this, 4);
    }

}
