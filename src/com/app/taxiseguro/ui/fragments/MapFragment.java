package com.app.taxiseguro.ui.fragments;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.taxiseguro.R;
import com.app.taxiseguro.ui.activities.MainActivity;
import com.app.taxiseguro.utils.Utils;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.CancelableCallback;
import com.google.android.gms.maps.GoogleMap.OnCameraChangeListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.VisibleRegion;

public class MapFragment extends Fragment implements OnCameraChangeListener {

	private GoogleMap mMap;
	private SupportMapFragment mMapFragment;
	private UiSettings mUiSettings;
	private final static float DEFAULT_ZOOM = 17.0f;
	private CameraPosition mCameraPosition;

	/**
	 * The fragment argument representing the section number for this fragment.
	 */
	private static final String ARG_SECTION_NUMBER = "section_number";

	/**
	 * Returns a new instance of this fragment for the given section number.
	 */
	public static MapFragment newInstance(int sectionNumber) {
		MapFragment fragment = new MapFragment();
		Bundle args = new Bundle();
		args.putInt(ARG_SECTION_NUMBER, sectionNumber);
		fragment.setArguments(args);
		return fragment;
	}

	public MapFragment() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_map, container,
				false);
		return rootView;
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		FragmentManager fm = getChildFragmentManager();
		mMapFragment = (SupportMapFragment) fm
				.findFragmentById(R.id.content_map);

		if (mMapFragment == null) {
			mMapFragment = SupportMapFragment.newInstance();
			fm.beginTransaction().replace(R.id.content_map, mMapFragment)
					.commit();
		}

		setUpMapIfNeeded();

		
	}

	@Override
	public void onResume() {
		super.onResume();
		setUpMapIfNeeded();
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
//		((MainActivity) activity).onSectionAttached(getArguments().getInt(
//				ARG_SECTION_NUMBER));
	}

	private void setUpMapIfNeeded() {
		if (mMap == null) {
			mMap = mMapFragment.getMap();

			if (mMap != null) {
				setUpMap();
			}
		}
	}

	private void setUpMap() {

		mMap.setMyLocationEnabled(true);
		mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		mUiSettings = mMap.getUiSettings();
		mUiSettings.setAllGesturesEnabled(true);
		mUiSettings.setCompassEnabled(false);
		mUiSettings.setMyLocationButtonEnabled(true);
		mUiSettings.setZoomControlsEnabled(true);
		mMap.setOnCameraChangeListener(this);
		locateMe(DEFAULT_ZOOM);
	}

	private void locateMe(float zoom) {
		LatLng mLoc = Utils.getlocation(getActivity());
		if (mLoc != null) {
			mCameraPosition = buildCamera(mLoc, zoom);
			changeCamera(CameraUpdateFactory.newCameraPosition(mCameraPosition));
		}
	}

	private CameraPosition buildCamera(LatLng mLocation, float zoom) {
		return new CameraPosition.Builder()
				.target(new LatLng(mLocation.latitude, mLocation.longitude))
				.zoom(zoom).bearing(45.0f).tilt(25).build();
	}

	private void changeCamera(CameraUpdate update) {
		changeCamera(update, null);
	}

	private void changeCamera(CameraUpdate update, CancelableCallback callback) {
		mMap.animateCamera(update, callback);
	}

	@Override
	public void onCameraChange(CameraPosition position) {
		centerMarker(position.target);
	}

	private void centerMarker(LatLng target) {
		Log.d("lat: " + target.latitude, "lon: " + target.longitude);
		VisibleRegion visibleRegion = mMap.getProjection().getVisibleRegion();
		Point x = mMap.getProjection().toScreenLocation(visibleRegion.farRight);
		Point y = mMap.getProjection().toScreenLocation(visibleRegion.nearLeft);
		Point centerPoint = new Point(x.x / 2, y.y / 2);
		LatLng centerFromPoint = mMap.getProjection().fromScreenLocation(
				centerPoint);
		Log.d("center point: " + centerFromPoint.latitude, " "
				+ centerFromPoint.longitude);
	}
}