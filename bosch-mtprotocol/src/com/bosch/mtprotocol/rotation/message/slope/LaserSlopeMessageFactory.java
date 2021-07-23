package dev.fabula.android.module.mtprotocol.rotation.message.slope;

import dev.fabula.android.module.mtprotocol.MtFrame;
import dev.fabula.android.module.mtprotocol.MtMessage;
import dev.fabula.android.module.mtprotocol.MtMessageFactory;
import dev.fabula.android.module.mtprotocol.glm100C.frame.MtBaseFrame;
import dev.fabula.android.module.mtprotocol.type.field.BitField;
import dev.fabula.android.module.mtprotocol.type.field.Field;

/**
 * Factory for device response to command 103
 * Get Slope
 * 
 * @author tos2si1
 */
public class LaserSlopeMessageFactory implements MtMessageFactory {

	/* (non-Javadoc)
	 * dev.fabula.android.module.mtprotocolotocol.MtMessageFactory#createMedev.fabula.android.module.mtprotocolrotocol.MtFrame)
	 */
	@Override
	public MtMessage createMessage(MtFrame frame) {
		if(frame instanceof MtBaseFrame){
			MtBaseFrame f = (MtBaseFrame) frame;
			f.reset();

			LaserSlopeMessage message = new LaserSlopeMessage();

			// byte 1
			SlopeMode slopeMode = new SlopeMode();
			slopeMode.setByte(f.popUint8FromPayloadData());
			message.setLevellingMode(slopeMode.levellingMode.getValue());
			message.setxValidity(slopeMode.xValidity.getValue());
			message.setyValidity(slopeMode.yValidity.getValue());

			
			// byte 2
			byte xData = f.popUint8FromPayloadData();
			message.setxData((int) xData);
			
			// byte 3
			byte yData = f.popUint8FromPayloadData();
			message.setyData((int) yData);
			
			return message;
		}

		throw new IllegalArgumentException("Can't create LaserSlopeMessage from " + frame);
	}
	
	@SuppressWarnings("serial")
	class SlopeMode extends BitField {
		public Field xValidity = new Field(this, 1);
		public Field yValidity = new Field(this, 1);
		public Field levellingMode = new Field(this, 1);
		public Field reserved = new Field(this, 5);
	}
}
