package com.app.taxiseguro.application;

import android.app.Application;
import android.content.Context;

public class TaxiSeguroApplication extends Application {
	
	private static TaxiSeguroApplication instance;
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		instance = this;
	}
	
	
	public static TaxiSeguroApplication getInstance() {
		return instance;
	}
	
	public static Context getTaxiSeguroApplicationContext() {
		return instance.getApplicationContext();
	}

}
