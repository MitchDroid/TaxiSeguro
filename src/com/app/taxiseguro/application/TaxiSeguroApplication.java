package com.app.taxiseguro.application;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;

public class TaxiSeguroApplication extends Application {
	
	private static TaxiSeguroApplication instance;
	public static Typeface[] myTypeface = new Typeface[3];
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		instance = this;
		
		myTypeface[0] = Typeface.createFromAsset(getAssets(), "Roboto-Black.ttf");
		myTypeface[1] = Typeface.createFromAsset(getAssets(), "Roboto-Medium.ttf");
		myTypeface[2] = Typeface.createFromAsset(getAssets(), "Roboto-Regular.ttf");
	}
	
	
	public static TaxiSeguroApplication getInstance() {
		return instance;
	}
	
	public static Context getTaxiSeguroApplicationContext() {
		return instance.getApplicationContext();
	}

}
