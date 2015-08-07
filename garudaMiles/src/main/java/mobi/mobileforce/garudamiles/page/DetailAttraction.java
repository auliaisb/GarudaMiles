package mobi.mobileforce.garudamiles.page;

import java.util.ArrayList;

import mobi.mobileforce.garudamiles.R;
import mobi.mobileforce.garudamiles.adapter.AttractionAdapter;
import mobi.mobileforce.garudamiles.adapter.DestinationDetailAdapter;
import mobi.mobileforce.garudamiles.model.ReviewModel;
import mobi.mobileforce.garudamiles.model.TravelpediaModel;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DetailAttraction extends Fragment implements AdapterView.OnItemClickListener{

	View view;
	AttractionAdapter adapter;
	ArrayList<ReviewModel> dataArray = new ArrayList<ReviewModel>();
	int[] drawable_asset = new int[] { R.drawable.trip, R.drawable.trip2,
			R.drawable.trip, R.drawable.trip2, };
	String[] type = new String[] { "2", "2", "2", "2", "2", "2", };
	ListView listView;
	MyOnClickDetailAttraction listener;

	ImageView imageIcon;
	ImageView btnBack;
	ImageView btnGallery;

	public interface MyOnClickDetailAttraction {
		public void onItemDetailAttraction(int id);
	}

	public void registerForListener(MyOnClickDetailAttraction listener) {
		this.listener = listener;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ActionBar actionBar = getActivity().getActionBar();
		LayoutInflater mInflater = LayoutInflater.from(getActivity());
		View mCustomView = mInflater.inflate(R.layout.custom_action_bar, null);

		TextView textTile = (TextView) mCustomView.findViewById(R.id.textTitle);

		imageIcon = (ImageView) mCustomView.findViewById(R.id.imageIcon);
		imageIcon.setVisibility(View.GONE);
		btnBack = (ImageView) mCustomView.findViewById(R.id.btnBack);
		btnBack.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//onBackPressed();
				listener.onItemDetailAttraction(R.id.btnBack);
			}
		});
		btnGallery = (ImageView) mCustomView.findViewById(R.id.picture_icon);
		textTile.setText("Bali");
		actionBar.setCustomView(mCustomView);
		btnGallery.setVisibility(View.GONE);


		// actionBar.setBackgroundDrawable(new ColorDrawable(0x0065b3));
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setDisplayShowCustomEnabled(true);
		actionBar.setDisplayUseLogoEnabled(false);
		actionBar.setDisplayShowHomeEnabled(false);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.attraction_detail, null);
		adapter = new AttractionAdapter(getActivity(), R.layout.item_review);
		listView = (ListView) view.findViewById(R.id.listAttraction);
		ViewGroup header = (ViewGroup) inflater.inflate(
				R.layout.header_attraction, listView, false);
		ViewGroup footer = (ViewGroup) inflater.inflate(
				R.layout.footer_layout,	listView, false);
		listView.addHeaderView(header, null, false);
		listView.addFooterView(footer, null, false);
		listView.setAdapter(adapter);
		getdata();
		return view;
	}

	public void getdata() {
		for (int i = 0; i < drawable_asset.length; i++) {
			ReviewModel item = new ReviewModel();
			dataArray.add(item);
		}

		adapter.addAll(dataArray);
		adapter.notifyDataSetChanged();
	}
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
							long id) {
		// TODO Auto-generated method stub

		listener.onItemDetailAttraction(0);

	}
}
