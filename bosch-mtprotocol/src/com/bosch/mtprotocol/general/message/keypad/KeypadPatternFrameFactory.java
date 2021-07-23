package dev.fabula.android.module.mtprotocol.general.message.keypad;

import dev.fabula.android.module.mtprotocol.MtFrame;
import dev.fabula.android.module.mtprotocol.MtFrameFactory;
import dev.fabula.android.module.mtprotocol.MtMessage;
import dev.fabula.android.module.mtprotocol.glm100C.MtFrameConstants;
import dev.fabula.android.module.mtprotocol.glm100C.frame.MtRequestFrame;

/**
 * Factory for app request to command 27
 * Set simulated keypad pattern
 * 
 * @author tos2si1
 */
public class KeypadPatternFrameFactory implements MtFrameFactory, MtFrameConstants {
	
	/* (non-Javadoc)
	 * dev.fabula.android.module.mtprotocolotocol.MtFrameFactory#createdev.fabula.android.module.mtprotocolrotocol.MtMessage)
	 */
	@Override
	public MtFrame createFrame(MtMessage message) {
		
		if(message instanceof KeypadPatternMessage){
			KeypadPatternMessage m = (KeypadPatternMessage) message;

			MtRequestFrame frame = new MtRequestFrame(255);
			frame.setFrameMode(EN_FRAME_MODE_LONG_REQ_LONG_RESP);
			frame.setCommand((byte) 27);
			frame.pushUint32ToData(m.getKeypadPattern());
			return frame;
		}

		throw new IllegalArgumentException("Can't create MtFrame from " + message);
	}
}
