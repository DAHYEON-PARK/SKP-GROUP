package com.example.recipe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
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

public class RecipeActivity extends ActionBarActivity implements OnClickListener, OnScrollChangedListener{ //, OnTouchListener {

	ScrollView recipe_scroll;
	ImageButton detailPageBtn, commentBtn, buyBtn; 
	LinearLayout belowTab;
	
	int prevScrollY;
	int appearY, disappearY;
	static final int DISTANCE = 100;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.recipe_page);
		
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		ActionBar actionBar = getSupportActionBar();
//		actionBar.setDisplayShowTitleEnabled(true);
//		actionBar.setTitle("cheffy");
		actionBar.hide();
        
        recipe_scroll = (ScrollView) this.findViewById(R.id.recipe_scroll);
        recipe_scroll.getViewTreeObserver().addOnScrollChangedListener(this);
//		recipe_scroll.pageScroll(ScrollView.FOCUS_UP);
        
		detailPageBtn = (ImageButton) this.findViewById(R.id.detailPageBtn);
		commentBtn = (ImageButton) this.findViewById(R.id.commentBtn);
		buyBtn = (ImageButton) this.findViewById(R.id.buyBtn);
		
		detailPageBtn.setOnClickListener(this);		
		commentBtn.setOnClickListener(this);
		buyBtn.setOnClickListener(this);
		
		belowTab = (LinearLayout) this.findViewById(R.id.belowTab);
		belowTab.setTag(false);
		
		appearY = 0;
		disappearY = DISTANCE;
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
			case R.id.detailPageBtn : 
				intent = new Intent(this, RecipeDetailActivity.class);
				break;
			case R.id.commentBtn :
				
				break;
			case R.id.buyBtn :
				intent = new Intent(this, OrderActivity.class);
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
	    	  //Log.d("group", "scrollDown  " + belowTab.getHeight());
	    	  
	      } else if (prevScrollY > scrollY ) {
	    	  //Log.d("group", "scrollUp");
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
