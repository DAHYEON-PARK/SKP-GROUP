package com.example.recipe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.Toast;

public class RecipeDetailActivity extends ActionBarActivity {

	ViewPager viewPager;
	CustomPagerAdapter pagerAdapter;
	
	ImageButton button_cancel;
	ImageButton button_timer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.recipe_detail_page);
		
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		ActionBar bar = getSupportActionBar();
        bar.hide();
		
        button_cancel = (ImageButton)findViewById(R.id.recipe_detail_button_cancel);
        button_timer = (ImageButton)findViewById(R.id.recipe_detail_button_timer);
        
		viewPager = (ViewPager) findViewById(R.id.viewPager);
		//viewPager.setOffscreenPageLimit(3);
		
		
		button_cancel.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				RecipeDetailActivity.this.onBackPressed();
			}
		});
		
		button_timer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Timer Start !", Toast.LENGTH_SHORT).show();
			}
		});
		pagerAdapter = new CustomPagerAdapter(this); 
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		viewPager.setAdapter(pagerAdapter);	
	}

}
