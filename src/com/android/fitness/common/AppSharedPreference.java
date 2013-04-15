package com.android.fitness.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class AppSharedPreference {
	private SharedPreferences sharedPreferences = null;
	private Editor editor = null;
	private static final String PREFERENCE_NAME = "com.android.fitness.shared";
	private static final String KEY_BOOLEAN_LOGIN_STATE = "login_state";

	public AppSharedPreference(Context context) {
		sharedPreferences = context.getSharedPreferences(PREFERENCE_NAME,
				Context.MODE_PRIVATE);
		editor = sharedPreferences.edit();
	}

	public void setUserLoggedIn(boolean loginState) {
		editor.putBoolean(KEY_BOOLEAN_LOGIN_STATE, loginState).commit();
	}

	public boolean isUserLoggedIn() {
		return sharedPreferences.getBoolean(KEY_BOOLEAN_LOGIN_STATE, false);
	}
}
