package dev.fabula.android.module.mtprotocol;

import dev.fabula.android.module.mtprotocol.MtFrame;
import dev.fabula.android.module.mtprotocol.MtMessage;

/**
 * @author AndrejsC
 *
 */
public interface MtMessageFactory {

	/**
	 * @param frame
	 * @return
	 */
	public MtMessage createMessage(MtFrame frame);
	
}
