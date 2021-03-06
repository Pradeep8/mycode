package com.jspiders.multipanefragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.TextView;

public class VersionDescription extends Fragment {
	
	
	String[] version_desc = {"This is version 1","This is version 2","This is version 3",
			                 "This is version 4","This is version 5","This is version 6"};
	TextView descriptionTextView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) 
	{
		return inflater.inflate(R.layout.version_detail_fragment, container,false);
	}

	@Override
	public void onStart() 
	{
		super.onStart();
		
		Bundle b1 =  getArguments();
		
		recvposition( b1.getInt("position"));
	}
	
	public void recvposition(int position) 
	{
		descriptionTextView = (TextView)getActivity().findViewById(R.id.textView1);
		descriptionTextView.setText(version_desc[position]);
	}
}
