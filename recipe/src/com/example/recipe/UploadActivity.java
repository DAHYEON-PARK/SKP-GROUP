package com.example.recipe;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.VideoView;

public class UploadActivity extends ActionBarActivity implements OnScrollChangedListener, OnClickListener{

	FrameLayout uploadActionBar;
	ImageButton actionBarBtn;
	
	LinearLayout moveView;
	ScrollView uploadScroll;
	
	ImageButton video, pplBtn, timeBtn, difficultBtn, uploadStepOnePhoto, uploadStepTwoPhoto;
	ImageButton upload_button_register;
	
	ActionBar bar;
	CustomDialog customDialog;
	
	int prevScrollY;
	int actionbarHeight;
	boolean scrollFlag = false;
	boolean dialogFlag = false;
	boolean videoFlag = true, stepOneFlag = true, stepTwoFlag = true;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.upload_page);
		
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		bar = getSupportActionBar();
		bar.hide();
        
        uploadActionBar = (FrameLayout) findViewById(R.id.uploadActionBar);
        actionBarBtn = (ImageButton) findViewById(R.id.actionBarBtn);
        actionBarBtn.setOnClickListener(this);
        
        moveView = (LinearLayout) findViewById(R.id.moveView);
        
        uploadScroll = (ScrollView) findViewById(R.id.uploadScroll);
        uploadScroll.getViewTreeObserver().addOnScrollChangedListener(this);
        
        video = (ImageButton) findViewById(R.id.video);
        video.setOnClickListener(this);
        
        pplBtn = (ImageButton) findViewById(R.id.pplBtn);
        timeBtn = (ImageButton) findViewById(R.id.timeBtn);
        difficultBtn = (ImageButton) findViewById(R.id.difficultBtn);
        pplBtn.setOnClickListener(this);
        timeBtn.setOnClickListener(this);
        difficultBtn.setOnClickListener(this);
                    
        uploadStepOnePhoto = (ImageButton) findViewById(R.id.uploadStepOnePhoto);
        uploadStepOnePhoto.setOnClickListener(this);
        uploadStepTwoPhoto = (ImageButton) findViewById(R.id.uploadStepTwoPhoto);
        uploadStepTwoPhoto.setOnClickListener(this);
        
        upload_button_register = (ImageButton)findViewById(R.id.upload_button_register);
        upload_button_register.setOnClickListener(this);
        
	}
	
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		// TODO Auto-generated method stub
		super.onWindowFocusChanged(hasFocus);
		
		if(!dialogFlag){
			actionbarHeight = uploadActionBar.getHeight();
			moveView.scrollTo(0, -actionbarHeight);
		}
	}

	
	@Override
	public void onScrollChanged() {
		int scrollY = uploadScroll.getScrollY();  //for verticalScrollView
		
		if((prevScrollY < scrollY) && scrollY >= actionbarHeight*2 ){	// 스크롤 다운
			
			moveView.scrollTo(0, 0);			
			scrollFlag = false;
		}
		else if((prevScrollY > scrollY) && scrollY <= actionbarHeight/2 ){ 	// action bar 다시 생김.

			if(!scrollFlag){
				scrollFlag = true;
				moveView.scrollTo(0, -actionbarHeight);
			}
		}
		prevScrollY = scrollY;
	}
	

	@Override
	public void onClick(View v) {
		
		switch(v.getId()){
		case R.id.actionBarBtn :
			super.onBackPressed();
			break;
		case R.id.video :
			if(videoFlag){
				AlphaAnimation ani2 = new AlphaAnimation(0, 1);
				ani2.setDuration(500);
				ani2.setFillAfter(true);
				video.setImageDrawable(getResources().getDrawable(R.drawable.upload_addphoto_real));
				video.startAnimation(ani2);
				videoFlag = false;
			}
			break;
		case R.id.pplBtn :
			pplBtn.setImageDrawable(getResources().getDrawable(R.drawable.upload_ppl_two));
			break;
		case R.id.timeBtn :
			timeBtn.setImageDrawable(getResources().getDrawable(R.drawable.upload_time_thirty));
			break;
		case R.id.difficultBtn :
			difficultBtn.setImageDrawable(getResources().getDrawable(R.drawable.upload_difficulty_normal));
			break;
		case R.id.uploadStepOnePhoto :	
			if(stepOneFlag){
				AlphaAnimation ani = new AlphaAnimation(0, 1);
				ani.setDuration(500);
				ani.setFillAfter(true);
				uploadStepOnePhoto.setImageDrawable(getResources().getDrawable(R.drawable.upload_step1_photo_change));
				uploadStepOnePhoto.startAnimation(ani);
				stepOneFlag = false;
			}
			break;
		case R.id.uploadStepTwoPhoto :	
			if(stepTwoFlag){
				AlphaAnimation ani3 = new AlphaAnimation(0, 1);
				ani3.setDuration(500);
				ani3.setFillAfter(true);
				uploadStepTwoPhoto.setImageDrawable(getResources().getDrawable(R.drawable.upload_step_two_photo));
				uploadStepTwoPhoto.startAnimation(ani3);
				stepTwoFlag = false;
			}			
			break;
		
		case R.id.upload_button_register:
			dialogFlag = true;
			customDialog = new CustomDialog(UploadActivity.this,"upload");
			customDialog.show();
			break;
		default:
			break;
		}
		
	}

}
