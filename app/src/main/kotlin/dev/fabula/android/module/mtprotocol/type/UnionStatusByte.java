package dev.fabula.android.module.mtprotocol.type;

import dev.fabula.android.module.mtprotocol.type.field.BitField;
import dev.fabula.android.module.mtprotocol.type.field.Field;


//Bitfield class for the status byte.
@SuppressWarnings("serial")
public class UnionStatusByte extends BitField {
	
	public Field ui3ComStatus = new Field(this, 3);
	public Field ui3DeviceStatus = new Field(this, 3);
	public Field ui2FrameType = new Field(this, 2);
	
}