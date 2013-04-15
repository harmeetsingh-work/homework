package com.android.fitness.login;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.fitness.R;
import com.android.fitness.TrainingTypeActivity;
import com.android.fitness.common.AppSharedPreference;
import com.android.fitness.db.LoginSQLHelper;
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
	private LoginSQLHelper loginSQLHelper = null;
	private AppSharedPreference appSharedPreference = null;
	private ProgressDialog progressDialog = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		initializeParseFacebookSDK();
		appSharedPreference = new AppSharedPreference(LoginActivity.this);
		// loginSQLHelper = new LoginSQLHelper(this);
		// if (loginSQLHelper.checkIfUserLoggedIn()) {
		// startTrainingTypeActivity();
		// }
		if (appSharedPreference.isUserLoggedIn()) {
			startTrainingTypeActivity();
		}
		progressDialog = new ProgressDialog(LoginActivity.this);
		progressDialog.setTitle("Please wait...");
		btnAuthFacebook = (Button) findViewById(R.id.btnAuthFacebook);
		btnAuthFacebook.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				v.setEnabled(false);
				showFacebookLogin();
			}
		});

	}

	private void startTrainingTypeActivity() {
		startActivity(new Intent(LoginActivity.this, TrainingTypeActivity.class));
		finish();
	}

	private void showFacebookLogin() {
		ParseFacebookUtils.logIn(this, new LogInCallback() {
			@Override
			public void done(ParseUser user, ParseException err) {
				if (user != null) {
					// loginSQLHelper.addUserLoginSessionDetails(user.getEmail());
					System.out.println("--------login");
					progressDialog.dismiss();
					appSharedPreference.setUserLoggedIn(true);
					startTrainingTypeActivity();
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
		progressDialog.show();
		ParseFacebookUtils.finishAuthentication(requestCode, resultCode, data);
	}
}
