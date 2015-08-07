package mobi.mobileforce.garudamiles.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import mobi.mobileforce.garudamiles.viewpager.TextFragment1;
import mobi.mobileforce.garudamiles.viewpager.TextFragment2;
import mobi.mobileforce.garudamiles.viewpager.TextFragment3;

/**
 * Created by Aulia on 04-Aug-15.
 */
public class LandingPagerAdapter extends FragmentPagerAdapter {
    public LandingPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return new TextFragment1();
            case 1:
                return new TextFragment2();
            case 2:
                return new TextFragment3();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
