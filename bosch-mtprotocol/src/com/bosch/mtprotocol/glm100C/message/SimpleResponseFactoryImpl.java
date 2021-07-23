package dev.fabula.android.module.mtprotocol.glm100C.message;

import dev.fabula.android.module.mtprotocol.MtFrame;
import dev.fabula.android.module.mtprotocol.MtFrameFactory;
import dev.fabula.android.module.mtprotocol.MtMessage;
import dev.fabula.android.module.mtprotocol.glm100C.MtFrameConstants;
import dev.fabula.android.module.mtprotocol.glm100C.frame.MtResponseFrame;

public class SimpleResponseFactoryImpl implements MtFrameFactory, MtFrameConstants {

	@Override
	public MtFrame createFrame(MtMessage message) {
		
		if (message instanceof SimpleResponse) {
			SimpleResponse mes = (SimpleResponse) message;
			MtResponseFrame frame = new MtResponseFrame(0);
			frame.setFrameFormat(EN_FRAME_FORMAT_LONG);
			frame.setStatusByte(mes.getStatusByte());
			return frame;
		}

		throw new IllegalArgumentException("Can't create MtFrame from " + message);
	}
}
