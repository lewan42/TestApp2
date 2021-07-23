package dev.fabula.android.module.mtprotocol.glm100C.message;

import java.util.HashMap;
import java.util.Map;

import dev.fabula.android.module.mtprotocol.MtFrame;
import dev.fabula.android.module.mtprotocol.MtFrameFactory;
import dev.fabula.android.module.mtprotocol.MtMessage;
import dev.fabula.android.module.mtprotocol.general.message.echo.DoEchoFrameFactory;
import dev.fabula.android.module.mtprotocol.general.message.echo.DoEchoMessage;
import dev.fabula.android.module.mtprotocol.general.message.keypad.KeypadPatternFrameFactory;
import dev.fabula.android.module.mtprotocol.general.message.keypad.KeypadPatternMessage;
import dev.fabula.android.module.mtprotocol.general.message.peer.SetActivePeerFrameFactory;
import dev.fabula.android.module.mtprotocol.general.message.peer.SetActivePeerOutputMessage;
import dev.fabula.android.module.mtprotocol.general.message.rtc.RTCTimestampFrameFactory;
import dev.fabula.android.module.mtprotocol.general.message.rtc.RTCTimestampMessage;
import dev.fabula.android.module.mtprotocol.glm100C.message.edc.EDCDoRemoteFrameFactory;
import dev.fabula.android.module.mtprotocol.glm100C.message.edc.EDCDoRemoteTriggerButtonMessage;
import dev.fabula.android.module.mtprotocol.glm100C.message.edc.EDCFrameFactory;
import dev.fabula.android.module.mtprotocol.glm100C.message.edc.EDCOutputMessage;
import dev.fabula.android.module.mtprotocol.glm100C.message.settings.SettingsFrameFactory;
import dev.fabula.android.module.mtprotocol.glm100C.message.settings.SettingsMessage;
import dev.fabula.android.module.mtprotocol.glm100C.message.single.SingleDistFrameFactory;
import dev.fabula.android.module.mtprotocol.glm100C.message.single.SingleDistOutputMessage;
import dev.fabula.android.module.mtprotocol.glm100C.message.sync.SyncFrameFactory;
import dev.fabula.android.module.mtprotocol.glm100C.message.sync.SyncOutputMessage;
import dev.fabula.android.module.mtprotocol.glm100C.message.sync.list.SyncListFrameFactory;
import dev.fabula.android.module.mtprotocol.glm100C.message.sync.list.SyncListOutputMessage;
import dev.fabula.android.module.mtprotocol.linelaser.message.ClearCalibrationEvents.ClearCalibrationEventsFrameFactory;
import dev.fabula.android.module.mtprotocol.linelaser.message.ClearCalibrationEvents.ClearCalibrationEventsMessage;
import dev.fabula.android.module.mtprotocol.linelaser.message.GCLDevInfo.GCLDevInfoFrameFactory;
import dev.fabula.android.module.mtprotocol.linelaser.message.GCLDevInfo.GCLDevInfoOutputMessage;
import dev.fabula.android.module.mtprotocol.linelaser.message.GetPowerProfile.PowerProfileFrameFactory;
import dev.fabula.android.module.mtprotocol.linelaser.message.GetPowerProfile.PowerProfileOutputMessage;
import dev.fabula.android.module.mtprotocol.linelaser.message.MotorOperations.MotorOperationsFrameFactory;
import dev.fabula.android.module.mtprotocol.linelaser.message.MotorOperations.MotorOperationsOutputMessage;
import dev.fabula.android.module.mtprotocol.linelaser.message.RemoteControlKey.RemoteControlKeyFrameFactory;
import dev.fabula.android.module.mtprotocol.linelaser.message.RemoteControlKey.RemoteControlKeyOutputMessage;
import dev.fabula.android.module.mtprotocol.linelaser.message.SetLasers.SetLasersFrameFactory;
import dev.fabula.android.module.mtprotocol.linelaser.message.SetLasers.SetLasersOutputMessage;
import dev.fabula.android.module.mtprotocol.linelaser.message.SyncCalibrationData.SyncCalibrationDataFrameFactory;
import dev.fabula.android.module.mtprotocol.linelaser.message.SyncCalibrationData.SyncCalibrationDataOutputMessage;
import dev.fabula.android.module.mtprotocol.rotation.message.access_lock.AccessLockFrameFactory;
import dev.fabula.android.module.mtprotocol.rotation.message.access_lock.AccessLockOutputMessage;
import dev.fabula.android.module.mtprotocol.rotation.message.calibration.SyncCalibrationFrameFactory;
import dev.fabula.android.module.mtprotocol.rotation.message.calibration.SyncCalibrationOutputMessage;
import dev.fabula.android.module.mtprotocol.rotation.message.eeprom_data.EEPROMDATAFrameFactory;
import dev.fabula.android.module.mtprotocol.rotation.message.eeprom_data.EEPROMDataOutputMessage;
import dev.fabula.android.module.mtprotocol.rotation.message.log.LogPacketFrameFactory;
import dev.fabula.android.module.mtprotocol.rotation.message.log.LogPacketOutputMessage;
import dev.fabula.android.module.mtprotocol.rotation.message.log.LogSizeFrameFactory;
import dev.fabula.android.module.mtprotocol.rotation.message.log.LogSizeOutputMessage;
import dev.fabula.android.module.mtprotocol.rotation.message.slope.LaserSlopeFrameFactory;
import dev.fabula.android.module.mtprotocol.rotation.message.slope.LaserSlopeMessage;
import dev.fabula.android.module.mtprotocol.rotation.message.status.SyncStatusFrameFactory;
import dev.fabula.android.module.mtprotocol.rotation.message.status.SyncStatusOutputMessage;
import dev.fabula.android.module.mtprotocol.thermo.message.edct.EDCTFrameFactory;
import dev.fabula.android.module.mtprotocol.thermo.message.edct.EDCTOutputMessage;
// import MT protocol general classes
// import LRF specific classes
// import Thermo specific classes

public class FrameFactoryImpl implements MtFrameFactory{

	// A list of supported factories
	@SuppressWarnings("rawtypes")
	private static Map<String, Class> factories = new HashMap<String, Class>();

	static{
		synchronized (factories) {
			// register simple message factory
			registerFactory(SimpleMessage.class, SimpleFrameFactoryImpl.class);
			registerFactory(SimpleResponse.class, SimpleResponseFactoryImpl.class);
			
			// register general factories
			registerFactory(RTCTimestampMessage.class, RTCTimestampFrameFactory.class);
			registerFactory(KeypadPatternMessage.class, KeypadPatternFrameFactory.class);
			registerFactory(SetActivePeerOutputMessage.class, SetActivePeerFrameFactory.class);
			registerFactory(DoEchoMessage.class, DoEchoFrameFactory.class);
			
			// register LRF factories
			registerFactory(SingleDistOutputMessage.class, SingleDistFrameFactory.class);
			registerFactory(SettingsMessage.class, SettingsFrameFactory.class);
			registerFactory(SyncOutputMessage.class, SyncFrameFactory.class);
			registerFactory(SyncListOutputMessage.class, SyncListFrameFactory.class);
			registerFactory(EDCOutputMessage.class, EDCFrameFactory.class);
			registerFactory(EDCDoRemoteTriggerButtonMessage.class, EDCDoRemoteFrameFactory.class);
			
			// register Thermo factories
			registerFactory(EDCTOutputMessage.class, EDCTFrameFactory.class);
			
			// register Rotation factories
			registerFactory(SyncStatusOutputMessage.class, SyncStatusFrameFactory.class);
			registerFactory(LaserSlopeMessage.class, LaserSlopeFrameFactory.class);
			registerFactory(AccessLockOutputMessage.class, AccessLockFrameFactory.class);
			registerFactory(LogSizeOutputMessage.class, LogSizeFrameFactory.class);
			registerFactory(LogPacketOutputMessage.class, LogPacketFrameFactory.class);
			registerFactory(SyncCalibrationOutputMessage.class, SyncCalibrationFrameFactory.class);

			registerFactory(EEPROMDataOutputMessage.class, EEPROMDATAFrameFactory.class);

			// register Line Laser factories
			registerFactory(GCLDevInfoOutputMessage.class, GCLDevInfoFrameFactory.class);
			registerFactory(SetLasersOutputMessage.class, SetLasersFrameFactory.class);
			registerFactory(MotorOperationsOutputMessage.class, MotorOperationsFrameFactory.class);
			registerFactory(RemoteControlKeyOutputMessage.class, RemoteControlKeyFrameFactory.class);
			registerFactory(PowerProfileOutputMessage.class, PowerProfileFrameFactory.class);
			registerFactory(SyncCalibrationDataOutputMessage.class, SyncCalibrationDataFrameFactory.class);
			registerFactory(ClearCalibrationEventsMessage.class, ClearCalibrationEventsFrameFactory.class);

		}
	}	


	/* (non-Javadoc)
	 * @see de.bode.bosch.mtprotocolmeFactory#createFrame(de.bosde.bosch.mtprotocolage)
	 */
	@Override
	public MtFrame createFrame(MtMessage message) {
		if(message == null){
			throw new IllegalArgumentException("MtMessage can't be null");
		}

		@SuppressWarnings("unchecked")
		Class<? extends MtFrameFactory> factoryClass = factories.get(message.getClass().getSimpleName());
		if(factoryClass == null){
			factoryClass = SimpleFrameFactoryImpl.class;
		}

		MtFrameFactory factory;
		try {
			factory = factoryClass.newInstance();
		} catch (Exception e) {
			// fatal error
			throw new RuntimeException(e);
		}
		
		return factory.createFrame(message);
	}

	private static void registerFactory(Class<? extends MtMessage> messageClass, 
			Class<? extends MtFrameFactory> factoryClass){
		factories.put(messageClass.getSimpleName(), factoryClass);
	}
}
