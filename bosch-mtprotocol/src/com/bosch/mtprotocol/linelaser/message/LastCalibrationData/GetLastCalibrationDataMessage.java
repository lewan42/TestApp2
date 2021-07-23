package dev.fabula.android.module.mtprotocol.linelaser.message.LastCalibrationData;

import dev.fabula.android.module.mtprotocol.glm100C.message.SimpleMessage;

/**
 * Created by tos2si1 on 10.05.2017.
 */

public class GetLastCalibrationDataMessage extends SimpleMessage {

    public GetLastCalibrationDataMessage() {
        super((byte) 76);
    }
}
