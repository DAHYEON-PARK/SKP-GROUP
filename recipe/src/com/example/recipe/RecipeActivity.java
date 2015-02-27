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
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

public class RecipeActivity extends ActionBarActivity implements OnClickListener, OnScrollChangedListener{ 

	ActionBarDrawerToggle dtToggle;
	DrawerLayout dlDrawer;
	
	ScrollView recipe_scroll;
	ImageButton leftBtn, rightBtn;
	ImageButton detailPageBtn, commentBtn, buyBtn; 
	ImageButton categoryView;
	LinearLayout belowTab;
	
	int prevScrollY;
	int appearY, disappearY;
	static final int DISTANCE = 100;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.recipe_page);
		
		dlDrawer = (DrawerLayout) findViewById(R.id.dl_activity_main);
		dtToggle = new ActionBarDrawerToggle(this, dlDrawer, R.drawable.ic_drawer,0, 0);
		
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		ActionBar actionBar = getSupportActionBar();
		actionBar.hide();
        
        recipe_scroll = (ScrollView) this.findViewById(R.id.recipe_scroll);
        recipe_scroll.getViewTreeObserver().addOnScrollChangedListener(this);
        
        leftBtn = (ImageButton) findViewById(R.id.leftBtn);
        rightBtn = (ImageButton) findViewById(R.id.rightBtn);
        
		detailPageBtn = (ImageButton) this.findViewById(R.id.detailPageBtn);
		commentBtn = (ImageButton) this.findViewById(R.id.commentBtn);
		buyBtn = (ImageButton) this.findViewById(R.id.buyBtn);
		
		leftBtn.setOnClickListener(this);	
		rightBtn.setOnClickListener(this);	
		
		detailPageBtn.setOnClickListener(this);		
		commentBtn.setOnClickListener(this);
		buyBtn.setOnClickListener(this);
		
		belowTab = (LinearLayout) this.findViewById(R.id.belowTab);
		belowTab.setTag(false);
		
		appearY = 0;
		disappearY = DISTANCE;
		
		categoryView = (ImageButton) findViewById(R.id.categoryView);
		categoryView.setOnClickListener(this);
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
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		Intent intent = null; 
		
		switch(v.getId()){
			case R.id.leftBtn : 
				super.onBackPressed();
				break;
			case R.id.rightBtn : 
				dlDrawer.openDrawer(Gravity.RIGHT);
				break;
			case R.id.detailPageBtn : 
				intent = new Intent(this, RecipeDetailActivity.class);
				break;
			case R.id.buyBtn :
				intent = new Intent(this, OrderActivity.class);
				break;
			case R.id.categoryView :
				dlDrawer.closeDrawer(Gravity.RIGHT);
				Toast.makeText(this, "이벤트 구현 예정이에요~", Toast.LENGTH_SHORT).show();
				break;
			default : 
				Toast.makeText(this, "진짜 댓글을 작성하실 건가요?", Toast.LENGTH_SHORT).show();
				break;
		}
		
		if(intent != null){
			startActivity(intent);
		}
	}

	@Override
	public void onScrollChanged() {
	      int scrollY = recipe_scroll.getScrollY();  //for verticalScrollView
	      
	      if (prevScrollY < scrollY) {	// 두번째 방법 : Math.abs(prevScrollY - scrollY) == 50
	    	  if ((Boolean)belowTab.getTag() == false && disappearY <= scrollY) {
	    		  belowTab.setTag(true);
	    		  
	    		  AlphaAnimation anim2 = new AlphaAnimation(1, 0);
	    		  TranslateAnimation anim = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0,
	    				  Animation.RELATIVE_TO_SELF, 0,Animation.RELATIVE_TO_SELF, 1);
	    		  	    		  
	    		  belowTab.clearAnimation();
	    		  
	    		  AnimationSet set = new AnimationSet(true);
	    		  set.addAnimation(anim);	// 얘는 아래로 사라지게 하는 것
	    		  set.addAnimation(anim2);	// 얘는 dim처럼 점차 사라지는 것
	    		  set.setDuration(600);
	    		  set.setAnimationListener(new AnimationListener() {

					@Override
					public void onAnimationStart(Animation animation) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onAnimationEnd(Animation animation) {
						// TODO Auto-generated method stub
						belowTab.setVisibility(View.GONE);
					}

					@Override
					public void onAnimationRepeat(Animation animation) {
						// TODO Auto-generated method stub
						
					}
	    			  
	    		  });

	    		  belowTab.startAnimation(set);	    		 
	    	  }
	    	  appearY = scrollY - DISTANCE;
	    	  
	      } else if (prevScrollY > scrollY ) {
	    	  
	    	  if ((Boolean)belowTab.getTag() == true && scrollY <= appearY) {	    		  
	    		  belowTab.setVisibility(View.VISIBLE);
	    		  belowTab.setTag(false);
	    		  
	    		  AlphaAnimation anim2 = new AlphaAnimation(0, 1);
	    		  TranslateAnimation anim = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0,
	    				  Animation.RELATIVE_TO_SELF, 1,Animation.RELATIVE_TO_SELF, 0);
	    		  AnimationSet set = new AnimationSet(true);
	    		  set.addAnimation(anim);
	    		  set.addAnimation(anim2);
	    		  set.setDuration(600);
	    	
	    		  belowTab.clearAnimation();
	    		  belowTab.startAnimation(set);
	    		  
	    	  }
	    	  disappearY = scrollY + DISTANCE;
	      }
	      
	      prevScrollY = scrollY;
	}

}
