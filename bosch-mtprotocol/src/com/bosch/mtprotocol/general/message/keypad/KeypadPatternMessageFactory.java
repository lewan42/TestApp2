package dev.fabula.android.module.mtprotocol.general.message.keypad;

import dev.fabula.android.module.mtprotocol.MtFrame;
import dev.fabula.android.module.mtprotocol.MtMessage;
import dev.fabula.android.module.mtprotocol.MtMessageFactory;
import dev.fabula.android.module.mtprotocol.glm100C.frame.MtBaseFrame;

/**
 * Created by acn8kor on 6/15/2016.
 */
public class KeypadPatternMessageFactory implements MtMessageFactory {

    /* (non-Javadoc)
     * dev.fabula.android.module.mtprotocolotocol.MtMessageFactory#createMedev.fabula.android.module.mtprotocolrotocol.MtFrame)
     */
    @Override
    public MtMessage createMessage(MtFrame frame) {
        if(frame instanceof MtBaseFrame){
            MtBaseFrame f = (MtBaseFrame) frame;
            f.reset();

            KeypadPatternMessage message = new KeypadPatternMessage();

            // byte 1, 2, 3, 4
            message.setKeypadPattern(f.popUint32FromPayloadData());
            return message;
        }

        throw new IllegalArgumentException("Can't create KeypadPatternMessageFactory from " + frame);
    }
}
