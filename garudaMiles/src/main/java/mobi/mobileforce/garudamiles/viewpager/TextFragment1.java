package mobi.mobileforce.garudamiles.viewpager;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mobi.mobileforce.garudamiles.R;

/**
 * Created by Aulia on 04-Aug-15.
 */
public class TextFragment1 extends Fragment {
    public TextFragment1() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.landing_page1, container, false);

        return rootView;
    }
}
