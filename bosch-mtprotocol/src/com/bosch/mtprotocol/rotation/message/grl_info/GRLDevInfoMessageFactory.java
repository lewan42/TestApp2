package dev.fabula.android.module.mtprotocol.rotation.message.grl_info;

import dev.fabula.android.module.mtprotocol.MtFrame;
import dev.fabula.android.module.mtprotocol.MtMessage;
import dev.fabula.android.module.mtprotocol.MtMessageFactory;
import dev.fabula.android.module.mtprotocol.glm100C.frame.MtBaseFrame;

/**
 * Factory for parsing response message of GRL command 101 (Get Device Info)
 * Refer also to MT Protocol documentation
 * 
 * @author tos2si1
 */
public class GRLDevInfoMessageFactory implements MtMessageFactory {
	
	/* (non-Javadoc)
	 * dev.fabula.android.module.mtprotocolotocol.MtMessageFactory#createMedev.fabula.android.module.mtprotocolrotocol.MtFrame)
	 */
	@Override
	public MtMessage createMessage(MtFrame frame) {
		if(frame instanceof MtBaseFrame){
			MtBaseFrame f = (MtBaseFrame) frame;
			f.reset();
			
			GRLDevInfoMessage message = new GRLDevInfoMessage();

			// byte 0, 1
			message.setManufacturingYear(f.popUint16FromPayloadData());
			// byte 2
			message.setDevVariant(f.popUint8FromPayloadData());
			// byte 3, 4
			message.setSwRevision(f.popUint16FromPayloadData());
			
			return message;
		}

		throw new IllegalArgumentException("Can't create GRLDevInfoMessage from " + frame);
	}

}
