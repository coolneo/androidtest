package com.gargi.graphdemo;

import android.app.ActionBar.Tab;
import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

public class TestTabActivity extends FragmentActivity implements ActionBar.TabListener{
	
	TextView titleTextView;
	ViewPager mTabPager;
	TestListFragmentAdapter mTabAdapter;
	ActionBar mActionBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab);
		
		titleTextView = (TextView)findViewById(R.id.titletextview);
		mTabPager = (ViewPager)findViewById(R.id.tabpager);
		mTabPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
            	mActionBar.setSelectedNavigationItem(position);
            }

		});
		mTabAdapter = new TestListFragmentAdapter(getSupportFragmentManager());
		mTabPager.setAdapter(mTabAdapter);
		
		
		mActionBar = getActionBar();
		mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	
			
		mActionBar.addTab(mActionBar.newTab().
								   setText("Practice Test").
								   setTabListener(this));
		mActionBar.addTab(mActionBar.newTab().
								   setText("Time Bound Tests").
								   setTabListener(this));
	}

	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(Tab t, FragmentTransaction arg1) {
		if(t.getPosition() == 0) {
			titleTextView.setText("This is pactice tests ");
		}else {
			titleTextView.setText("These are time bound tests");
		}
	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}

}
