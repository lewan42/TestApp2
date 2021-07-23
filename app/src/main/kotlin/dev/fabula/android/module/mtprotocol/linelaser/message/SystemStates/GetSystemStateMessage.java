package dev.fabula.android.module.mtprotocol.linelaser.message.SystemStates;

import dev.fabula.android.module.mtprotocol.glm100C.message.SimpleMessage;

/**
 * Created by acn8kor on 4/13/2016.
 */
public class GetSystemStateMessage extends SimpleMessage {

    public GetSystemStateMessage() {
        super((byte) 71);
    }
}
