package dev.fabula.android.module.mtprotocol.linelaser.message.GCLDevInfo;

import dev.fabula.android.module.mtprotocol.MtFrame;
import dev.fabula.android.module.mtprotocol.MtMessage;
import dev.fabula.android.module.mtprotocol.MtMessageFactory;
import dev.fabula.android.module.mtprotocol.glm100C.frame.MtBaseFrame;
import dev.fabula.android.module.mtprotocol.linelaser.message.GCLDevInfo.GCLDevInfoInputMessage;

import java.io.UnsupportedEncodingException;

/**
 * Created by acn8kor on 4/18/2016.
 * Updated by tos2si1 on 9/21/2016.
 */
public class GCLDevInfoMessageFactory implements MtMessageFactory {

    private final static int EOS_CHAR = 0;

    @Override
    public MtMessage createMessage(MtFrame frame) {
        if (frame instanceof MtBaseFrame){
            MtBaseFrame f = (MtBaseFrame) frame;
            f.reset();

            return createGCLDevInfoInput(f);
        }

        throw new IllegalArgumentException("Can't create GCLDevInfoMessageFactory from " + frame);
    }

    private GCLDevInfoInputMessage createGCLDevInfoInput(MtBaseFrame fr){

        GCLDevInfoInputMessage message= new GCLDevInfoInputMessage();

        // byte 0, sub command
        message.setSubCommand(fr.popUint8FromPayloadData());

        // bytes 1 to EOS, payload
        byte [] dateCodeByte = new byte[16];

        // get payload
        boolean notEOS = true;
        int index = 0;
        while (notEOS) {
            dateCodeByte[index] = fr.popUint8FromPayloadData();
            if (dateCodeByte[index] == EOS_CHAR) {
                notEOS = false;
            } else {
                index++;
            }
        }

        // trim payload
        byte [] trimmedByteData = new byte[index];
        System.arraycopy(dateCodeByte, 0, trimmedByteData, 0, index);

        // convert payload to String
        try {
            String dateCodeString = new String(trimmedByteData, "ISO-8859-1");
            message.setPayload(dateCodeString);
        } catch(UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return message;
    }
}
