package com.example.recipe;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

public class RecipeDetailActivity extends Activity{

	ViewPager viewPager;
	CustomPagerAdapter pagerAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.recipe_detail_page);

		viewPager = (ViewPager) findViewById(R.id.viewPager);
		pagerAdapter = new CustomPagerAdapter(this); 
		//viewPager.setAdapter(pagerAdapter);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		viewPager.setAdapter(pagerAdapter);
		
	}

	
}
