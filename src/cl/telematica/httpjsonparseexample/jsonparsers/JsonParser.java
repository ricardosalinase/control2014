package cl.telematica.httpjsonparseexample.jsonparsers;

import imageModel.imageModel;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;


public class JsonParser {
	
	public static List<imageModel> getRouteModelFromString(String data){
		List<imageModel> imageModels = new ArrayList<imageModel>();
		
		try {
			JSONObject imageModelJson = (JSONObject) new JSONTokener(data).nextValue();
			
			
			JSONArray imageDetailsJson = imageModelJson.getJSONArray("title");
			int size = imageDetailsJson.length();
			for(int i = 0; i < size; i++){
				JSONObject details = imageDetailsJson.getJSONObject(i);
				imageModel imageTemp = new imageModel();
				
				imageTemp.title = details.getString("title");
				imageTemp.imageUrl = details.getString("image");
				imageTemp.points = details.getString("points");
				imageTemp.link = details.getString("link");
				imageModels.add(imageTemp);
				
				
				
				
			}
			
			
			return imageModels;
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}

}
