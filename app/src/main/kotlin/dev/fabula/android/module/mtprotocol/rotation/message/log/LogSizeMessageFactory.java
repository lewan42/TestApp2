package dev.fabula.android.module.mtprotocol.rotation.message.log;

import dev.fabula.android.module.mtprotocol.MtFrame;
import dev.fabula.android.module.mtprotocol.MtMessage;
import dev.fabula.android.module.mtprotocol.MtMessageFactory;
import dev.fabula.android.module.mtprotocol.glm100C.frame.MtBaseFrame;
import dev.fabula.android.module.mtprotocol.rotation.message.log.LogSizeInputMessage;

/**
 * Factory for device response to command 105
 * Get Log Size in Packets
 * 
 * @author tos2si1
 */
public class LogSizeMessageFactory implements MtMessageFactory {
	
	/* (non-Javadoc)
	 * dev.fabula.android.module.mtprotocolotocol.MtMessageFactory#createMedev.fabula.android.module.mtprotocolrotocol.MtFrame)
	 */
	@Override
	public MtMessage createMessage(MtFrame frame) {
		if(frame instanceof MtBaseFrame){
			MtBaseFrame f = (MtBaseFrame) frame;
			f.reset();

			LogSizeInputMessage message = new LogSizeInputMessage();

			// byte 1, 2
			message.setCalibStoredSize(f.popUint16FromPayloadData());
			
			return message;
		}

		throw new IllegalArgumentException("Can't create LogSizeInputMessage from " + frame);
	}

}
