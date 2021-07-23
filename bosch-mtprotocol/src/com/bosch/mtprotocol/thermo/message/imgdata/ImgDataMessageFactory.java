/**
 * 
 */
package dev.fabula.android.module.mtprotocol.thermo.message.imgdata;

import java.util.Arrays;

import dev.fabula.android.module.mtprotocol.MtFrame;
import dev.fabula.android.module.mtprotocol.MtMessage;
import dev.fabula.android.module.mtprotocol.MtMessageFactory;
import dev.fabula.android.module.mtprotocol.glm100C.frame.MtBaseFrame;

import sun.rmi.runtime.Log;

/**
 * @author tos2si1
 *
 */
public class ImgDataMessageFactory implements MtMessageFactory {
	
	public final static int BASIC_PAYLOAD_SIZE = 4;
	private byte [] payloadFull;

	@Override
	public MtMessage createMessage(MtFrame frame) {

		if(frame instanceof MtBaseFrame){
			MtBaseFrame f = (MtBaseFrame) frame;
			
			//payload with correct position (set to last pushed byte)
			payloadFull = f.getPayloadData();
			f.reset();
			
			return createImgDataInputMessage(f);
		}

		throw new IllegalArgumentException("Can't create SyncInputMessage from " + frame);
	}

	
	public ImgDataInputMessage createImgDataInputMessage(MtBaseFrame f) {

		ImgDataInputMessage message = new ImgDataInputMessage();

		System.err.println("IMAGE: "+message.toString());
		// byte 1 + 2  packageIndex
		message.setPackageIndex(f.popUint16FromPayloadData());
		
		// byte 3 + 4 measID
		message.setMeasID(f.popUint16FromPayloadData());	
		
		//remaining bytes
		if (payloadFull.length > BASIC_PAYLOAD_SIZE) {
			byte[] payloadCut = Arrays.copyOfRange(payloadFull, BASIC_PAYLOAD_SIZE, payloadFull.length);
			message.setImgData(payloadCut);
		}else if(payloadFull.length == BASIC_PAYLOAD_SIZE){
			message.setLastPackage(true);
		}
		
		return message;
	}

}
