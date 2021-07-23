package dev.fabula.android.module.mtprotocol.linelaser.message.ClearCalibrationEvents;

import dev.fabula.android.module.mtprotocol.MtFrame;
import dev.fabula.android.module.mtprotocol.MtFrameFactory;
import dev.fabula.android.module.mtprotocol.MtMessage;
import dev.fabula.android.module.mtprotocol.glm100C.MtFrameConstants;
import dev.fabula.android.module.mtprotocol.glm100C.frame.MtRequestFrame;
import dev.fabula.android.module.mtprotocol.linelaser.message.ClearCalibrationEvents.ClearCalibrationEventsMessage;
import dev.fabula.android.module.mtprotocol.type.field.BitField;
import dev.fabula.android.module.mtprotocol.type.field.Field;

/**
 * Frame factory for output message to clear all calibration events on GLL device
 * Like described in command 78
 *
 * Created by tos2si1 on 20.06.2017.
 */

public class ClearCalibrationEventsFrameFactory implements MtFrameFactory, MtFrameConstants {

    @Override
    public MtFrame createFrame(MtMessage message) {

        if(message instanceof ClearCalibrationEventsMessage) {
            ClearCalibrationEventsMessage m = (ClearCalibrationEventsMessage) message;

            MtRequestFrame frame = new MtRequestFrame(255);
            frame.setFrameMode(EN_FRAME_MODE_LONG_REQ_LONG_RESP);
            frame.setCommand((byte) 78);

            // payload byte 1
            ClearCalEventsMessageFlags eventFlags = new ClearCalEventsMessageFlags();
            eventFlags.clearEvents.setValue(m.getClearEvents());

            frame.pushUint8ToData(eventFlags.getByte());

            return frame;
        }

        throw new IllegalArgumentException("Can't create MtFrame from " + message);
    }

    @SuppressWarnings("serial")
    class ClearCalEventsMessageFlags extends BitField {
        public Field clearEvents = new Field(this, 1);
        public Field reserved = new Field(this, 7);
    }
}
