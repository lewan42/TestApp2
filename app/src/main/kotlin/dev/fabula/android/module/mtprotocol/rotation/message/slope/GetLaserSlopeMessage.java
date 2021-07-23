package dev.fabula.android.module.mtprotocol.rotation.message.slope;

import dev.fabula.android.module.mtprotocol.glm100C.message.SimpleMessage;

/**
 * Request for command 103 
 * Get Slope message
 * 
 * @author tos2si1
 */
public class GetLaserSlopeMessage extends SimpleMessage {
	
	public GetLaserSlopeMessage() {
		super((byte) 103);

	}

}
