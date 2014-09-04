package com.app.taxiseguro;

import com.app.taxiseguro.utils.IntentHelper;
import com.app.taxiseguro.utils.SharedPreferencesHelper;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class TaxiSeguroActivity extends ActionBarActivity {

	private ActionBar actionbar;
	private static final String IS_FIRST_TIME = "isFirstTime";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_taxi_seguro);

		actionbar = getSupportActionBar();
		if (actionbar != null) {
			actionbar.hide();
		}
		
		
		boolean state = SharedPreferencesHelper.loadBoolean(IS_FIRST_TIME);
		
		if(state){
			IntentHelper.goToManualActivity(TaxiSeguroActivity.this);
			SharedPreferencesHelper.saveBoolean(IS_FIRST_TIME, false);
		}else{
			IntentHelper.goToMapActivity(TaxiSeguroActivity.this);
		}
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.taxi_seguro, menu);
		return true;
	}

}
