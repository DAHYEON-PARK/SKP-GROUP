package com.example.recipe;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.Toast;

public class SpecialActivity extends ActionBarActivity implements OnClickListener{

	ImageButton leftBtn, rightBtn;
	ImageButton firstView, secondView, thirdView;
	ImageButton categoryView;
	
	ActionBarDrawerToggle dtToggle;
	DrawerLayout dlDrawer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.special_page);
		
		leftBtn = (ImageButton) findViewById(R.id.actionLeftBtn);
		rightBtn = (ImageButton) findViewById(R.id.actionRightBtn);
		
		firstView = (ImageButton) findViewById(R.id.firstView);
		secondView = (ImageButton) findViewById(R.id.secondView);
		thirdView = (ImageButton) findViewById(R.id.thirdView);
		
		categoryView = (ImageButton) findViewById(R.id.categoryView);
		
		leftBtn.setOnClickListener(this);
		rightBtn.setOnClickListener(this);
		
		firstView.setOnClickListener(this);
		secondView.setOnClickListener(this);
		thirdView.setOnClickListener(this);
		
		categoryView.setOnClickListener(this);
		
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ActionBar bar = getSupportActionBar();
        bar.hide();
        
        dlDrawer = (DrawerLayout) findViewById(R.id.dl_activity_main);
        dtToggle = new ActionBarDrawerToggle(this, dlDrawer, R.drawable.ic_drawer,0, 0);
	}

	@Override
	protected void onPostResume() {
		// TODO Auto-generated method stub
		super.onPostResume();
	}

	
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		dtToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		dtToggle.onConfigurationChanged(newConfig);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (dtToggle.onOptionsItemSelected(item)) {
			return true;
		}
		return super.onOptionsItemSelected(item);
		
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
				
		switch(v.getId()){
			case R.id.actionLeftBtn : 
				Intent homeIntent = new Intent(this, MainActivity.class);
				startActivity(homeIntent);
				break;
			case R.id.actionRightBtn :
				dlDrawer.openDrawer(Gravity.RIGHT);
				break;
			case R.id.secondView :
				Intent recipeIntent = new Intent(this, RecipeActivity.class);
				startActivity(recipeIntent);
				break;
			case R.id.categoryView :
				dlDrawer.closeDrawer(Gravity.RIGHT);
				Toast.makeText(this, "이벤트 구현 예정", Toast.LENGTH_SHORT).show();
				break;
			default :
				Toast.makeText(this, "2번째 뷰를\n눌러주세요.", Toast.LENGTH_SHORT).show();
				break;					
		}
		
	}

}
