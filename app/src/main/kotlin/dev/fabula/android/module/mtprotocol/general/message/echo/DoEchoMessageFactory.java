package dev.fabula.android.module.mtprotocol.general.message.echo;

import dev.fabula.android.module.mtprotocol.MtFrame;
import dev.fabula.android.module.mtprotocol.MtMessage;
import dev.fabula.android.module.mtprotocol.MtMessageFactory;
import dev.fabula.android.module.mtprotocol.general.message.echo.DoEchoMessage;
import dev.fabula.android.module.mtprotocol.glm100C.frame.MtBaseFrame;

/**
 * Factory for device response to command 62
 * Do Echo
 *
 * @author tos2si1
 */

public class DoEchoMessageFactory implements MtMessageFactory {

    @Override
    public MtMessage createMessage(MtFrame frame) {
        if(frame instanceof MtBaseFrame){
            MtBaseFrame f = (MtBaseFrame) frame;
            f.reset();

            DoEchoMessage message = new DoEchoMessage();

            // byte 1, 2, 3, 4
            message.setPayload(f.popUint32FromPayloadData());

            // byte 1, 2, 3, 4, 5
            //byte[] temp = new byte[5];
            //temp[0] = f.popUint8FromPayloadData();
            //temp[1] = f.popUint8FromPayloadData();
            //temp[2] = f.popUint8FromPayloadData();
            //temp[3] = f.popUint8FromPayloadData();
            //temp[4] = f.popUint8FromPayloadData();
            //message.setByteload(temp);
            return message;
        }

        throw new IllegalArgumentException("Can't create DoEchoMessage from " + frame);
    }
}
