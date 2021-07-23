package dev.fabula.android.module.mtprotocol.linelaser.message.GetPowerProfile;

import dev.fabula.android.module.mtprotocol.MtFrame;
import dev.fabula.android.module.mtprotocol.MtFrameFactory;
import dev.fabula.android.module.mtprotocol.MtMessage;
import dev.fabula.android.module.mtprotocol.glm100C.MtFrameConstants;
import dev.fabula.android.module.mtprotocol.glm100C.frame.MtRequestFrame;
import dev.fabula.android.module.mtprotocol.type.field.BitField;
import dev.fabula.android.module.mtprotocol.type.field.Field;

/**
 * Created by acn8kor on 4/29/2016.
 */
public class PowerProfileFrameFactory  implements MtFrameFactory, MtFrameConstants {
    @Override
    public MtFrame createFrame(MtMessage message) {

        if(message instanceof PowerProfileOutputMessage){
            PowerProfileOutputMessage m = (PowerProfileOutputMessage) message;

            MtRequestFrame frame = new MtRequestFrame(255);
            frame.setFrameMode(EN_FRAME_MODE_LONG_REQ_LONG_RESP);
            frame.setCommand((byte) 75);

            SetPowerProfile setPowerProfile = new SetPowerProfile();
            setPowerProfile.profileNumber.setValue(m.getProfileNumber());

            frame.pushUint8ToData(setPowerProfile.getByte());

            return frame;
        }

        throw new IllegalArgumentException("Can't create MtFrame from " + message);
    }

    @SuppressWarnings("serial")
    class SetPowerProfile extends BitField {
        public Field profileNumber = new Field(this, 8);

    }
}
