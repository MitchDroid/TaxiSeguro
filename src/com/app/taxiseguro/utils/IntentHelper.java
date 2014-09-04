package com.app.taxiseguro.utils;

import com.app.taxiseguro.ManualActivity;
import com.app.taxiseguro.ui.activities.CalculatorActivity;
import com.app.taxiseguro.ui.activities.MainActivity;
import com.google.android.maps.MapActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class IntentHelper {

	
	public static void goToCalculatorActivity(Context context) {
		launchItent(context, CalculatorActivity.class);

	}
	
	public static void goToManualActivity(Context context) {
		launchItent(context, ManualActivity.class);

	}
	
	public static void goToMapActivity(Context context){
		launchItent(context, MainActivity.class);
	}

	private static <T> Intent launchItent(Context activity, Class<T> className) {
		Intent myIntent = new Intent(activity, className);
		activity.startActivity(myIntent);
		return myIntent;
	}

}