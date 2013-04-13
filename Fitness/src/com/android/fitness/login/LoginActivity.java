package com.android.fitness.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.fitness.R;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.ParseUser;

/**
 * Activity which displays a login screen to the user, offering registration as
 * well.
 */
public class LoginActivity extends Activity {
	private Button btnAuthFacebook = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		initializeParseFacebookSDK();
		btnAuthFacebook = (Button) findViewById(R.id.btnAuthFacebook);
		btnAuthFacebook.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				showFacebookLogin();
			}
		});
	}

	private void showFacebookLogin() {
		ParseFacebookUtils.logIn(this, new LogInCallback() {
			@Override
			public void done(ParseUser user, ParseException err) {
				if (user == null) {
					Log.d("MyApp",
							"Uh oh. The user cancelled the Facebook login.");
				} else if (user.isNew()) {
					Log.d("MyApp",
							"User signed up and logged in through Facebook!");
				} else {
					Log.d("MyApp", "User logged in through Facebook!");
				}
			}
		});
	}

	private void initializeParseFacebookSDK() {
		// Set up Parse Facebook login SDK
		ParseFacebookUtils.initialize("553536204667212");

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		System.out.println("----------------------called");
		ParseFacebookUtils.finishAuthentication(requestCode, resultCode, data);
	}
}
