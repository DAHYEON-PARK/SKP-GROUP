package com.example.recipe;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class mViewSecondAdapter extends PagerAdapter implements OnClickListener {

	private final int pageNum = 3;
	
	Context context;
	
	public mViewSecondAdapter(Context context){
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
		
		bg.setOnClickListener(this);
		
		if(position==0){
			bg.setImageDrawable(context.getResources().getDrawable(R.drawable.main_test_one));
			bg.setTag(0);
			container.addView(Detail);	
			return Detail;
		}else if(position==1){
			bg.setImageDrawable(context.getResources().getDrawable(R.drawable.main_test_two));
			bg.setTag(1);
			container.addView(Detail);
			return Detail;
		}else if(position==2){
			bg.setImageDrawable(context.getResources().getDrawable(R.drawable.main_test_three));
			bg.setTag(2);
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

	@Override
	public void onClick(View v) {
		ImageView view = (ImageView) v;
		
		if((Integer)view.getTag() == 0)
			Toast.makeText(context, "tv기획전 : "+ ((Integer)view.getTag()+1)+"\n구현 예정", Toast.LENGTH_SHORT).show();
		else if((Integer)view.getTag() == 1)
			Toast.makeText(context, "tv기획전 : "+ ((Integer)view.getTag()+1)+"\n구현 예정", Toast.LENGTH_SHORT).show();
		else if((Integer)view.getTag() == 2)
			Toast.makeText(context, "tv기획전 : "+ ((Integer)view.getTag()+1)+"\n구현 예정", Toast.LENGTH_SHORT).show();
	}

}
