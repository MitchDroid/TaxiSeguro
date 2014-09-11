package com.app.taxiseguro.application;

import com.app.taxiseguro.R;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;

public class TaxiSeguroApplication extends Application {
	
	private static TaxiSeguroApplication instance;
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		CalligraphyConfig.initDefault("fonts/Roboto-Regular.ttf", R.attr.fontPath);
		
		instance = this;
		
		
	}
	
	
	public static TaxiSeguroApplication getInstance() {
		return instance;
	}
	
	public static Context getTaxiSeguroApplicationContext() {
		return instance.getApplicationContext();
	}

}
