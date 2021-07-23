package dev.fabula.android.module.mtprotocol.rotation.message.eeprom_data;

import dev.fabula.android.module.mtprotocol.MtFrame;
import dev.fabula.android.module.mtprotocol.MtFrameFactory;
import dev.fabula.android.module.mtprotocol.MtMessage;
import dev.fabula.android.module.mtprotocol.glm100C.MtFrameConstants;
import dev.fabula.android.module.mtprotocol.glm100C.frame.MtRequestFrame;

/**
 * Factory for app request to command 109
 * Get EEPROM data with offset
 * 
 * @author tos2si1
 */
public class EEPROMDATAFrameFactory implements MtFrameFactory, MtFrameConstants {
	
	/* (non-Javadoc)
	 * dev.fabula.android.module.mtprotocolotocol.MtFrameFactory#createdev.fabula.android.module.mtprotocolrotocol.MtMessage)
	 */
	@Override
	public MtFrame createFrame(MtMessage message) {

		if(message instanceof EEPROMDataOutputMessage){
			EEPROMDataOutputMessage m = (EEPROMDataOutputMessage) message;

			MtRequestFrame frame = new MtRequestFrame(255);
			frame.setFrameMode(EN_FRAME_MODE_LONG_REQ_LONG_RESP);
			frame.setCommand((byte) 109);

			frame.pushUint16ToData((short) m.getOffset());
			frame.pushUint16ToData((short) m.getSize());

			return frame;
		}

		throw new IllegalArgumentException("Can't create MtFrame from " + message);
	}

}
