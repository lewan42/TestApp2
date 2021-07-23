/**
 * 
 */
package dev.fabula.android.module.mtprotocol.type;

import dev.fabula.android.module.mtprotocol.type.field.BitField;
import dev.fabula.android.module.mtprotocol.type.field.Field;




/**
 * @author AndrejsC
 *
 */
@SuppressWarnings("serial")
public class UnionUint32 extends BitField {
	public Field ui8Byte0 = new Field(this, 8);
	public Field ui8Byte1 = new Field(this, 8);
	public Field ui8Byte2 = new Field(this, 8);
	public Field ui8Byte3 = new Field(this, 8);
	
}
