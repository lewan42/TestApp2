/**
 *
 */
package dev.fabula.android.module.mtprotocol.glm100C.frame;

import dev.fabula.android.module.mtprotocol.MtFrame;
import dev.fabula.android.module.mtprotocol.glm100C.MtFrameConstants;
import dev.fabula.android.module.mtprotocol.glm100C.frame.MtRequestFrame;
import dev.fabula.android.module.mtprotocol.glm100C.frame.MtResponseFrame;
import dev.fabula.android.module.mtprotocol.type.UnionUint16;
import dev.fabula.android.module.mtprotocol.util.Crc;

import java.nio.ByteBuffer;
import java.util.logging.Logger;


/**
 * @author AndrejsC
 *
 */
public class MtFrameByteWriter implements MtFrameConstants {

    private MtFrame frame;
    private final static Logger LOG = Logger.getLogger(dev.fabula.android.module.mtprotocol.glm100C.frame.MtFrameByteWriter.class.getName());

    /**
     * @param frame bufferSize
     */
    public MtFrameByteWriter(MtFrame frame) {
        super();
        this.frame = frame;
    }

    public int write(byte[] out) {

        ByteBuffer byteBuffer = ByteBuffer.wrap(out);

        if (frame instanceof MtRequestFrame) {
            writeRequest(byteBuffer);
        } else if (frame instanceof MtResponseFrame) {
            writeResponse(byteBuffer);
        }

        return byteBuffer.position();
    }

    private void writeRequest(ByteBuffer byteBuffer) {

        MtRequestFrame mtRequestFrame = (MtRequestFrame) frame;

        LOG.warning("COMMAND: " + mtRequestFrame.getCommand());
        LOG.warning("ui2RequestFrameFormat: " + mtRequestFrame.getFrameMode().ui2RequestFrameFormat.toString());

        byteBuffer.put(mtRequestFrame.getFrameMode().getByte());
        byteBuffer.put(mtRequestFrame.getCommand());

        int frameFormat = mtRequestFrame.getFrameMode().ui2RequestFrameFormat.getValue();

        LOG.warning("FRAME: " + frameFormat);

        switch (frameFormat) {
            case EN_FRAME_FORMAT_SHORT:
                // Push Crc
                LOG.warning("EN_FRAME_FORMAT_SHORT");
                byteBuffer.put(Crc.calcCrc8(getBytes(byteBuffer)));
                break;

            case EN_FRAME_FORMAT_LONG:
                LOG.warning("EN_FRAME_FORMAT_LONG");
                // Push Size
                byteBuffer.put((byte) mtRequestFrame.getPayloadData().length);
                // Push data
                byteBuffer.put(mtRequestFrame.getPayloadData());
                // Push CRC
                byteBuffer.put(Crc.calcCrc8(getBytes(byteBuffer)));
                break;

            case EN_FRAME_FORMAT_EXT:
                LOG.warning("EN_FRAME_FORMAT_EXT");
                // Push Size
                UnionUint16 unPayloadSize = new UnionUint16();
                unPayloadSize.setValue(mtRequestFrame.getPayloadData().length);
                byteBuffer.put(unPayloadSize.ui8LSB.getByte());
                byteBuffer.put(unPayloadSize.ui8MSB.getByte());
                // Push data
                byteBuffer.put(mtRequestFrame.getPayloadData());
                // Push Crc
                byteBuffer.putShort(Crc.calcCrc16(getBytes(byteBuffer)));
                break;

            default:
                break;
        }
    }

    private void writeResponse(ByteBuffer byteBuffer) {
        MtResponseFrame mtResponseFrame = (MtResponseFrame) frame;

        byteBuffer.put(mtResponseFrame.getStatusByte().getByte());

        LOG.warning("ui2ResponseFrameFormat: " + mtResponseFrame.getFrameFormat());

        //Add the mode dependent part of the frame
        switch (mtResponseFrame.getFrameFormat()) {

            case EN_FRAME_FORMAT_SHORT:
                LOG.warning("EN_FRAME_FORMAT_SHORT");
                // Push Crc
                byteBuffer.put(Crc.calcCrc8(getBytes(byteBuffer)));
                break;

            case EN_FRAME_FORMAT_LONG:
                LOG.warning("EN_FRAME_FORMAT_LONG");
                // Push Size
                byteBuffer.put((byte) mtResponseFrame.getPayloadData().length);
                // Push data
                byteBuffer.put(mtResponseFrame.getPayloadData());
                // Push CRC
                byteBuffer.put(Crc.calcCrc8(getBytes(byteBuffer)));
                break;

            case EN_FRAME_FORMAT_EXT:
                LOG.warning("EN_FRAME_FORMAT_EXT");
                // Push Command
                byteBuffer.put(mtResponseFrame.getCommand());
                // Push Size
                UnionUint16 unPayloadSize = new UnionUint16();
                unPayloadSize.setValue(mtResponseFrame.getPayloadData().length);
                byteBuffer.put(unPayloadSize.ui8LSB.getByte());
                byteBuffer.put(unPayloadSize.ui8MSB.getByte());
                // Push data
                byteBuffer.put(mtResponseFrame.getPayloadData());
                // Push Crc
                byteBuffer.putShort(Crc.calcCrc16(getBytes(byteBuffer)));
                break;

            default:
                break;
        }
        ; //end of switch
    }

    public byte[] getBytes(ByteBuffer byteBuffer) {

        byte[] b = new byte[byteBuffer.position()];
        byteBuffer.position(0);
        byteBuffer.get(b, 0, b.length);
        return b;
    }

}
