package dev.fabula.android.module.mtprotocol.thermo.message.edct;

import dev.fabula.android.module.mtprotocol.MtFrame;
import dev.fabula.android.module.mtprotocol.MtMessage;
import dev.fabula.android.module.mtprotocol.MtMessageFactory;
import dev.fabula.android.module.mtprotocol.glm100C.frame.MtBaseFrame;
import dev.fabula.android.module.mtprotocol.type.field.BitField;
import dev.fabula.android.module.mtprotocol.type.field.Field;

public class EDCTMessageFactory implements MtMessageFactory {

	@Override
	public MtMessage createMessage(MtFrame frame) {

		if(frame instanceof MtBaseFrame){
			MtBaseFrame f = (MtBaseFrame) frame;
			f.reset();

			return createEDCTInputMessage(f);
		}

		throw new IllegalArgumentException("Can't create SyncInputMessage from " + frame);
	}

	public EDCTInputMessage createEDCTInputMessage(MtBaseFrame f){

		EDCTInputMessage message = new EDCTInputMessage();

		// byte 1
		DevModeRef devModeRef = new DevModeRef();
		devModeRef.setByte(f.popUint8FromPayloadData());

		message.setPacketNum(devModeRef.packNumber.getValue());
		message.setDevMode(devModeRef.devMode.getValue());
		
		message.setReserved(devModeRef.reserved.getValue());

		// byte 2
		DevStatus devStatus = new DevStatus(); 
		devStatus.setByte(f.popUint8FromPayloadData());

		message.setAlarms(devStatus.alarms.getValue());
		message.setWarnAmbTemp(devStatus.warnAmbTemp.getValue());
		message.setWarnHumidity(devStatus.warnHumidity.getValue());
		message.setWarnDewPoint(devStatus.warnDewPoint.getValue());

		// byte 3 + 4
		message.setMeasID(f.popUint16FromPayloadData());

		// bytes 5,6,7,8
		message.setResult(f.popFloatFromPayloadData());

		// bytes 9,10,11,12
		message.setComp1(f.popFloatFromPayloadData());

		// bytes 13,14,15,16
		message.setComp2(f.popFloatFromPayloadData());

		return message;
	}

	@SuppressWarnings("serial")
	class DevModeRef extends BitField {
		public Field packNumber = new Field(this, 3);
		public Field devMode = new Field(this, 2);
		public Field reserved = new Field(this, 3); // unused; always set to 0
	}

	@SuppressWarnings("serial")
	class DevStatus extends BitField {
		public Field alarms = new Field(this, 2);
		public Field warnAmbTemp = new Field(this, 1);
		public Field warnHumidity = new Field(this, 1);
		public Field warnDewPoint = new Field(this, 1);
		public Field reserved = new Field(this, 3); // unused; always set to 0
	}

}
