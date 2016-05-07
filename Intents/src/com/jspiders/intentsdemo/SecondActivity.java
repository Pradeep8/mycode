package com.jspiders.intentsdemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends Activity {

	EditText inpuEditText;
	Button sendButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		inpuEditText = (EditText) findViewById(R.id.editTextinput);
		sendButton = (Button) findViewById(R.id.buttonsend);
		
		sendButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) 
			{
				String data =inpuEditText.getText().toString();
				Intent intent = getIntent();
				intent.putExtra("Key1",data);
				setResult(RESULT_OK,intent);
				finish();
				
			}
		});
	}


}
