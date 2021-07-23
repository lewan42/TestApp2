/**
 * 
 */
package dev.fabula.android.module.mtprotocol.glm100C.message.sync.list;

import dev.fabula.android.module.mtprotocol.MtFrame;
import dev.fabula.android.module.mtprotocol.MtFrameFactory;
import dev.fabula.android.module.mtprotocol.MtMessage;
import dev.fabula.android.module.mtprotocol.glm100C.MtFrameConstants;
import dev.fabula.android.module.mtprotocol.glm100C.frame.MtRequestFrame;
import dev.fabula.android.module.mtprotocol.glm100C.message.sync.list.SyncListOutputMessage;


/**
 * @author AndrejsC
 *
 */
public class SyncListFrameFactory implements MtFrameFactory, MtFrameConstants {

	/* (non-Javadoc)
	 * dev.fabula.android.module.mtprotocolotocol.MtFrameFactory#createdev.fabula.android.module.mtprotocolrotocol.MtMessage)
	 */
	@Override
	public MtFrame createFrame(MtMessage message) {
		
		if(message instanceof SyncListOutputMessage){
			SyncListOutputMessage m = (SyncListOutputMessage) message;

			MtRequestFrame frame = new MtRequestFrame(255);
			frame.setFrameMode(EN_FRAME_MODE_LONG_REQ_LONG_RESP);
			frame.setCommand((byte) 81);
			if(isValidMessage(m)){
				frame.pushUint8ToData((byte) m.getIndexFrom());
				frame.pushUint8ToData((byte) m.getIndexTo());
				return frame;
			}
		}

		throw new IllegalArgumentException("Can't create MtFrame from " + message);
	}

	private boolean isValidMessage(SyncListOutputMessage message){
		// indexFrom >= 0; indexTo >= 0
		// indexFrom <= 255 indexTo <= 255
		// indexTo >= indexFrom
		return (message.getIndexTo() >= 0 && message.getIndexTo() <= 255)
				&& message.getIndexFrom() >= 0 && message.getIndexTo() >= message.getIndexFrom();
	}
}
