package com.app.taxiseguro.ui.activities;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

import com.app.taxiseguro.R;
import com.app.taxiseguro.R.id;
import com.app.taxiseguro.R.layout;
import com.app.taxiseguro.R.menu;
import com.app.taxiseguro.application.TaxiSeguroApplication;
import com.app.taxiseguro.ui.fragments.CalculatorFragment;
import com.beardedhen.androidbootstrap.FontAwesomeText;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.text.style.TypefaceSpan;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.os.Build;

public class CalculatorActivity extends ActionBarActivity {

	private TextView txt_tittle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculator);
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new CalculatorFragment()).commit();
		}

	

		
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
	}

	@Override
	protected void attachBaseContext(Context newBase) {		
		super.attachBaseContext(new CalligraphyContextWrapper(newBase));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.calculator, menu);
		return true;
	}

	//
	// @Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == android.R.id.home) {
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
