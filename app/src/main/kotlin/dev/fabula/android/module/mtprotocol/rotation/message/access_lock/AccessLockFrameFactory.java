package dev.fabula.android.module.mtprotocol.rotation.message.access_lock;

import dev.fabula.android.module.mtprotocol.MtFrame;
import dev.fabula.android.module.mtprotocol.MtFrameFactory;
import dev.fabula.android.module.mtprotocol.MtMessage;
import dev.fabula.android.module.mtprotocol.glm100C.MtFrameConstants;
import dev.fabula.android.module.mtprotocol.glm100C.frame.MtRequestFrame;
import dev.fabula.android.module.mtprotocol.rotation.message.access_lock.AccessLockOutputMessage;
import dev.fabula.android.module.mtprotocol.type.field.BitField;
import dev.fabula.android.module.mtprotocol.type.field.Field;

/**
 * Factory for app request to command 104
 * Set Access Lock
 * 
 * @author tos2si1
 */
public class AccessLockFrameFactory implements MtFrameFactory, MtFrameConstants {

	/* (non-Javadoc)
	 * dev.fabula.android.module.mtprotocolotocol.MtFrameFactory#createdev.fabula.android.module.mtprotocolrotocol.MtMessage)
	 */
	@Override
	public MtFrame createFrame(MtMessage message) {
		
		if(message instanceof AccessLockOutputMessage){
			AccessLockOutputMessage m = (AccessLockOutputMessage) message;

			MtRequestFrame frame = new MtRequestFrame(255);
			frame.setFrameMode(EN_FRAME_MODE_LONG_REQ_LONG_RESP);
			frame.setCommand((byte) 104);
			
			AccessLockByte accessLock = new AccessLockByte();
			accessLock.accessLock.setValue(m.getAccessLock());
			frame.pushUint8ToData(accessLock.getByte());
			
			return frame;
		}

		throw new IllegalArgumentException("Can't create MtFrame from " + message);
	}
	
	@SuppressWarnings("serial")
	class AccessLockByte extends BitField {
		public Field accessLock = new Field(this, 8);
	}
}
