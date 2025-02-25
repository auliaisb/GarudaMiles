package mobi.mobileforce.garudamiles.page;

import java.util.ArrayList;
import java.util.Stack;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import mobi.mobileforce.garudamiles.R;
import mobi.mobileforce.garudamiles.adapter.ImageAdapter;
import mobi.mobileforce.garudamiles.page.AlbumPage.MyOnClickAlbumPage;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.GridView;
import android.widget.RelativeLayout;

public class AlbumPage extends Fragment {

	View view;
	private ArrayList<String> imageUrls;
	private ImageAdapter imageAdapter;
	private int mPhotoSize, mPhotoSpacing;
	GridView gridView;
	RelativeLayout footerLayout;
	MyOnClickAlbumPage listener;

	public interface MyOnClickAlbumPage {
		public void onItemAlbumPage(int id);
	}

	public void registerForListener(MyOnClickAlbumPage listener) {
		this.listener = listener;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mPhotoSize = getResources().getDimensionPixelSize(R.dimen.photo_size);
		mPhotoSpacing = getResources().getDimensionPixelSize(
				R.dimen.photo_spacing);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.albumpage, null);

		final String[] columns = { MediaStore.Images.Media.DATA,
				MediaStore.Images.Media._ID };
		final String orderBy = MediaStore.Images.Media.DATE_TAKEN;
		Cursor imagecursor = getActivity().managedQuery(
				MediaStore.Images.Media.EXTERNAL_CONTENT_URI, columns, null,
				null, orderBy + " DESC");
		footerLayout = (RelativeLayout) view.findViewById(R.id.footerLayout);
		footerLayout.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				listener.onItemAlbumPage(R.id.footerLayout);
			}
		});
		this.imageUrls = new ArrayList<String>();

		for (int i = 0; i < imagecursor.getCount(); i++) {
			imagecursor.moveToPosition(i);
			int dataColumnIndex = imagecursor
					.getColumnIndex(MediaStore.Images.Media.DATA);
			imageUrls.add(imagecursor.getString(dataColumnIndex));

			System.out.println("=====> Array path => " + imageUrls.get(i));
		}

		imageAdapter = new ImageAdapter(getActivity(), imageUrls);
		gridView = (GridView) view.findViewById(R.id.gridview);
		gridView.setAdapter(imageAdapter);

		gridView.getViewTreeObserver().addOnGlobalLayoutListener(
				new ViewTreeObserver.OnGlobalLayoutListener() {
					@Override
					public void onGlobalLayout() {
						if (imageAdapter.getNumColumns() == 0) {
							final int numColumns = (int) Math.floor(gridView
									.getWidth() / (mPhotoSize + mPhotoSpacing));
							if (numColumns > 0) {
								final int columnWidth = (gridView.getWidth() / numColumns)
										- mPhotoSpacing;
								imageAdapter.setNumColumns(numColumns);
								imageAdapter.setItemHeight(columnWidth);

							}
						}
					}
				});

		return view;
	}

}
