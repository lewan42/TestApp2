package dev.fabula.android.module.mtprotocol.rotation.message.eeprom_data;

import dev.fabula.android.module.mtprotocol.MtFrame;
import dev.fabula.android.module.mtprotocol.MtMessage;
import dev.fabula.android.module.mtprotocol.MtMessageFactory;
import dev.fabula.android.module.mtprotocol.glm100C.frame.MtBaseFrame;

/**
 * Factory for device response to command 109
 * Get EEPROM data with offset
 * 
 * @author tos2si1
 */
public class EEPROMDataMessageFactory implements MtMessageFactory {

	private byte [] payloadFull;

	@Override
	public MtMessage createMessage(MtFrame frame) {

		if(frame instanceof MtBaseFrame){
			MtBaseFrame f = (MtBaseFrame) frame;
			
			// get whole payload as byte array
			payloadFull = f.getPayloadData();
			f.reset();
			
			return createEEPROMDataInputMessage(f);
		}

		throw new IllegalArgumentException("Can't create EEPROMDataInputMessage from " + frame);
	}

	
	public EEPROMDataInputMessage createEEPROMDataInputMessage(MtBaseFrame f) {

		EEPROMDataInputMessage message = new EEPROMDataInputMessage();
		
		// all bytes to data array
		if (payloadFull.length > 0) {
			message.setData(payloadFull);
		} 
		
		return message;
	}

}
