package com.example.recipe;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.WindowManager;

public class RecipeDetailActivity extends ActionBarActivity {

	ViewPager viewPager;
	CustomPagerAdapter pagerAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.recipe_detail_page);
		
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		ActionBar bar = getSupportActionBar();
        bar.hide();
		
		viewPager = (ViewPager) findViewById(R.id.viewPager);
		//viewPager.setOffscreenPageLimit(3);
		
		pagerAdapter = new CustomPagerAdapter(this); 
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		viewPager.setAdapter(pagerAdapter);	
	}

}
