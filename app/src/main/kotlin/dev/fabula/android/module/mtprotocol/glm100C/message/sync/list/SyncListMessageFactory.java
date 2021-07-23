/**
 * 
 */
package dev.fabula.android.module.mtprotocol.glm100C.message.sync.list;

import dev.fabula.android.module.mtprotocol.MtFrame;
import dev.fabula.android.module.mtprotocol.MtMessage;
import dev.fabula.android.module.mtprotocol.MtMessageFactory;
import dev.fabula.android.module.mtprotocol.glm100C.frame.MtBaseFrame;
import dev.fabula.android.module.mtprotocol.glm100C.message.sync.SyncInputMessage;
import dev.fabula.android.module.mtprotocol.glm100C.message.sync.SyncMessageFactory;
import dev.fabula.android.module.mtprotocol.glm100C.message.sync.list.SyncListInputMessage;
import dev.fabula.android.module.mtprotocol.util.CastUtil;

/**
 * @author AndrejsC
 *
 */
public class SyncListMessageFactory implements MtMessageFactory {

	/* (non-Javadoc)
	 dev.fabula.android.module.mtprotocolprotocol.MtMessageFactory#createdev.fabula.android.module.mtprotocoltprotocol.MtFrame)
	 */
	@Override
	public MtMessage createMessage(MtFrame frame) {

		if(frame instanceof MtBaseFrame){
			MtBaseFrame f = (MtBaseFrame) frame;
			f.reset();

			SyncListInputMessage message = new SyncListInputMessage();
			
			// byte 1
			message.setIndexFrom(CastUtil.uByteToInt(f.popUint8FromPayloadData()));
			// byte 2
			message.setIndexTo(CastUtil.uByteToInt(f.popUint8FromPayloadData()));

			// sync containers
			for (int i = message.getIndexFrom(); i <= message.getIndexTo(); i++){
				SyncMessageFactory factory = new SyncMessageFactory();
				SyncInputMessage syncContainer = factory.createSyncInputMessage(f);
				message.getSyncContainers().add(syncContainer);
			}
			
			return message;
		}
		
		
		throw new IllegalArgumentException("Can't create SyncListInputMessage from " + frame);
	}

}
