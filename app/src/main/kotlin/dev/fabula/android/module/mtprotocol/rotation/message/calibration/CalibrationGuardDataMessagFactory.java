package dev.fabula.android.module.mtprotocol.rotation.message.calibration;

import dev.fabula.android.module.mtprotocol.MtFrame;
import dev.fabula.android.module.mtprotocol.MtMessage;
import dev.fabula.android.module.mtprotocol.MtMessageFactory;
import dev.fabula.android.module.mtprotocol.glm100C.frame.MtBaseFrame;
import dev.fabula.android.module.mtprotocol.rotation.message.calibration.CalibrationGuardDataInputMessage;
import dev.fabula.android.module.mtprotocol.type.field.BitField;
import dev.fabula.android.module.mtprotocol.type.field.Field;

/**
 * Factory for device response to command 107
 * Get Calibration Guard Data
 * 
 * @author tos2si1
 */
public class CalibrationGuardDataMessagFactory implements MtMessageFactory {
	
	/* (non-Javadoc)
	 * dev.fabula.android.module.mtprotocolotocol.MtMessageFactory#createMedev.fabula.android.module.mtprotocolrotocol.MtFrame)
	 */
	@Override
	public MtMessage createMessage(MtFrame frame) {
		if(frame instanceof MtBaseFrame){
			MtBaseFrame f = (MtBaseFrame) frame;
			f.reset();

			CalibrationGuardDataInputMessage message = new CalibrationGuardDataInputMessage();

			// byte 1
			CalGuard calGuard = new CalGuard();
			calGuard.setByte(f.popUint8FromPayloadData());
			message.setTempFailure(calGuard.tempFail.getValue());
			message.setShockFailure(calGuard.shockFail.getValue());
			message.setTimeFailure(calGuard.timeFail.getValue());
			
			// byte 2, 3, 4, 5
			message.setTempFailTimestamp(f.popUint32FromPayloadData());
			
			// byte 6, 7, 8, 9
			message.setShockFailTimestamp(f.popUint32FromPayloadData());
			
			// byte 10, 11, 12, 13
			message.setTimeFailTimestamp(f.popUint32FromPayloadData());
			
			// byte 14
			byte tempAtFailure = f.popUint8FromPayloadData();
			message.setTempAtFailure((int) tempAtFailure);
			
			return message;
		}

		throw new IllegalArgumentException("Can't create CalibrationGuardDataInputMessage from " + frame);
	}
	
	@SuppressWarnings("serial")
	class CalGuard extends BitField {
		public Field tempFail = new Field(this, 1);
		public Field shockFail = new Field(this, 1);
		public Field timeFail = new Field(this, 1);
		public Field reserved = new Field(this, 5);
	}
}
