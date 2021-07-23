package dev.fabula.android.module.mtprotocol.linelaser.message.MotorOperations;

import dev.fabula.android.module.mtprotocol.MtFrame;
import dev.fabula.android.module.mtprotocol.MtMessage;
import dev.fabula.android.module.mtprotocol.MtMessageFactory;
import dev.fabula.android.module.mtprotocol.glm100C.frame.MtBaseFrame;


/**
 * Created by acn8kor on 4/15/2016.
 */
public class MotorOperationsMessageFactory implements MtMessageFactory {
    @Override
    public MtMessage createMessage(MtFrame frame) {
        if(frame instanceof MtBaseFrame){
            MtBaseFrame f = (MtBaseFrame) frame;
            f.reset();

            MotorOperationsInputMessage message = new MotorOperationsInputMessage();

            return message;
        }

        throw new IllegalArgumentException("Can't create MotorOperationsMessageFactory from " + frame);
    }
}
