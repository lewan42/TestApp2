package dev.fabula.android.module.mtprotocol.rotation.message.calibration;

import dev.fabula.android.module.mtprotocol.MtMessage;

/**
 * Output message for command 108
 * Sync Cal Operations
 * 
 * @author tos2si1
 */
public class SyncCalibrationOutputMessage implements MtMessage {
	
	public final static int CALIBRATION_NO_CHANGE = 0;
	public final static int CALIBRATION_START = 1;
	public final static int CALIBRATION_COMPLETE = 2;
	
	private int xCal;
	private int yCal;
	private int zCal;
	private int devCal;
	/**
	 * @return the xCal
	 */
	public int getxCal() {
		return xCal;
	}
	/**
	 * @param xCal the xCal to set
	 */
	public void setxCal(int xCal) {
		this.xCal = xCal;
	}
	/**
	 * @return the yCal
	 */
	public int getyCal() {
		return yCal;
	}
	/**
	 * @param yCal the yCal to set
	 */
	public void setyCal(int yCal) {
		this.yCal = yCal;
	}
	/**
	 * @return the zCal
	 */
	public int getzCal() {
		return zCal;
	}
	/**
	 * @param zCal the zCal to set
	 */
	public void setzCal(int zCal) {
		this.zCal = zCal;
	}
	/**
	 * @return the devCal
	 */
	public int getDevCal() {
		return devCal;
	}
	/**
	 * @param devCal the devCal to set
	 */
	public void setDevCal(int devCal) {
		this.devCal = devCal;
	}
	
	public String toString() {
		return "SyncCalibrationInputMessage: [xCal=" + xCal + "; yCal=" + yCal
				+ "; zCal=" + zCal + "; devCal=" + devCal + "]";
	}

}
