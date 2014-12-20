package com.example.control2014;


import java.util.ArrayList;
import java.util.List;



import com.example.control2014.R;
import com.example.control2014.DownloadManager;
import com.example.control2014.interfaces.DownloadListener;
import com.example.control2014.jsonparsers.JsonParser;
import com.example.control2014.models.imageModel;

import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MainActivity extends Activity implements DownloadListener {

	private ProgressBar progressBar;
	private TextView text;
	String StringArray;
	List<imageModel> model;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		progressBar = (ProgressBar) findViewById(R.id.progressBar1);
		text = (TextView) findViewById(R.id.textView1);
		ArrayAdapter adapter = new ArrayAdapter<imageModel>(this,R.layout.activity_list,model);
		new DownloadManager(this, 10000, 15000, "GET")
					.execute(getString(R.string.page_url));
	}

	@Override
	public void onRequestStart() {
		if(progressBar.getVisibility() == View.GONE)
			progressBar.setVisibility(View.VISIBLE);
	}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

	@SuppressLint("NewApi") @Override
	public void onRequestComplete(String data) {
		// TODO Auto-generated method stub
		if(progressBar.getVisibility() == View.VISIBLE)
			progressBar.setVisibility(View.GONE);
		
		 model = JsonParser.getRouteModelFromString(data);
		
		Log.i("chequeo jason", model.toString());
		
		String textToShow;
		if(model != null){
			
			textToShow = "success";
			final ListView listView1 = (ListView)findViewById(R.id.listView1);
			
			int size = model.size();
			
			//aqui se deberian mostrar los datos sobre la activity_image.xml
			
		} else {
			textToShow = "error";
		}
		text.setText(textToShow);
		
	}

	@Override
	public void onError(String error, int code) {
		// TODO Auto-generated method stub
		
	}
}
