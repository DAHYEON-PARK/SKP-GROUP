package com.example.recipe;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class mViewAdapter extends PagerAdapter {

	private final int pageNum = 3;
	
	Context context;
	
	public mViewAdapter(Context context){
		this.context = context;		
	}
	
	
	@Override
	public int getCount() {
		return pageNum;
	}
	
	
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		
		FrameLayout Detail = (FrameLayout) View.inflate(context, R.layout.main_view, null);
		ImageView bg = (ImageView) Detail.findViewById(R.id.bg);
		ImageView rank = (ImageView) Detail.findViewById(R.id.rank);
		
		if(position==0){
			bg.setImageDrawable(context.getResources().getDrawable(R.drawable.main_rank_first_bg));
			rank.setImageDrawable(context.getResources().getDrawable(R.drawable.main_rank_first_title));
			container.addView(Detail);	
			return Detail;
		}else if(position==1){
			bg.setImageDrawable(context.getResources().getDrawable(R.drawable.main_rank_second_bg));
			rank.setImageDrawable(context.getResources().getDrawable(R.drawable.main_rank_second_title));
			container.addView(Detail);
			return Detail;
		}else if(position==2){
			bg.setImageDrawable(context.getResources().getDrawable(R.drawable.main_rank_third_bg));
			rank.setImageDrawable(context.getResources().getDrawable(R.drawable.main_rank_third_title));
			container.addView(Detail);
			return Detail;
		}

		return null; //super.instantiateItem(container, position);
	}

	@Override
	public boolean isViewFromObject(View v, Object obj) {
//		return false;
		return v==obj; 
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
//		super.destroyItem(container, position, object);
		container.removeView((View)object);
	}

}
