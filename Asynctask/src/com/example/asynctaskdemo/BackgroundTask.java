package com.example.asynctaskdemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.TextView;


public class BackgroundTask extends AsyncTask<Void,String, Void> {

	TextView btTextView;
	Context btContext;
	NotificationCompat.Builder  builder;
	NotificationManager manager;
	
	public BackgroundTask(TextView maTextview,Context maContext) 
	{
	   btTextView = maTextview;
	   btContext = maContext;
	}
	
	
	@Override
	protected void onPreExecute() 
	{
		super.onPreExecute();
		Log.d("DEBUG", "inside on onPreExecute()");
	 
		builder = new NotificationCompat.Builder(btContext);
		builder.setContentTitle("Downloading File..");
		builder.setProgress(100,0,false);
		builder.setContentText("Starting download");
		builder.setSmallIcon(R.drawable.ic_launcher);
		
		Notification notification = builder.build();
		
		manager = (NotificationManager) btContext.getSystemService(btContext.NOTIFICATION_SERVICE);
		manager.notify(1, notification);
		
		btTextView.setText("Download started.....");
	}
	
	@Override
	protected Void doInBackground(Void... arg0) 
	{
		Log.d("DEBUG", "inside on doInBackground()");

		for (int i = 0; i < 1000; i++) 
		{
			try 
			{
				Thread.sleep(100);
				publishProgress(String.valueOf(i));
				Log.d("DEBUG","Value of i is "+i);
			} 
			
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	@Override
	protected void onProgressUpdate(String... values) 
	{
		super.onProgressUpdate(values);
		
		builder.setProgress(100,Integer.parseInt(values[0]),false);
		
		builder.setContentText(values[0]+"%");
		
		manager.notify(1,builder.build());
		
		btTextView.setText(values[0]+"%");

		Log.d("DEBUG", "inside on onProgressUpdate()");

	}
	
	@Override
	protected void onPostExecute(Void result) 
	{
		super.onPostExecute(result);
		
		btTextView.setText("Download Completed...");
		
		builder.setContentText("Download Completed... ");
		
		manager.notify(1,builder.build());
		
		Log.d("DEBUG", "inside on onPostExecute()");

	}
	
	

	
}