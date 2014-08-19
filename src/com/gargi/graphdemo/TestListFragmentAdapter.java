package com.gargi.graphdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class TestListFragmentAdapter extends FragmentStatePagerAdapter {

	public TestListFragmentAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int arg0) {
		Fragment testListFragment = new TestListFragment();
		Bundle dataBundle = new Bundle();
		dataBundle.putString(TestListFragment.DATA_KEY, getData(arg0));
		testListFragment.setArguments(dataBundle);
		return testListFragment;
	}
	
	private String getData(int index) {
		return "Tab With Index = "+index;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 2;
	}

}
