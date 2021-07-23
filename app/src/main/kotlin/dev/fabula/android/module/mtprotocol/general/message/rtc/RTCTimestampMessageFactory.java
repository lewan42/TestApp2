package dev.fabula.android.module.mtprotocol.general.message.rtc;

import dev.fabula.android.module.mtprotocol.MtFrame;
import dev.fabula.android.module.mtprotocol.MtMessage;
import dev.fabula.android.module.mtprotocol.MtMessageFactory;
import dev.fabula.android.module.mtprotocol.general.message.rtc.RTCTimestampMessage;
import dev.fabula.android.module.mtprotocol.glm100C.frame.MtBaseFrame;

/**
 * Factory for device response to command 15
 * Get RealTimeClock Timestamp
 * 
 * @author tos2si1
 */
public class RTCTimestampMessageFactory implements MtMessageFactory {
	
	/* (non-Javadoc)
	 * dev.fabula.android.module.mtprotocolotocol.MtMessageFactory#createMedev.fabula.android.module.mtprotocolrotocol.MtFrame)
	 */
	@Override
	public MtMessage createMessage(MtFrame frame) {
		if(frame instanceof MtBaseFrame){
			MtBaseFrame f = (MtBaseFrame) frame;
			f.reset();
			
			RTCTimestampMessage message = new RTCTimestampMessage();

			// byte 1, 2, 3, 4
			message.setRtcTimestamp(f.popUint32FromPayloadData());
			return message;
		}

		throw new IllegalArgumentException("Can't create RTCTimestampMessage from " + frame);
	}
}
