/**
 * 
 */
package dev.fabula.android.module.mtprotocol.glm100C.message.settings;

import dev.fabula.android.module.mtprotocol.MtFrame;
import dev.fabula.android.module.mtprotocol.MtMessage;
import dev.fabula.android.module.mtprotocol.MtMessageFactory;
import dev.fabula.android.module.mtprotocol.glm100C.frame.MtBaseFrame;
import dev.fabula.android.module.mtprotocol.util.CastUtil;



/**
 * @author AndrejsC
 *
 */
public class SettingsMessageFactory implements MtMessageFactory {

	/* (non-Javadoc)
	 * dev.fabula.android.module.mtprotocolotocol.MtMessageFactory#createMedev.fabula.android.module.mtprotocolrotocol.MtFrame)
	 */
	@Override
	public MtMessage createMessage(MtFrame frame) {
		if(frame instanceof MtBaseFrame){
			MtBaseFrame f = (MtBaseFrame) frame;
			f.reset();
			
			SettingsMessage message = new SettingsMessage();

			// byte 1
			message.setSpiritLevelEnabled(CastUtil.uByteToInt(f.popUint8FromPayloadData()));
			// byte 2
			message.setDispRotationEnabled(CastUtil.uByteToInt(f.popUint8FromPayloadData()));
			// byte 3
			message.setSpeakerEnabled(CastUtil.uByteToInt(f.popUint8FromPayloadData()));
			// byte 4
			message.setLaserPointerEnabled(CastUtil.uByteToInt(f.popUint8FromPayloadData()));
			// byte 5
			message.setBacklightMode(CastUtil.uByteToInt(f.popUint8FromPayloadData()));
			// byte 6
			message.setAngleUnit(CastUtil.uByteToInt(f.popUint8FromPayloadData()));
			// byte 7
			message.setMeasurementUnit(CastUtil.uByteToInt(f.popUint8FromPayloadData()));
			// byte 8
			message.setDevConfiguration(CastUtil.uByteToInt(f.popUint8FromPayloadData()));
			// byte 9
			message.setLastUsedListIndex(CastUtil.uByteToInt(f.popUint8FromPayloadData()));;
			// byte 10, 11
			f.popUint8FromPayloadData();
			f.popUint8FromPayloadData();
			return message;
		}

		throw new IllegalArgumentException("Can't create SettingsMessage from " + frame);
	}

}
