package dev.fabula.android.module.mtprotocol.rotation.message.calibration;

import dev.fabula.android.module.mtprotocol.glm100C.message.SimpleMessage;

/**
 * Request for command 107 
 * Get Calibration Guard Data
 * 
 * @author tos2si1
 */
public class GetCalibrationGuardDataMessage extends SimpleMessage {
	
	public GetCalibrationGuardDataMessage() {
		super((byte) 107);
	}
}
