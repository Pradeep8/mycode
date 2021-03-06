package com.jsp.loadimage;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

public class NetworkingTask extends AsyncTask<Void, Void, Void> {

	ImageView ntImageView;
	Bitmap bitmap;
	private HttpURLConnection connection;
	private InputStream ins;
	
	public NetworkingTask(ImageView maImageView) 
	{
	    ntImageView = maImageView;
	}

	
	
	@Override
	protected Void doInBackground(Void... arg0) 
	{
		
		try 
		{
			URL imgUrl = new URL("http://techstory.in/wp-content/uploads/2015/02/sachin-tendulkar-sifr-651867782.jpg");
		    connection = (HttpURLConnection) imgUrl.openConnection();
		    ins = connection.getInputStream();
		    bitmap = BitmapFactory.decodeStream(ins);
		} 
		
		
		catch (MalformedURLException e)
		{
						e.printStackTrace();
		} 
		
		catch (IOException e) 
		
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally
		{
			try 
			{
				ins.close();
			} 
			
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			connection.disconnect();
		}
		return null;
	}
	
	
	@Override
	protected void onPostExecute(Void result) {
		super.onPostExecute(result);
		
		ntImageView.setImageBitmap(bitmap);
	}

}
