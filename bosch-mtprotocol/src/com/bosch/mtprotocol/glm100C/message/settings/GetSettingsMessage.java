/**
 * 
 */
package dev.fabula.android.module.mtprotocol.glm100C.message.settings;

import dev.fabula.android.module.mtprotocol.glm100C.message.SimpleMessage;



/**
 * @author AndrejsC
 *
 */
public class GetSettingsMessage extends SimpleMessage {

	public GetSettingsMessage() {
		super((byte) 83);
	}

}
