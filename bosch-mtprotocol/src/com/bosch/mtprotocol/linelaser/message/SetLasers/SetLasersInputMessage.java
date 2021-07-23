package dev.fabula.android.module.mtprotocol.linelaser.message.SetLasers;

import dev.fabula.android.module.mtprotocol.MtMessage;

/**
 * Created by acn8kor on 4/11/2016.
 */
public class SetLasersInputMessage implements MtMessage {

    private int response;
    public int getResponse() {
        return response;
    }

    public void setResponse(int response) {
        this.response = response;
    }

    public String toString() {
        return "SetLasersInputMessage: [responseReceived=" + response+ "]";
    }

}
