package com.jspiders.internalstorage;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	EditText inputEditText;
	Button saveButton,readButton;
	TextView outputTextView;
	
   private	FileOutputStream fos;
   private FileInputStream fis;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		inputEditText = (EditText) findViewById(R.id.editTextinput);
		saveButton = (Button) findViewById(R.id.buttonsave);
		readButton = (Button) findViewById(R.id.buttonread);
		outputTextView = (TextView) findViewById(R.id.textView1);
		
		
		saveButton.setOnClickListener(new OnClickListener() 
		{
			
			@Override
			public void onClick(View arg0) 
			{
				String data = inputEditText.getText().toString();
				
				try 
				{
					fos = openFileOutput("myfile",Context.MODE_PRIVATE);
					fos.write(data.getBytes());
				} 
				
				catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
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
						fos.flush();
						fos.close();
					} 
					catch (IOException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
		
	
		readButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) 
			{
				try 
				{
					fis = openFileInput("myfile");
					
					InputStreamReader inputStreamReader = new InputStreamReader(fis);
					
					BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
					
					StringBuffer stringBuffer = new StringBuffer();
					
					String line = "";
					
					while((line = bufferedReader.readLine())!=null)
					{
						stringBuffer.append(line+"\n");
					}
					
					String output = stringBuffer.toString();
					outputTextView.setText(output);
				}
				
				catch (FileNotFoundException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				finally
				{
					try {
						fis.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
	
	}

	

}
