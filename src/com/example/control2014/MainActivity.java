package com.example.control2014;

import imageModel.imageModel;

import java.util.ArrayList;
import java.util.List;

import cl.telematica.httpjsonparseexample.interfaces.DownloadListener;
import cl.telematica.httpjsonparseexample.jsonparsers.JsonParser;
import cl.telematica.httpjsonparseexample.models.LegsModel;
import cl.telematica.httpjsonparseexample.models.RouteDetailModel;
import cl.telematica.httpjsonparseexample.models.RouteModel;

import com.example.control2014.R;
import com.example.control2014.DownloadManager;
import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.os.Bundle;
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
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		progressBar = (ProgressBar) findViewById(R.id.progressBar1);
		text = (TextView) findViewById(R.id.textView1);
		
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

	@Override
	public void onRequestComplete(String data) {
		// TODO Auto-generated method stub
		if(progressBar.getVisibility() == View.VISIBLE)
			progressBar.setVisibility(View.GONE);
		
		List<imageModel> model = JsonParser.getRouteModelFromString(data);
		if(model != null){
		
			final ListView listView1 = (ListView)findViewById(R.id.listView1);
			
			int size = model.size();
			ArrayList<imageModel> list = new ArrayList<imageModel>();
			ArrayAdapter<imageModel> adapter;
			
			adapter = new ArrayAdapter<imageModel>(this,android.R.layout.simple_list_item_1,list);
			//aqui se deberian mostrar los datos sobre la activity_image.xml
			adapter.addAll(model);
			
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
