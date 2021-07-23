package dev.fabula.android.module.mtprotocol.general.message.peer;

import dev.fabula.android.module.mtprotocol.MtFrame;
import dev.fabula.android.module.mtprotocol.MtFrameFactory;
import dev.fabula.android.module.mtprotocol.MtMessage;
import dev.fabula.android.module.mtprotocol.general.message.peer.SetActivePeerOutputMessage;
import dev.fabula.android.module.mtprotocol.glm100C.MtFrameConstants;
import dev.fabula.android.module.mtprotocol.glm100C.frame.MtRequestFrame;

/**
 * Factory for app request to MtProtocol command 61
 * Set active communication peer
 * 
 * @author tos2si1
 */
public class SetActivePeerFrameFactory implements MtFrameFactory, MtFrameConstants {
	
	@Override
	public MtFrame createFrame(MtMessage message) {
		if(message instanceof SetActivePeerOutputMessage) {
			SetActivePeerOutputMessage m = (SetActivePeerOutputMessage) message;
			
			MtRequestFrame frame = new MtRequestFrame(255);
			frame.setFrameMode(EN_FRAME_MODE_LONG_REQ_LONG_RESP);
			frame.setCommand((byte) 61);
			frame.pushUint8ToData((byte) m.getEnumActivePeer());
			frame.pushUint8ToData((byte) m.getComActivityStatus());
			frame.pushUint8ToData((byte) m.getByteChannelNumber());
			
			return frame;
		}
		
		throw new IllegalArgumentException("Can't create SetActivePeer frame from " + message);
	}

}
