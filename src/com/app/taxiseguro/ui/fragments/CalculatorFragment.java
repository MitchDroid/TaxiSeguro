package com.app.taxiseguro.ui.fragments;

import javax.crypto.Mac;

import com.app.taxiseguro.R;
import com.app.taxiseguro.application.TaxiSeguroApplication;
import com.app.taxiseguro.ui.activities.TaxiSeguroActivity;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CalculatorFragment extends Fragment {
	
	private Activity mActivity;

	public CalculatorFragment() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_calculator,
				container, false);
		
	
		return  rootView;
	}
	


	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			mActivity = activity;
		} catch (Exception e) {
			Log.e("CalculatorFragment", CalculatorFragment.class.getName(), e);
		}
	}

}
