/**
 * 
 */
package dev.fabula.android.module.mtprotocol;


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
