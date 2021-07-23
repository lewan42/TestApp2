package dev.fabula.android.module.mtprotocol.glm100C.message.single;

import dev.fabula.android.module.mtprotocol.MtFrame;
import dev.fabula.android.module.mtprotocol.MtMessage;
import dev.fabula.android.module.mtprotocol.MtMessageFactory;
import dev.fabula.android.module.mtprotocol.glm100C.frame.MtBaseFrame;
import dev.fabula.android.module.mtprotocol.glm100C.message.single.SingleDistInputMessage;

/**
 * Factory for device response to LRF command 64
 * Get Single Distance Measurement
 * 
 * @author tos2si1
 */
public class SingleDistMessageFactory implements MtMessageFactory {
	
	/* (non-Javadoc)
	 * @see de.boscde.bosch.mtprotocolgeFactory#createMessage(de.boschde.bosch.mtprotocol
	 */
	@Override
	public MtMessage createMessage(MtFrame frame) {

		if(frame instanceof MtBaseFrame){
			MtBaseFrame f = (MtBaseFrame) frame;
			f.reset();

			return createSingleDistInputMessage(f);
		}

		throw new IllegalArgumentException("Can't create SingleDistInputMessage from " + frame);
	}
	
public SingleDistInputMessage createSingleDistInputMessage(MtBaseFrame f){

		SingleDistInputMessage message = new SingleDistInputMessage();

		// bytes 0, 1, 2, 3
		message.setDistance(f.popUint32FromPayloadData());
		
		return message;
	}

}
