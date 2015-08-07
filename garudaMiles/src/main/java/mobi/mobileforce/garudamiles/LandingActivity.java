package mobi.mobileforce.garudamiles;

import mobi.mobileforce.garudamiles.activity.DetailActivity2;
import mobi.mobileforce.garudamiles.activity.HomeActivity;
import mobi.mobileforce.garudamiles.adapter.LandingPagerAdapter;
import mobi.mobileforce.garudamiles.helper.ViewPagerCustomDuration;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

import java.util.Timer;
import java.util.TimerTask;

public class LandingActivity extends FragmentActivity implements OnClickListener {
	ImageButton buttonLoginGarudaMiles;
	ViewPagerCustomDuration viewPager;
	LandingPagerAdapter adapter;
	Timer timer;
	int page = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_landing);
		buttonLoginGarudaMiles = (ImageButton) findViewById(R.id.buttonLoginGarudaMiles);
		buttonLoginGarudaMiles.setOnClickListener(this);

		viewPager = (ViewPagerCustomDuration)findViewById(R.id.text_pager);
		adapter = new LandingPagerAdapter(getSupportFragmentManager());
		viewPager.setAdapter(adapter);
		viewPager.setScrollDurationFactor(3);
		pageSwitcher(5);
	}
	public void pageSwitcher(int seconds){
		timer = new Timer();
		timer.scheduleAtFixedRate(new Task(), 0, seconds * 1000);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.landing, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.buttonLoginGarudaMiles:
			// Intent i = new Intent(LandingActivity.this,
			// GalleryActivity.class);
			Intent i = new Intent(LandingActivity.this, HomeActivity.class);
			startActivity(i);
			this.finish();
			break;

		default:
			break;
		}
	}
	class Task extends TimerTask {
		@Override
		public void run(){
			runOnUiThread(new Runnable() {
				@Override
				public void run() {
					if(page > 2){
						page = 0;
						viewPager.setCurrentItem(0);
						viewPager.setCurrentItem(page++);
					} else{
						viewPager.setCurrentItem(page++);
					}
				}
			});
		}
	}
}
