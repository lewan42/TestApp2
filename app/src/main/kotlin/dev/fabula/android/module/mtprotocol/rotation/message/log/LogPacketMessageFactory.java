package dev.fabula.android.module.mtprotocol.rotation.message.log;

import dev.fabula.android.module.mtprotocol.MtFrame;
import dev.fabula.android.module.mtprotocol.MtMessage;
import dev.fabula.android.module.mtprotocol.MtMessageFactory;
import dev.fabula.android.module.mtprotocol.glm100C.frame.MtBaseFrame;
import dev.fabula.android.module.mtprotocol.rotation.message.log.LogPacketInputMessage;

/**
 * Factory for device response to command 106
 * Get Log Packet
 * 
 * @author tos2si1
 */
public class LogPacketMessageFactory implements MtMessageFactory {
	
	/* (non-Javadoc)
	 * dev.fabula.android.module.mtprotocolotocol.MtMessageFactory#createMedev.fabula.android.module.mtprotocolrotocol.MtFrame)
	 */
	@Override
	public MtMessage createMessage(MtFrame frame) {
		if(frame instanceof MtBaseFrame){
			MtBaseFrame f = (MtBaseFrame) frame;
			f.reset();

			LogPacketInputMessage message = new LogPacketInputMessage();

			// byte 0
			message.setDataType(f.popUint8FromPayloadData());
			
			// byte 1, 2
			message.setPacketNumber(f.popUint16FromPayloadData());
			
			// byte 3 to 7 (log packet 1)
			message.setDataP1(f.popUint8FromPayloadData());
			message.setTimestampP1(f.popUint32FromPayloadData());
			
			// byte 8 to 12 (log packet 2)
			message.setDataP2(f.popUint8FromPayloadData());
			message.setTimestampP2(f.popUint32FromPayloadData());
			
			return message;
		}

		throw new IllegalArgumentException("Can't create LogPacketInputMessage from " + frame);
	}

}
