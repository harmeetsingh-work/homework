package com.android.fitness;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;

import com.android.fitness.login.LoginActivity;
import com.parse.Parse;
import com.parse.ParseAnalytics;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initializeParse();
		startActivity(new Intent(this, LoginActivity.class));
		finish();
	}

	private void initializeParse() {
		Parse.initialize(this, "eUcuAgH1XuBizYKYWNxZY2pIjdogk2UUMiBLJguN",
				"gDcurI0rq2a48ghT9rbtDIsxZQ8tvW1BqlfNE4cm");
		ParseAnalytics.trackAppOpened(getIntent());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
