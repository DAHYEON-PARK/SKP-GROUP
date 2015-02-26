package com.example.recipe;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class mViewSecondAdapter extends PagerAdapter implements OnClickListener {

	private final int pageNum = 3;
	
	//int tabFlag = 1;
	
	Context context;
	
	public mViewSecondAdapter(Context context){
		this.context = context;		
	}
	
//	public void setTabFlag(int num){
//		tabFlag = num;
//	}
	
	
	@Override
	public int getCount() {
		return pageNum;
	}
	
	
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		
		FrameLayout Detail = (FrameLayout) View.inflate(context, R.layout.main_view, null);
		ImageView bg = (ImageView) Detail.findViewById(R.id.bg);
		
		bg.setOnClickListener(this);
		
		//ImageView rank = (ImageView) Detail.findViewById(R.id.rank);
		
//		if(tabFlag == 1){
//			if(position==0){
//				bg.setImageDrawable(context.getResources().getDrawable(R.drawable.main_rank_first_bg));
//				//rank.setImageDrawable(context.getResources().getDrawable(R.drawable.main_rank_first_title));
//				container.addView(Detail);	
//				return Detail;
//			}else if(position==1){
//				bg.setImageDrawable(context.getResources().getDrawable(R.drawable.main_rank_second_bg));
//				//rank.setImageDrawable(context.getResources().getDrawable(R.drawable.main_rank_second_title));
//				container.addView(Detail);
//				return Detail;
//			}else if(position==2){
//				bg.setImageDrawable(context.getResources().getDrawable(R.drawable.main_rank_third_bg));
//				//rank.setImageDrawable(context.getResources().getDrawable(R.drawable.main_rank_third_title));
//				container.addView(Detail);
//				return Detail;
//			}
//		}else if(tabFlag == 2){
			if(position==0){
				bg.setImageDrawable(context.getResources().getDrawable(R.drawable.main_test_one));
				//rank.setImageDrawable(context.getResources().getDrawable(R.drawable.main_rank_first_title));
				bg.setTag(0);
				container.addView(Detail);	
				return Detail;
			}else if(position==1){
				bg.setImageDrawable(context.getResources().getDrawable(R.drawable.main_test_two));
				//rank.setImageDrawable(context.getResources().getDrawable(R.drawable.main_rank_second_title));
				bg.setTag(1);
				container.addView(Detail);
				return Detail;
			}else if(position==2){
				bg.setImageDrawable(context.getResources().getDrawable(R.drawable.main_test_three));
				//rank.setImageDrawable(context.getResources().getDrawable(R.drawable.main_rank_third_title));
				bg.setTag(2);
				container.addView(Detail);
				return Detail;
			}
//		}
		

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

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		ImageView view = (ImageView) v;
		if((Integer)view.getTag() == 0)
			Toast.makeText(context, "tv기획전 : "+ ((Integer)view.getTag()+1)+"\n구현 예정", Toast.LENGTH_SHORT).show();
		else if((Integer)view.getTag() == 1)
			Toast.makeText(context, "tv기획전 : "+ ((Integer)view.getTag()+1)+"\n구현 예정", Toast.LENGTH_SHORT).show();
		else if((Integer)view.getTag() == 2)
			Toast.makeText(context, "tv기획전 : "+ ((Integer)view.getTag()+1)+"\n구현 예정", Toast.LENGTH_SHORT).show();
	}

}
