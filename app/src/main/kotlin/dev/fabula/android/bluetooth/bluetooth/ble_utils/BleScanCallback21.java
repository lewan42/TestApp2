package dev.fabula.android.bluetooth.bluetooth.ble_utils;

import android.annotation.TargetApi;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.os.Build;
import android.util.Log;

import java.util.List;

import dev.fabula.android.bluetooth.bluetooth.IBleScanCallback;
import dev.fabula.android.bluetooth.bluetooth.IScanResult;

/**
 * Bluetooth LE scan callback under Lollipop.
 *
 * @see android.bluetooth.le.BluetoothLeScanner#startScan
 */
@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class BleScanCallback21 extends ScanCallback {

    private static final String TAG = "BleScanCallback21";

    private final IBleScanCallback mBleScanCallback;

    /**
     * Create a new {@link BleScanCallback21} with the passed {@link IBleScanCallback}.
     *
     * @param scanCallback the {@link IBleScanCallback}
     */
    BleScanCallback21(final IBleScanCallback scanCallback) {
        this.mBleScanCallback = scanCallback;
    }

    @Override
    public void onScanResult(final int callbackType, final ScanResult result) {
        onScanResult(new ScanResultImpl21(result));
    }

    @Override
    public void onBatchScanResults(final List<ScanResult> results) {
        for (final ScanResult result : results) {
            onScanResult(new ScanResultImpl21(result));
        }
    }

    @Override
    public void onScanFailed(final int errorCode) {
        Log.e(TAG, "Scan failed with error Code: " + errorCode);
    }

    private void onScanResult(final IScanResult result) {
        mBleScanCallback.onScanResult(result);
    }
}
