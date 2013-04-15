package com.android.fitness.device;

import android.content.Context;
import android.telephony.TelephonyManager;

public class DeviceUtil {
	public static String getDeviceIMEI(Context context) {
		TelephonyManager telephonyManager = (TelephonyManager) context
				.getSystemService(Context.TELEPHONY_SERVICE);
		return telephonyManager.getDeviceId();
	}
}
