package dev.fabula.android.module.mtprotocol.general.message.rtc;

import dev.fabula.android.module.mtprotocol.glm100C.message.SimpleMessage;

/**
 * Request for command 15 
 * Get RealTimeClock Timestamp
 * 
 * @author tos2si1
 */
public class GetRTCTimestampMessage extends SimpleMessage{
	
	public GetRTCTimestampMessage() {
		super((byte) 15);
	}

}
