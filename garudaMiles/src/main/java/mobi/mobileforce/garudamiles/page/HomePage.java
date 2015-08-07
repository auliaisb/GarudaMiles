package mobi.mobileforce.garudamiles.page;

import mobi.mobileforce.garudamiles.R;
import mobi.mobileforce.garudamiles.adapter.TabsPagerAdapter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class HomePage extends Fragment implements OnClickListener {
	View view;
	public ViewPager viewPager;
	TabsPagerAdapter mAdapter;
	TextView btnTravelPedia, btnDiscover, btnMe;
	View lineTravelpedia, lineDiscover, lineMe;

	public ViewPager getViewPager() {
		return viewPager;
	}

	public void setViewPager(ViewPager viewPager) {
		this.viewPager = viewPager;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.home_page, null);
		btnTravelPedia = (TextView) view.findViewById(R.id.btnTravelPedia);
		btnDiscover = (TextView) view.findViewById(R.id.btnDiscover);
		btnMe = (TextView) view.findViewById(R.id.btnMe);
		btnTravelPedia.setOnClickListener(this);
		btnDiscover.setOnClickListener(this);
		btnMe.setOnClickListener(this);

		lineTravelpedia = (View) view.findViewById(R.id.lineTravelpedia);
		lineDiscover = (View) view.findViewById(R.id.lineDiscover);
		lineMe = (View) view.findViewById(R.id.lineMe);

		viewPager = (ViewPager) view.findViewById(R.id.pager);
		setViewPager(viewPager);
		mAdapter = new TabsPagerAdapter(getFragmentManager());

		viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

			public void changePage(int page){
				viewPager.setCurrentItem(page);
			}
			@Override
			public void onPageSelected(int position) {
				// on changing the page
				// make respected tab selected
				Log.e("position = ", "" + position);
				changeNavigationTab(position);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});
		viewPager.setAdapter(mAdapter);

		return view;
	}

	public void changeNavigationTab(int position) {

		switch (position) {
		case 0:
			btnTravelPedia.setTextColor(0xFF0065b3);
			btnDiscover.setTextColor(0xFFaaaaaa);
			btnMe.setTextColor(0xFFaaaaaa);
			lineTravelpedia.setBackgroundColor(0xFF0065b3);
			lineDiscover.setBackgroundColor(0xFFaaaaaa);
			lineMe.setBackgroundColor(0xFFaaaaaa);
			break;
		case 1:
			btnTravelPedia.setTextColor(0xFFaaaaaa);
			btnDiscover.setTextColor(0xFF0065b3);
			btnMe.setTextColor(0xFFaaaaaa);
			lineTravelpedia.setBackgroundColor(0xFFaaaaaa);
			lineDiscover.setBackgroundColor(0xFF0065b3);
			lineMe.setBackgroundColor(0xFFaaaaaa);
			break;
		case 2:
			btnTravelPedia.setTextColor(0xFFaaaaaa);
			btnDiscover.setTextColor(0xFFaaaaaa);
			btnMe.setTextColor(0xFF0065b3);
			lineTravelpedia.setBackgroundColor(0xFFaaaaaa);
			lineDiscover.setBackgroundColor(0xFFaaaaaa);
			lineMe.setBackgroundColor(0xFF0065b3);
			break;

		default:
			break;
		}

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btnTravelPedia:
			changeNavigationTab(0);
			viewPager.setCurrentItem(0);
			break;
		case R.id.btnDiscover:
			changeNavigationTab(1);
			viewPager.setCurrentItem(1);
			break;
		case R.id.btnMe:
			changeNavigationTab(2);
			viewPager.setCurrentItem(2);
			break;

		default:
			break;
		}
	}
}
