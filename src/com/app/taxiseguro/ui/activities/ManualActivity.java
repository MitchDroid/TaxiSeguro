package com.app.taxiseguro.ui.activities;

import com.app.taxiseguro.R;
import com.app.taxiseguro.R.id;
import com.app.taxiseguro.R.layout;
import com.app.taxiseguro.ui.fragments.ManualFragment;
import com.app.taxiseguro.utils.IntentHelper;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.os.Build;

public class ManualActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_manual);
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new ManualFragment()).commit();
		}

		if (getSupportActionBar() != null)
			getSupportActionBar().hide();
	}

	/** Called when the user touches the button */
	public void sendMessage(View view) {
		IntentHelper.goToMapActivity(ManualActivity.this);
		finish();
		
	}
	

}
