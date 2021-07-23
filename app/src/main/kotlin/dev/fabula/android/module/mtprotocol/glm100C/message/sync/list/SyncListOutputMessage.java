/**
 * 
 */
package dev.fabula.android.module.mtprotocol.glm100C.message.sync.list;

import dev.fabula.android.module.mtprotocol.MtMessage;


/**
 * @author AndrejsC
 *
 */
public class SyncListOutputMessage implements MtMessage {

	private int indexFrom;
	private int indexTo;
	
	/**
	 * @return the indexFrom
	 */
	public int getIndexFrom() {
		return indexFrom;
	}
	/**
	 * @param indexFrom the indexFrom to set
	 */
	public void setIndexFrom(int indexFrom) {
		this.indexFrom = indexFrom;
	}
	/**
	 * @return the indexTo
	 */
	public int getIndexTo() {
		return indexTo;
	}
	/**
	 * @param indexTo the indexTo to set
	 */
	public void setIndexTo(int indexTo) {
		this.indexTo = indexTo;
	}
	
	
}
