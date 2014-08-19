package com.gargi.graphdemo;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TestListFragment extends Fragment{
	
	final static String DATA_KEY = "datakey";
	
	@Override
    public View onCreateView(LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.fragment_test_list, 
												container, false);
		Bundle args = getArguments();
		String data = args.getString(DATA_KEY);
		
		TextView title = (TextView)rootView.findViewById(R.id.fragmenttextview);
		title.setText(data);
		
		return null;
		
	}

}
