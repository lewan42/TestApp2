package dev.fabula.android.module.mtprotocol.linelaser.message.GCLDevInfo;

import dev.fabula.android.module.mtprotocol.MtFrame;
import dev.fabula.android.module.mtprotocol.MtFrameFactory;
import dev.fabula.android.module.mtprotocol.MtMessage;
import dev.fabula.android.module.mtprotocol.glm100C.MtFrameConstants;
import dev.fabula.android.module.mtprotocol.glm100C.frame.MtRequestFrame;
import dev.fabula.android.module.mtprotocol.linelaser.message.GCLDevInfo.GCLDevInfoOutputMessage;
import dev.fabula.android.module.mtprotocol.type.field.BitField;
import dev.fabula.android.module.mtprotocol.type.field.Field;

/**
 * Created by acn8kor on 4/18/2016.
 */
public class GCLDevInfoFrameFactory implements MtFrameFactory, MtFrameConstants {


    @Override
    public MtFrame createFrame(MtMessage message) {
        if(message instanceof GCLDevInfoOutputMessage){
            GCLDevInfoOutputMessage m= (GCLDevInfoOutputMessage)message;

            MtRequestFrame frame = new MtRequestFrame(255);
            frame.setFrameMode(EN_FRAME_MODE_LONG_REQ_LONG_RESP);
            frame.setCommand((byte) 70);

            GCLDeviceInfo gclDeviceInfo = new GCLDeviceInfo();

            gclDeviceInfo.subCommand.setValue(m.getSubCommand());
            frame.pushUint8ToData(gclDeviceInfo.getByte());

            return frame;
        }

        throw new IllegalArgumentException("Can't create MtFrame from " + message);
    }
    @SuppressWarnings("serial")
    class GCLDeviceInfo extends BitField {
        public Field subCommand=new Field(this,8);

    }

}
