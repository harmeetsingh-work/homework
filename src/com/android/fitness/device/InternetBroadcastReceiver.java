package com.android.fitness.device;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class InternetBroadcastReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {
		boolean noConnectivity = intent.getBooleanExtra(
				ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);
		// String reason =
		// intent.getStringExtra(ConnectivityManager.EXTRA_REASON);
		// boolean isFailover = intent.getBooleanExtra(
		// ConnectivityManager.EXTRA_IS_FAILOVER, false);
		if (noConnectivity) {
			Toast.makeText(context, "Internet connection not found.",
					Toast.LENGTH_SHORT).show();
		}
	}
}
