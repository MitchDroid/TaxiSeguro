/**
 * License Copyright 2013 Issac Wong Copyright 2013 Kenefe_Li Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, 
 *  software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or 
 *  implied. See the License for the specific language governing permissions and limitations under the License.
 */

package com.app.taxiseguro.ui.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.app.taxiseguro.R;
import com.app.taxiseguro.view.ColorAnimationView;

public class ManualFragment extends Fragment {

	private static final int[] resource = new int[] { R.drawable.welcome4,
			R.drawable.welcome4, R.drawable.welcome4, R.drawable.welcome4 };
	private static final String TAG = ManualFragment.class.getSimpleName();

	private Button btnGotIt;
	private boolean isButtonVisible = false;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_manual, container,
				false);

		MyFragmentStatePager adpter = new MyFragmentStatePager(
				getFragmentManager());

		ColorAnimationView colorAnimationView = (ColorAnimationView) rootView
				.findViewById(R.id.ColorAnimationView);
		ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.viewPager);
		viewPager.setAdapter(adpter);

		btnGotIt = (Button) rootView.findViewById(R.id.button_got_it);

		/**
		 * Frist: You need call this method after you set the Viewpager adpter;
		 * Second: setmViewPager(ViewPager mViewPager,Object obj， int count,
		 * int... colors) so,you can set any length colors to make the animation
		 * more cool! Third: If you call this method like below, make the colors
		 * no data, it will create a change color by default.
		 * */
		colorAnimationView.setmViewPager(viewPager, resource.length);
		colorAnimationView
				.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
					@Override
					public void onPageScrolled(int position,
							float positionOffset, int positionOffsetPixels) {
					
						Log.e("TAG", "onPageScrolled");
					}

					@Override
					public void onPageSelected(int position) {

						if (position == 3 && !isButtonVisible) {
							isButtonVisible = true;
							btnGotIt.setVisibility(View.VISIBLE);
						}else{
							isButtonVisible = false;
							btnGotIt.setVisibility(View.GONE);
						}
						
					}

					@Override
					public void onPageScrollStateChanged(int state) {
						Log.e("TAG", "onPageScrollStateChanged");
					}
				});

		return rootView;
	}

	public class MyFragmentStatePager extends FragmentStatePagerAdapter {

		public MyFragmentStatePager(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			return new MyFragment(position);
		}

		@Override
		public int getCount() {
			return resource.length;
		}
	}

	@SuppressLint("ValidFragment")
	public class MyFragment extends Fragment {
		private int position;

		public MyFragment(int position) {
			this.position = position;
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			ImageView imageView = new ImageView(getActivity());
			imageView.setImageResource(resource[position]);
			return imageView;
		}
	}

}