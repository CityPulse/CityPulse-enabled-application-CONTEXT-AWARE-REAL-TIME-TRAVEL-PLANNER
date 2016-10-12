package com.siemens.parkingapp;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
 
public class MainActivity extends FragmentActivity implements ActionBar.TabListener {
	
	private ViewPager viewPager;
	private TabPagerAdapter mAdapter;
	private ActionBar actionBar;
	private String[] tabs = { "Parking place", "Route", "Settings" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);

	    // Initialization
	    viewPager = (ViewPager) findViewById(R.id.pager);
	    actionBar = getActionBar();
	    mAdapter = new TabPagerAdapter(getSupportFragmentManager());

	    viewPager.setAdapter(mAdapter);
	    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);        

	    // Adding Tabs
	    for (String tab_name : tabs) {
	        actionBar.addTab(actionBar.newTab().setText(tab_name)
	                .setTabListener(this));
	    }
	    viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

	        @Override
	        public void onPageSelected(int position) {
	            // on changing the page
	            // make respected tab selected
	            actionBar.setSelectedNavigationItem(position);
	        }

	        @Override
	        public void onPageScrolled(int arg0, float arg1, int arg2) {
	        }

	        @Override
	        public void onPageScrollStateChanged(int arg0) {
	        }
	    });
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
	    // on tab selected
	    // show respected fragment view
	    viewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
	}
 
}