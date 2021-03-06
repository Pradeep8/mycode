package com.example.asynctaskdemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	Button startButton;
	TextView statusTextView;
	Context context = MainActivity.this;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		startButton = (Button) findViewById(R.id.buttonstart);
		statusTextView = (TextView) findViewById(R.id.textViewstatus);
		
	
		
		startButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) 
			{
				BackgroundTask bgTask = new BackgroundTask(statusTextView,context);
				bgTask.execute();
				
			}
		});
	}

	

}
