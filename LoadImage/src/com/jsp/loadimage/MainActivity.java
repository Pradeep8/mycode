package com.jsp.loadimage;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button loadButton;
	ImageView outputImageView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		loadButton = (Button) findViewById(R.id.buttonload);
		outputImageView = (ImageView) findViewById(R.id.imageViewoutput);
		
		ConnectivityManager cmManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
		
		
		
		if(cmManager.getActiveNetworkInfo()==null)
		{
			loadButton.setEnabled(false);
			Toast.makeText(MainActivity.this,"Network not avilable",Toast.LENGTH_SHORT).show();
		}
		
		else
		{
			loadButton.setEnabled(true);
            loadButton.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) 
				{
					NetworkingTask networkingTask = new NetworkingTask(outputImageView);
					networkingTask.execute();
				}
			});
		}
		
		
		
		
	}

	

}
