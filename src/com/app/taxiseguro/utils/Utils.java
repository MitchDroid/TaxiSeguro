package com.app.taxiseguro.utils;

import java.util.List;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;

import com.google.android.gms.maps.model.LatLng;

public class Utils {

	public static LatLng getlocation(Context context) throws SecurityException,
			IllegalArgumentException {
		LatLng actualLocation = null;
		LocationManager lm = (LocationManager) context.getSystemService(
				Context.LOCATION_SERVICE);
		List<String> providers = lm.getProviders(true);

		Location l = null;
		for (int i = 0; i < providers.size(); i++) {
			l = lm.getLastKnownLocation(providers.get(i));
			if (l != null)
				break;
		}
		if (l != null) {
			actualLocation = new LatLng(l.getLatitude(), l.getLongitude());
		}
		return actualLocation;
	}

}
