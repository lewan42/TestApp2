/**
 * 
 */
package dev.fabula.android.module.mtprotocol;


import dev.fabula.android.module.mtprotocol.MtFrame;
import dev.fabula.android.module.mtprotocol.MtMessage;

/**
 * @author AndrejsC
 *
 */
public interface MtFrameFactory {

	/**
	 * @param message
	 * @return
	 */
	public MtFrame createFrame(MtMessage message);

}
