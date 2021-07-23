package dev.fabula.android.module.mtprotocol.glm100C.message;

import dev.fabula.android.module.mtprotocol.MtFrame;
import dev.fabula.android.module.mtprotocol.MtFrameFactory;
import dev.fabula.android.module.mtprotocol.MtMessage;
import dev.fabula.android.module.mtprotocol.glm100C.MtFrameConstants;
import dev.fabula.android.module.mtprotocol.glm100C.frame.MtRequestFrame;
import dev.fabula.android.module.mtprotocol.glm100C.message.SimpleMessage;


public class SimpleFrameFactoryImpl implements MtFrameFactory, MtFrameConstants {

	@Override
	public MtFrame createFrame(MtMessage message) {
		
		if(message instanceof SimpleMessage){
			SimpleMessage simpleMessage = (SimpleMessage) message;
			MtRequestFrame frame = new MtRequestFrame(0);
			frame.setFrameMode(EN_FRAME_MODE_LONG_REQ_LONG_RESP);
			frame.setCommand(simpleMessage.getCommand());
			return frame;
		}
		
		throw new IllegalArgumentException("Can't create MtFrame from " + message);
	}

}
