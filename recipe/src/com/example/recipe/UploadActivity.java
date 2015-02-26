package com.example.recipe;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.view.animation.Animation.AnimationListener;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class UploadActivity extends ActionBarActivity implements OnScrollChangedListener, OnClickListener{

	ImageView uploadActionBar;
	FrameLayout titleView;
	ScrollView uploadScroll;
	ImageButton uploadStepPhoto;
	LinearLayout moveView;
	
	ActionBar bar;
	
	boolean flag = false;
	int prevScrollY;
	
	int actionbarHeight;
	boolean scrollFlag = false;
	
	//GestureDetector ges;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.upload_page);
		
	// Window win = getWindow();
	// win.setStatusBarColor(getResources().getColor(R.color.status_bar_color));
	//	 win.setStatusBarColor(Color.WHITE);
		
//		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//	        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
	        //getWindow().setStatusBarColor(getResources().getColor(R.color.status_bar_color));
//	    }
//		
//		Window win = this.getWindow();
//		win.setStatusBarColor(getResources().getColor(R.color.status_bar_color));
		
		
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
		//getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
		//getWindow().setStatusBarColor(Color.TRANSPARENT);
		
		bar = getSupportActionBar();
		bar.hide();
		
		//ges = new GestureDetector(new MyGes());
		
		
//        bar.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar_bg));
        
        
        uploadActionBar = (ImageView) findViewById(R.id.uploadActionBar);
        titleView = (FrameLayout) findViewById(R.id.titleView);
        
        uploadScroll = (ScrollView) findViewById(R.id.uploadScroll);
        uploadScroll.getViewTreeObserver().addOnScrollChangedListener(this);
        
        uploadStepPhoto = (ImageButton) findViewById(R.id.uploadStepPhoto);
        uploadStepPhoto.setOnClickListener(this);
        
        moveView = (LinearLayout) findViewById(R.id.moveView);
	}
	
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		// TODO Auto-generated method stub
		super.onWindowFocusChanged(hasFocus);
		
		actionbarHeight = uploadActionBar.getHeight();
		moveView.scrollTo(0, -actionbarHeight);
		//Log.d("upload", actionbarHeight);
		//uploadActionBar.bringToFront();
	}
	
//	@Override
//	public boolean onTouchEvent(MotionEvent event) {
//		// TODO Auto-generated method stub
//	
//		if(ges.onTouchEvent(event))
//		{	return true;
//	}
//		return super.onTouchEvent(event);
//		
//	}
//
//	class MyGes extends SimpleOnGestureListener{
//		@Override
//		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
//			// TODO Auto-generated method stub
//			
//			Log.e("upload", "test");
//			return super.onFling(e1, e2, velocityX, velocityY);
//		}
//	}
	
	@Override
	public void onScrollChanged() {
		int scrollY = uploadScroll.getScrollY();  //for verticalScrollView
		
		if( (prevScrollY < scrollY) && scrollY >= actionbarHeight*2 ){	// 스크롤 다운
			
			moveView.scrollTo(0, 0);
			
		
//	  		AlphaAnimation anim2 = new AlphaAnimation(1, 0);	// 실사에서 투명으로 alpha 값
//	  		TranslateAnimation anim = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0,
//	  				Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, -1);
//	  		
//	  		AnimationSet set = new AnimationSet(true);
//	  		set.addAnimation(anim);
//	  		set.addAnimation(anim2);
//	  		set.setDuration(600);
//	  		
//	  		set.setAnimationListener(new AnimationListener() {
//				@Override
//				public void onAnimationStart(Animation animation) {
//					// TODO Auto-generated method stub
//				}
//				
//				@Override
//				public void onAnimationRepeat(Animation animation) {
//					// TODO Auto-generated method stub
//				}
//				
//				@Override
//				public void onAnimationEnd(Animation animation) {
//					// TODO Auto-generated method stub
//					uploadActionBar.setVisibility(View.GONE);
//				}
//			});
//	  		
//	  		//set.setFillAfter(true);
//	  
//	  		uploadActionBar.clearAnimation();
//	  		uploadActionBar.startAnimation(set);
			scrollFlag = false;
			
		}
		else if(   (prevScrollY > scrollY) && scrollY <= actionbarHeight/2  ){ 	// action bar 다시 생김.
//			 
//			Log.d("upload",String.valueOf(scrollY));
//			
			if(!scrollFlag){
				scrollFlag = true;
				moveView.scrollTo(0, -actionbarHeight);
				
			}
			
//				bar.show();
//			
//			uploadActionBar.setVisibility(View.VISIBLE);
//			
//			AlphaAnimation anim2 = new AlphaAnimation(0, 1);
//  		  	TranslateAnimation anim = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0,
//  				  Animation.RELATIVE_TO_SELF, -1, Animation.RELATIVE_TO_SELF, 0);
//  		  	    		 
//	  		AnimationSet set = new AnimationSet(true);
//	  		set.addAnimation(anim);		// 얘는 아래로 사라지게 하는 것
//	  		set.addAnimation(anim2);	// 얘는 dim처럼 점차 사라지는 것
//	  		set.setDuration(600);
//
//	  		uploadActionBar.clearAnimation();
//	  		uploadActionBar.startAnimation(set);	
		}
//		
		prevScrollY = scrollY;

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		if(flag==false){
			flag=true;
			AlphaAnimation ani = new AlphaAnimation(0, 1);
			ani.setDuration(500);
			uploadStepPhoto.setImageDrawable(getResources().getDrawable(R.drawable.upload_step1_photo_change));
			uploadStepPhoto.startAnimation(ani);
		}
		
	}

	
}
