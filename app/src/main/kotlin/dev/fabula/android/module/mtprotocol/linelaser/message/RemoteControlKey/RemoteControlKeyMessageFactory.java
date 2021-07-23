package dev.fabula.android.module.mtprotocol.linelaser.message.RemoteControlKey;

import dev.fabula.android.module.mtprotocol.MtFrame;
import dev.fabula.android.module.mtprotocol.MtMessage;
import dev.fabula.android.module.mtprotocol.MtMessageFactory;
import dev.fabula.android.module.mtprotocol.glm100C.frame.MtBaseFrame;
import dev.fabula.android.module.mtprotocol.linelaser.message.RemoteControlKey.RemoteControlKeyInputMessage;

/**
 * Created by acn8kor on 4/27/2016.
 */
public class RemoteControlKeyMessageFactory implements MtMessageFactory {
    @Override
    public MtMessage createMessage(MtFrame frame) {
        if (frame instanceof MtBaseFrame) {
            MtBaseFrame f = (MtBaseFrame) frame;
            f.reset();

            RemoteControlKeyInputMessage message = new RemoteControlKeyInputMessage();

            return message;
        }

        throw new IllegalArgumentException("Can't create RemoteControlKeyMessageFactory from " + frame);
    }
}