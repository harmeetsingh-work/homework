package com.android.fitness;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.commonsware.cwac.merge.MergeAdapter;

public class TrainingTypeActivity extends ListActivity {
	private MergeAdapter mergeAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_training_type);
		mergeAdapter = new MergeAdapter();

		mergeAdapter.addView(buildLabel("Training"));
		mergeAdapter
				.addAdapter(buildListAdapter(R.array.lstViewTrainingEnteries));
		mergeAdapter.addView(buildLabel("Knowledge Base"));
		mergeAdapter.addAdapter(buildListAdapter(R.array.lstViewKBaseEnteries));
		mergeAdapter.addView(buildLabel("Profile"));
		mergeAdapter
				.addAdapter(buildListAdapter(R.array.lstViewProfileEnteries));

		setListAdapter(mergeAdapter);
	}

	private View buildLabel(String title) {
		TextView txtViewLabel = new TextView(this);
		txtViewLabel.setText(title);
		return (txtViewLabel);
	}

	private ListAdapter buildListAdapter(int arrayID) {
		String[] items = getResources().getStringArray(arrayID);
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(items));
		return (new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, list));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.training_type, menu);
		return true;
	}

}
