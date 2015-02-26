package com.example.recipe;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class FirstPage extends Fragment implements OnClickListener, OnPageChangeListener {

	ViewPager mViewPager;
	mViewAdapter mPagerAdapter;
	mViewSecondAdapter mSecondAdapter;
	ImageButton rankBtn, tvBtn, honeyMixBtn, etcBtn;
	
	View view;
	ImageView indicator;	
	ImageView curTitle;
	
	int tabFlag = 1;
	
	public FirstPage newInstance() {
		FirstPage fragment = new FirstPage();
		return fragment;
	}

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		view = inflater.inflate(R.layout.main_tab, container, false);
		
		mViewPager = (ViewPager) view.findViewById(R.id.pager);
		mViewPager.setOnPageChangeListener(this);
		mViewPager.setOffscreenPageLimit(3);
		
		indicator = (ImageView) view.findViewById(R.id.indicator);
		//prevTitle = (ImageView) view.findViewById(R.id.prevTitle);
		curTitle = (ImageView) view.findViewById(R.id.curTitle);
		
		rankBtn = (ImageButton) view.findViewById(R.id.rankBtn);
		tvBtn = (ImageButton) view.findViewById(R.id.tvBtn);
		honeyMixBtn = (ImageButton) view.findViewById(R.id.honeymixBtn);
		etcBtn = (ImageButton) view.findViewById(R.id.etcBtn);
		
		rankBtn.setOnClickListener(this);
		tvBtn.setOnClickListener(this);
		honeyMixBtn.setOnClickListener(this);
		etcBtn.setOnClickListener(this);
		
		rankBtn.setSelected(true);
		
		mPagerAdapter = new mViewAdapter(getActivity());
		mSecondAdapter = new mViewSecondAdapter(getActivity());
		
		mViewPager.setAdapter(mPagerAdapter);
		
		return view;
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch(v.getId()){
			case R.id.rankBtn : 
				setSelect(true, false, false);
				tabFlag = 1;
//				mPagerAdapter.setTabFlag(1);
//				mPagerAdapter.notifyDataSetChanged();
				mViewPager.setAdapter(mPagerAdapter);
				onPageSelected(0);
				//Log.d("main","첫번째" + mViewPager.getChildCount());
				break;
			case R.id.tvBtn : 
				setSelect(false, true, false);
				tabFlag = 2;
//				mPagerAdapter.setTabFlag(2);
//				mPagerAdapter.notifyDataSetChanged();
				mViewPager.setAdapter(mSecondAdapter);
				onPageSelected(0);
				//Log.d("main","두번째" + mViewPager.getChildCount());
				break;
			default:
				Toast.makeText(getActivity(), "구현 예정", Toast.LENGTH_SHORT).show();
				break;
//			case R.id.honeymixBtn : 
//				setSelect(false, false, true);
//				break;
		}
	}
	
	public void setSelect(boolean rank, boolean tv, boolean honeyMix){
		rankBtn.setSelected(rank);
		tvBtn.setSelected(tv);
		//honeyMixBtn.setSelected(honeyMix);
	}


	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onPageSelected(int currentPage) {
		// TODO Auto-generated method stub
		
		if(tabFlag==1){
			indicator.setBackgroundColor(Color.TRANSPARENT);
			
			if(currentPage == 0){
				indicator.setImageDrawable(getResources().getDrawable(R.drawable.main_rank_first_indicator));
				curTitle.setImageDrawable(getResources().getDrawable(R.drawable.main_rank_first_title));
				
			}else if(currentPage == 1){
				indicator.setImageDrawable(getResources().getDrawable(R.drawable.main_rank_second_indicator));
				curTitle.setImageDrawable(getResources().getDrawable(R.drawable.main_rank_second_title));
			}else if(currentPage == 2){
				indicator.setImageDrawable(getResources().getDrawable(R.drawable.main_rank_third_indicator));
				curTitle.setImageDrawable(getResources().getDrawable(R.drawable.main_rank_third_title));
			}
		}else if(tabFlag==2){
			if(currentPage == 0){
				indicator.setImageDrawable(getResources().getDrawable(R.drawable.main_rank_first_indicator));
				curTitle.setImageDrawable(null);
			}else if(currentPage == 1){
				indicator.setImageDrawable(getResources().getDrawable(R.drawable.main_rank_second_indicator));
				curTitle.setImageDrawable(null);
			}else if(currentPage == 2){
				indicator.setImageDrawable(getResources().getDrawable(R.drawable.main_rank_third_indicator));
				curTitle.setImageDrawable(null);			}
		}
		
		Animation fadeIn = new AlphaAnimation(0, 1);
		fadeIn.setDuration(300);
		fadeIn.setFillAfter(true);
		
		curTitle.setAnimation(fadeIn);
	}
	
	

}