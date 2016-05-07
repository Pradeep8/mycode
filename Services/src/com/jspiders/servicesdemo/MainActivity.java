package com.jspiders.servicesdemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	Button startButton,stopButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		startButton = (Button) findViewById(R.id.buttonstart);
		stopButton = (Button) findViewById(R.id.buttonstop);
		
		
		
		startButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) 
			{
				Intent startintent = new Intent(MainActivity.this,DemoService.class);
				startService(startintent);
				
			}
		} );
		
		
		stopButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) 
			{
				Intent stopIntent = new Intent(MainActivity.this,DemoService.class);
				stopService(stopIntent);
				
			}
		});
		
	}



}
