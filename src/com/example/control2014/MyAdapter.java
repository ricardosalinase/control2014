package com.example.control2014;

import java.util.List;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.control2014.models.imageModel;
import com.example.control2014.R;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
	
	private Activity activity;
	private List<imageModel> models;
	LayoutInflater inflater;
	public MyAdapter(Activity activity, List<imageModel> models){
		this.activity = activity;
		this.models = models;
	}
	@Override
	public Object getItem(int location) {
		return imageModel.get(location);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		
		if (inflater == null)
			inflater = (LayoutInflater) activity
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		if (convertView == null)
			convertView = inflater.inflate(R.layout.cuadrito, null);

		ImageLoader imageLoader = null;
		if (imageLoader == null)
			imageLoader = AppController.getInstance().getImageLoader();
		NetworkImageView image = (NetworkImageView) convertView
				.findViewById(R.id.ImageUrl);
		TextView title = (TextView) convertView.findViewById(R.id.Title);
		TextView points = (TextView) convertView.findViewById(R.id.Points);



		imageModel m = models.get(position);

		// thumbnail image
		image.setImageUrl(m.getImageUrl(), imageLoader);
		
		// title
		title.setText(m.getTitle());
		
		// points
		points.setText(String.valueOf(m.getPoints()));
		


		return convertView;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return models.size();
	}

}
