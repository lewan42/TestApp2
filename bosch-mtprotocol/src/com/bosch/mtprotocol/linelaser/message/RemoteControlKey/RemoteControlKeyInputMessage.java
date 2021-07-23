package dev.fabula.android.module.mtprotocol.linelaser.message.RemoteControlKey;

import dev.fabula.android.module.mtprotocol.MtMessage;

/**
 * Created by acn8kor on 4/27/2016.
 */
public class RemoteControlKeyInputMessage implements MtMessage {

    private int response;
    public int getResponse() {
        return response;
    }

    public void setResponse(int response) {
        this.response = response;
    }

    public String toString() {
        return "RemoteControlKeyInputMessage: [responseReceived=" + response+ "]";
    }

}