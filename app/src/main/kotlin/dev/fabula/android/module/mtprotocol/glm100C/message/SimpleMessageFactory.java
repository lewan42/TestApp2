package dev.fabula.android.module.mtprotocol.glm100C.message;

import dev.fabula.android.module.mtprotocol.MtFrame;
import dev.fabula.android.module.mtprotocol.MtMessage;
import dev.fabula.android.module.mtprotocol.MtMessageFactory;
import dev.fabula.android.module.mtprotocol.glm100C.frame.MtBaseFrame;
import dev.fabula.android.module.mtprotocol.glm100C.message.SimpleMessage;


public class SimpleMessageFactory implements MtMessageFactory {

	/* (non-Javadoc)
	 * @see de.bde.bosch.mtprotocolssageFactory#createMessage(de.bode.bosch.mtprotocolme)
	 */
	@Override
	public MtMessage createMessage(MtFrame frame) {
		if(frame instanceof MtBaseFrame){
			MtBaseFrame f = (MtBaseFrame) frame;
			return new SimpleMessage(f.getCommand());
		}
		
		throw new IllegalArgumentException("Can't create SimpleMessage from " + frame);
	}

}
