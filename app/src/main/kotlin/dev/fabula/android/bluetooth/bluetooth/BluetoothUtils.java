package dev.fabula.android.bluetooth.bluetooth;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Collection of helper methods and constants for Bluetooth and BLE handling
 *
 * Created by tos2si1 on 06.02.2018.
 */

public class BluetoothUtils {

    /**
     * Static map for GLM 120 family devices. Bare tool number is key. Device name is value.
     */
    public static final Map<String, String> GLM_120_DEV_TYPES = new HashMap<>();
    static {
        GLM_120_DEV_TYPES.put("3601K72F00", "Bosch GLM 120 C");
        GLM_120_DEV_TYPES.put("00F27K1063", "Bosch GLM 120 C");
        GLM_120_DEV_TYPES.put("3601K72F10", "Bosch GLM400C");
        GLM_120_DEV_TYPES.put("01F27K1063", "Bosch GLM400C");
        GLM_120_DEV_TYPES.put("3601K72F13", "Bosch GLM400CL");
        GLM_120_DEV_TYPES.put("13F27K1063", "Bosch GLM400CL");
        GLM_120_DEV_TYPES.put("3601K72FK0", "Bosch GLM 150 C");
        GLM_120_DEV_TYPES.put("0KF27K1063", "Bosch GLM 150 C");
        GLM_120_DEV_TYPES.put("3601K72F50", "Bosch GLM 150 C");
        GLM_120_DEV_TYPES.put("05F27K1063", "Bosch GLM 150 C");
        GLM_120_DEV_TYPES.put("3601K72FC0", "Bosch GLM 150 C");
        GLM_120_DEV_TYPES.put("0CF27K1063", "Bosch GLM 150 C");
        GLM_120_DEV_TYPES.put("0925219062", "Bosch GLM CAM CSAM");
        GLM_120_DEV_TYPES.put("2609125290", "Bosch GLM CAM CSAM");
        GLM_120_DEV_TYPES.put("          ", "Bosch GLM CAM BSAM");
    }

    /**
     * Validates if the paired device is a GLM 100 device
     *
     * @param device device to be validated
     * @return true if validation successful
     */
    public static boolean validateGLM100Name(MTBluetoothDevice device) {
        return device!=null && device.getDisplayName() != null
                && device.getDisplayName().toLowerCase(Locale.getDefault()).contains("bosch")
                && device.getDisplayName().toLowerCase(Locale.getDefault()).contains("glm1") //updated the name with postfix 1 to validate only for GLM100 devices. T
                && device.getDisplayName().toLowerCase(Locale.getDefault()).contains("100");
    }

    /**
     * Validates if the paired device is a GLM 50 device
     *
     * @param device device to be validated
     * @return true if validation successful
     */
    public static boolean validateGLM50Name(MTBluetoothDevice device) {
        return device!=null && device.getDisplayName() != null
                && device.getDisplayName().toLowerCase(Locale.getDefault()).contains("bosch")
                && device.getDisplayName().toLowerCase(Locale.getDefault()).contains("glm5") //updated the name with postfix 5 to validate only for GLM50 devices.
                && device.getDisplayName().toLowerCase(Locale.getDefault()).contains("50");
    }

    /**
     * Validates if the paired device is a GIS 1000 device
     *
     * @param device device to be validated
     * @return true if validation successful
     */
    public static boolean validateGISName(MTBluetoothDevice device) {
        return device.getDisplayName() != null
                && device.getDisplayName().toLowerCase(Locale.getDefault()).contains("bosch")
                && device.getDisplayName().toLowerCase(Locale.getDefault()).contains("gis")
                && device.getDisplayName().toLowerCase(Locale.getDefault()).contains("1000");

    }

    /**
     * Validates if the paired device is a PLR device
     *
     * @param device device to be validated
     * @return true if validation successful
     */
    public static boolean validatePLRName(MTBluetoothDevice device) {
        return device!=null && device.getDisplayName() != null
                && device.getDisplayName().toLowerCase(Locale.getDefault()).contains("bosch")
                && device.getDisplayName().toLowerCase(Locale.getDefault()).contains("plr")
                && (device.getDisplayName().toLowerCase(Locale.getDefault()).contains("30")
                || device.getDisplayName().toLowerCase(Locale.getDefault()).contains("40")
                || device.getDisplayName().toLowerCase(Locale.getDefault()).contains("50"));
    }

    /**
     * Validates if the paired device is a GLM 120 device
     *
     * @param device device to be validated
     * @return true if validation successful
     */
    public static boolean validateGLM120Name(MTBluetoothDevice device) {
        return device!=null && device.getDisplayName() != null && GLM_120_DEV_TYPES.containsValue(device.getDisplayName().substring(0, device.getDisplayName().indexOf("x") - 1));
        /*return device.getDisplayName() != null
                && device.getDisplayName().toLowerCase(Locale.getDefault()).contains("bosch")
                && device.getDisplayName().toLowerCase(Locale.getDefault()).contains("glm")
                && (device.getDisplayName().toLowerCase(Locale.getDefault()).contains("120")
                || device.getDisplayName().toLowerCase(Locale.getDefault()).contains("150")
                || device.getDisplayName().toLowerCase(Locale.getDefault()).contains("400")
                || device.getDisplayName().toLowerCase(Locale.getDefault()).contains("cam"));*/
    }

    /**
     * Validates if the paired device is a EDC based device
     *
     * @param device device to be validated
     * @return true if validation successful
     */
    public static boolean validateEDCDevice(MTBluetoothDevice device) {
        return validateGLM50Name(device) || validateGLM120Name(device) || validatePLRName(device);
    }

    /**
     * Validate Bosch device.
     *
     * @param deviceName the device
     * @return true, if successful
     */
    public static boolean validateDeviceName(String deviceName) {
        return deviceName != null && deviceName.toLowerCase(Locale.getDefault()).contains("bosch");
    }
}
