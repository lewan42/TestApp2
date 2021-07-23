package dev.fabula.android.module.mtprotocol.glm100C.message.edc;

import dev.fabula.android.module.mtprotocol.MtFrame;
import dev.fabula.android.module.mtprotocol.MtFrameFactory;
import dev.fabula.android.module.mtprotocol.MtMessage;
import dev.fabula.android.module.mtprotocol.glm100C.MtFrameConstants;
import dev.fabula.android.module.mtprotocol.glm100C.frame.MtRequestFrame;
import dev.fabula.android.module.mtprotocol.glm100C.message.edc.EDCDoRemoteTriggerButtonMessage;
import dev.fabula.android.module.mtprotocol.type.field.BitField;
import dev.fabula.android.module.mtprotocol.type.field.Field;

public class EDCDoRemoteFrameFactory implements MtFrameFactory, MtFrameConstants {
	
	@Override
	public MtFrame createFrame(MtMessage message) {
		
		if(message instanceof EDCDoRemoteTriggerButtonMessage) {
			EDCDoRemoteTriggerButtonMessage m = (EDCDoRemoteTriggerButtonMessage) message;
			
			MtRequestFrame frame = new MtRequestFrame(255);
			frame.setFrameMode(EN_FRAME_MODE_LONG_REQ_LONG_RESP);
			frame.setCommand((byte) 86);
			
			// payload byte 1 (ButtonNumber)
			ButtonNumber buttonNumber = new ButtonNumber();
			buttonNumber.buttonNumber.setValue(m.getButtonNumber());
			
			frame.pushUint8ToData(buttonNumber.getByte());
			
			return frame;
		}
		
		throw new IllegalArgumentException("Can't create MtFrame from " + message);
	}
	
	@SuppressWarnings("serial")
	class ButtonNumber extends BitField {
		public Field buttonNumber = new Field(this, 8);
	}
}
