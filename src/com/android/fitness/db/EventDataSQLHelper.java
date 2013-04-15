package com.android.fitness.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

class EventDataSQLHelper extends SQLiteOpenHelper {
	private static final String DATABASE_NAME = "com.android.fitness.db";
	private static final int DATABASE_VERSION = 1;

	// Table name
	public static final String TABLE_USER_LOGIN = "user_login";

	public EventDataSQLHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		createUserLoginTable(db);
	}

	private void createUserLoginTable(SQLiteDatabase db) {
		String sql = "CREATE TABLE " + TABLE_USER_LOGIN + "( "
				+ BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ LoginSQLHelper.COLOUMN_LOGIN_TIME + " INTEGER, "
				+ LoginSQLHelper.COLOUMN_LOGINID + " TEXT NOT NULL, "
				+ LoginSQLHelper.COLOUMN_LOGGEDIN + " BOOL NOT NULL )";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		if (oldVersion >= newVersion)
			return;

		String sql = null;
		if (oldVersion == 1)
			sql = "ALTER TABLE " + TABLE_USER_LOGIN + " ADD NOTE TEXT;";
		if (oldVersion == 2)
			sql = "";

		Log.d("EventsData", "onUpgrade	: " + sql);
		if (sql != null)
			db.execSQL(sql);
	}

}
