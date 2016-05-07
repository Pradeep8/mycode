package com.jsp.weatherupdates;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.util.Log;

public class JsonParser {
	
	static Bundle bundle;

	public static Bundle parsejson(String result)
	{
		
		try 
		
		{
			JSONObject rootObject = new JSONObject(result);
			
			
			JSONObject mainObject = rootObject.getJSONObject("main");
			
			JSONArray weatherArray =  rootObject.getJSONArray("weather");
			
			/*for (int i = 0; i <weatherArray.length(); i++) 
			{
			
			}*/
			
			double citytemp =  mainObject.getDouble("temp");
			
			String cityname = rootObject.getString("name");
			
			Log.d("CITY NAME:", cityname);
			Log.d("CITY TEMP",""+citytemp);
			
			bundle = new Bundle();
			
			bundle.putDouble("citytemp", citytemp);
			bundle.putString("cityname", cityname);
			
		}
		
		
		catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return bundle;
	}
}
