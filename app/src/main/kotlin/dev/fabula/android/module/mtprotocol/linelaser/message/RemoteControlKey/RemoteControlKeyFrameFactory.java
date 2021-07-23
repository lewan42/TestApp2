package dev.fabula.android.module.mtprotocol.linelaser.message.RemoteControlKey;

import dev.fabula.android.module.mtprotocol.MtFrame;
import dev.fabula.android.module.mtprotocol.MtFrameFactory;
import dev.fabula.android.module.mtprotocol.MtMessage;
import dev.fabula.android.module.mtprotocol.glm100C.MtFrameConstants;
import dev.fabula.android.module.mtprotocol.glm100C.frame.MtRequestFrame;
import dev.fabula.android.module.mtprotocol.linelaser.message.RemoteControlKey.RemoteControlKeyOutputMessage;
import dev.fabula.android.module.mtprotocol.type.field.BitField;
import dev.fabula.android.module.mtprotocol.type.field.Field;

/**
 * Created by acn8kor on 4/27/2016.
 */
public class RemoteControlKeyFrameFactory implements MtFrameFactory, MtFrameConstants {
    @Override
    public MtFrame createFrame(MtMessage message) {

        if(message instanceof RemoteControlKeyOutputMessage){
            RemoteControlKeyOutputMessage m = (RemoteControlKeyOutputMessage) message;

            MtRequestFrame frame = new MtRequestFrame(255);
            frame.setFrameMode(EN_FRAME_MODE_LONG_REQ_LONG_RESP);
            frame.setCommand((byte) 74);

            SetLasers setLasers = new SetLasers();
            setLasers.keyValue.setValue(m.getKeyValue());
            frame.pushUint8ToData(setLasers.getByte());

            return frame;
        }

        throw new IllegalArgumentException("Can't create MtFrame from " + message);
    }

    @SuppressWarnings("serial")
    class SetLasers extends BitField {
        public Field keyValue = new Field(this, 8);
    }
}
