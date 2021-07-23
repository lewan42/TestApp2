/**
 * 
 */
package dev.fabula.android.module.mtprotocol.glm100C.event;

import dev.fabula.android.module.mtprotocol.MtMessage;
import dev.fabula.android.module.mtprotocol.MtProtocol.MTProtocolEvent;



/**
 * @author AndrejsC
 *
 */
public class MtProtocolReceiveMessageEvent implements MTProtocolEvent {

	private MtMessage message;

	/**
	 * @param message
	 */
	public MtProtocolReceiveMessageEvent(MtMessage message) {
		super();
		this.message = message;
	}

	/**
	 * @return the message
	 */
	public MtMessage getMessage() {
		return message;
	}

}
