/**
 * 
 */
package dev.fabula.android.module.mtprotocol.glm100C.message.settings;

import dev.fabula.android.module.mtprotocol.MtFrame;
import dev.fabula.android.module.mtprotocol.MtFrameFactory;
import dev.fabula.android.module.mtprotocol.MtMessage;
import dev.fabula.android.module.mtprotocol.glm100C.MtFrameConstants;
import dev.fabula.android.module.mtprotocol.glm100C.frame.MtRequestFrame;
import dev.fabula.android.module.mtprotocol.glm100C.message.settings.SettingsMessage;


/**
 * @author AndrejsC
 *
 */
public class SettingsFrameFactory implements MtFrameFactory, MtFrameConstants {

	/* (non-Javadoc)
	 * dev.fabula.android.module.mtprotocolotocol.MtFrameFactory#createdev.fabula.android.module.mtprotocolrotocol.MtMessage)
	 */
	@Override
	public MtFrame createFrame(MtMessage message) {
		
		if(message instanceof SettingsMessage){
			SettingsMessage m = (SettingsMessage) message;

			MtRequestFrame frame = new MtRequestFrame(255);
			frame.setFrameMode(EN_FRAME_MODE_LONG_REQ_LONG_RESP);
			frame.setCommand((byte) 84);
			frame.pushUint8ToData((byte) m.getSpiritLevelEnabled());
			frame.pushUint8ToData((byte) m.getDispRotationEnabled());
			frame.pushUint8ToData((byte) m.getSpeakerEnabled());
			frame.pushUint8ToData((byte) m.getLaserPointerEnabled());
			frame.pushUint8ToData((byte) m.getBacklightMode());
			frame.pushUint8ToData((byte) m.getAngleUnit());
			frame.pushUint8ToData((byte) m.getMeasurementUnit());
			return frame;
		}

		throw new IllegalArgumentException("Can't create MtFrame from " + message);
	}

}
