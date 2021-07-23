package dev.fabula.android.module.mtprotocol.general.message.echo;

import dev.fabula.android.module.mtprotocol.MtFrame;
import dev.fabula.android.module.mtprotocol.MtFrameFactory;
import dev.fabula.android.module.mtprotocol.MtMessage;
import dev.fabula.android.module.mtprotocol.general.message.echo.DoEchoMessage;
import dev.fabula.android.module.mtprotocol.glm100C.MtFrameConstants;
import dev.fabula.android.module.mtprotocol.glm100C.frame.MtRequestFrame;

/**
 * Factory for app request to command 62
 * Do Echo
 *
 * @author tos2si1
 */

public class DoEchoFrameFactory implements MtFrameFactory, MtFrameConstants {

    @Override
    public MtFrame createFrame(MtMessage message) {

        if(message instanceof DoEchoMessage){
            DoEchoMessage m = (DoEchoMessage) message;

            MtRequestFrame frame = new MtRequestFrame(255);
            frame.setFrameMode(EN_FRAME_MODE_LONG_REQ_LONG_RESP);
            frame.setCommand((byte) 62);
            frame.pushUint32ToData(m.getPayload());
            //frame.pushUint8ToData(m.getByteload()[0]);
            //frame.pushUint8ToData(m.getByteload()[1]);
            //frame.pushUint8ToData(m.getByteload()[2]);
            //frame.pushUint8ToData(m.getByteload()[3]);
            //frame.pushUint8ToData(m.getByteload()[4]);
            return frame;
        }

        throw new IllegalArgumentException("Can't create MtFrame from " + message);
    }
}
