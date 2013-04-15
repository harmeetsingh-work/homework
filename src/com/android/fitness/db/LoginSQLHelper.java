package com.android.fitness.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class LoginSQLHelper {
	EventDataSQLHelper eventsData;
	public static final String COLOUMN_LOGIN_TIME = "login_time";
	public static final String COLOUMN_LOGINID = "login_id";
	public static final String COLOUMN_LOGGEDIN = "user_loggedin";

	public LoginSQLHelper(Context context) {
		eventsData = new EventDataSQLHelper(context);
	}

	public void closeConnection() {
		eventsData.close();
	}

	public boolean addUserLoginSessionDetails(String loginID) {
		SQLiteDatabase db = eventsData.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(COLOUMN_LOGIN_TIME, System.currentTimeMillis());
		values.put(COLOUMN_LOGINID, loginID);
		values.put(COLOUMN_LOGGEDIN, true);
		long rowID = db.insert(EventDataSQLHelper.TABLE_USER_LOGIN, null,
				values);
		return (rowID != -1);
	}

	public boolean checkIfUserLoggedIn() {
		SQLiteDatabase db = eventsData.getReadableDatabase();
		Cursor cursor = db.query(EventDataSQLHelper.TABLE_USER_LOGIN, null,
				null, null, null, null, null);
		boolean loggedIn = false;
		while (cursor.moveToNext()) {
			loggedIn = (cursor.getInt(3) > 0);
		}
		return loggedIn;
	}
}
