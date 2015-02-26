package com.example.recipe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

public class FirstPage extends Fragment implements OnClickListener, OnPageChangeListener {

	ViewPager mViewPager;
	mViewAdapter mPagerAdapter;
	ImageButton rankBtn, tvBtn, honeyMixBtn;
	
	View view;
	ImageView indicator; //, title;
	
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
		//title = (ImageView) view.findViewById(R.id.title);
		
		rankBtn = (ImageButton) view.findViewById(R.id.rankBtn);
		tvBtn = (ImageButton) view.findViewById(R.id.tvBtn);
		honeyMixBtn = (ImageButton) view.findViewById(R.id.honeymixBtn);
		
		rankBtn.setOnClickListener(this);
		tvBtn.setOnClickListener(this);
		honeyMixBtn.setOnClickListener(this);
		
		rankBtn.setSelected(true);
		
		mPagerAdapter = new mViewAdapter(getActivity());
		mViewPager.setAdapter(mPagerAdapter);
		
		return view;
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch(v.getId()){
			case R.id.rankBtn : 
				setSelect(true, false, false);
				break;
			case R.id.tvBtn : 
				setSelect(false, true, false);
				break;
			case R.id.honeymixBtn : 
				setSelect(false, false, true);
				break;
		}
	}
	
	public void setSelect(boolean rank, boolean tv, boolean honeyMix){
		rankBtn.setSelected(rank);
		tvBtn.setSelected(tv);
		honeyMixBtn.setSelected(honeyMix);
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
		
		if(currentPage == 0){
			indicator.setImageDrawable(getResources().getDrawable(R.drawable.main_rank_first_indicator));
			//title.setImageDrawable(getResources().getDrawable(R.drawable.main_rank_first_title));
		}else if(currentPage == 1){
			indicator.setImageDrawable(getResources().getDrawable(R.drawable.main_rank_second_indicator));
			//title.setImageDrawable(getResources().getDrawable(R.drawable.main_rank_second_title));
		}else if(currentPage == 2){
			indicator.setImageDrawable(getResources().getDrawable(R.drawable.main_rank_third_indicator));
			//title.setImageDrawable(getResources().getDrawable(R.drawable.main_rank_third_title));
		}
	}

}