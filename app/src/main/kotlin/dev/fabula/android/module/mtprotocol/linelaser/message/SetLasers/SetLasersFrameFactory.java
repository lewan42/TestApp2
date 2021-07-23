package dev.fabula.android.module.mtprotocol.linelaser.message.SetLasers;

import dev.fabula.android.module.mtprotocol.MtFrame;
import dev.fabula.android.module.mtprotocol.MtFrameFactory;
import dev.fabula.android.module.mtprotocol.MtMessage;
import dev.fabula.android.module.mtprotocol.glm100C.MtFrameConstants;
import dev.fabula.android.module.mtprotocol.glm100C.frame.MtRequestFrame;
import dev.fabula.android.module.mtprotocol.linelaser.message.SetLasers.SetLasersOutputMessage;
import dev.fabula.android.module.mtprotocol.type.field.BitField;
import dev.fabula.android.module.mtprotocol.type.field.Field;

/**
 * Frame factory for SetLaserOutputMessage
 * As described in command 73
 *
 * Created by acn8kor on 4/11/2016.
 */
public class SetLasersFrameFactory implements MtFrameFactory, MtFrameConstants {
    @Override
    public MtFrame createFrame(MtMessage message) {

        if(message instanceof SetLasersOutputMessage){
            SetLasersOutputMessage m = (SetLasersOutputMessage) message;

            MtRequestFrame frame = new MtRequestFrame(255);
            frame.setFrameMode(EN_FRAME_MODE_LONG_REQ_LONG_RESP);
            frame.setCommand((byte) 73);

            SetLasers setLasers = new SetLasers();
            setLasers.laser1.setValue(m.getLaser1());
            setLasers.laser2.setValue(m.getLaser2());
            setLasers.laser3.setValue(m.getLaser3());
            setLasers.reserveBits.setValue(0);
            setLasers.tmtOff.setValue(m.getTmtOff());
            setLasers.buzzer.setValue(m.getBuzzer());
            frame.pushUint8ToData(setLasers.getByte());

            return frame;
        }

        throw new IllegalArgumentException("Can't create MtFrame from " + message);
    }

    @SuppressWarnings("serial")
    class SetLasers extends BitField {
        public Field laser1 = new Field(this, 1);
        public Field laser2 = new Field(this, 1);
        public Field laser3 = new Field(this, 1);
        public Field reserveBits = new Field(this, 3);
        public Field tmtOff = new Field(this, 1);
        public Field buzzer = new Field(this, 1);
    }
}

