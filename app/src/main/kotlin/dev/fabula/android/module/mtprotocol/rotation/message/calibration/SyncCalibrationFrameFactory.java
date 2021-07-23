package dev.fabula.android.module.mtprotocol.rotation.message.calibration;

import dev.fabula.android.module.mtprotocol.MtFrame;
import dev.fabula.android.module.mtprotocol.MtFrameFactory;
import dev.fabula.android.module.mtprotocol.MtMessage;
import dev.fabula.android.module.mtprotocol.glm100C.MtFrameConstants;
import dev.fabula.android.module.mtprotocol.glm100C.frame.MtRequestFrame;
import dev.fabula.android.module.mtprotocol.rotation.message.calibration.SyncCalibrationOutputMessage;
import dev.fabula.android.module.mtprotocol.type.field.BitField;
import dev.fabula.android.module.mtprotocol.type.field.Field;

/**
 * Factory for app request to command 108
 * Sync Cal Operations
 * 
 * @author tos2si1
 */
public class SyncCalibrationFrameFactory implements MtFrameFactory, MtFrameConstants {
	
	/* (non-Javadoc)
	 * dev.fabula.android.module.mtprotocolotocol.MtFrameFactory#createdev.fabula.android.module.mtprotocolrotocol.MtMessage)
	 */
	@Override
	public MtFrame createFrame(MtMessage message) {
		
		if(message instanceof SyncCalibrationOutputMessage){
			SyncCalibrationOutputMessage m = (SyncCalibrationOutputMessage) message;

			MtRequestFrame frame = new MtRequestFrame(255);
			frame.setFrameMode(EN_FRAME_MODE_LONG_REQ_LONG_RESP);
			frame.setCommand((byte) 108);
			
			CalOperations calOp = new CalOperations();
			calOp.xCal.setValue(m.getxCal());
			calOp.yCal.setValue(m.getyCal());
			calOp.zCal.setValue(m.getzCal());
			calOp.devCal.setValue(m.getDevCal());
			frame.pushUint8ToData(calOp.getByte());
			
			return frame;
		}

		throw new IllegalArgumentException("Can't create MtFrame from " + message);
	}
	
	@SuppressWarnings("serial")
	class CalOperations extends BitField {
		public Field xCal = new Field(this, 2);
		public Field yCal = new Field(this, 2);
		public Field zCal = new Field(this, 2);
		public Field devCal = new Field(this, 2);
	}
}
