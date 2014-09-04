package com.app.taxiseguro.utils;

import com.app.taxiseguro.application.TaxiSeguroApplication;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class SharedPreferencesHelper {

	private static final String IS_FIRST_TIME = "isFirstTime";
	private static SharedPreferences sharedPreferences;
	private static Editor editor;

	private static void init() {
		if (sharedPreferences == null) {
			sharedPreferences = PreferenceManager
					.getDefaultSharedPreferences(TaxiSeguroApplication
							.getTaxiSeguroApplicationContext());
		}
	}

	public static void saveSessionState(String isFirstTime, boolean value) {
		init();
		saveBoolean(IS_FIRST_TIME, value);

	}

	public static void saveBoolean(String key, Boolean value) {
		init();
		editor = sharedPreferences.edit();
		editor.putBoolean(key, value);
		editor.commit();
	}

	public static boolean loadBoolean(String key) {
		init();
		return sharedPreferences.getBoolean(key, true);
	}

}
