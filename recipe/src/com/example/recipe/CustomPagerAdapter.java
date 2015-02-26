package com.example.recipe;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class CustomPagerAdapter extends PagerAdapter implements OnClickListener{

//	List<ViewGroup> viewHolder = new ArrayList<ViewGroup>();  재활용??
	private final int pageNum = 8;
	
	Context context;
	ImageButton leftBtn, rightBtn;
	
	public CustomPagerAdapter(Context context){
		this.context = context;		
	}
	
	@Override
	public int getCount() {
		return pageNum;
	}
	
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		FrameLayout recipeDetail;
		ImageView recipeImg;
		
		recipeDetail = (FrameLayout) View.inflate(context, R.layout.recipe_detail_cell_page, null);
		recipeImg = (ImageView) recipeDetail.findViewById(R.id.recipeImg);
		
		leftBtn = (ImageButton) recipeDetail.findViewById(R.id.leftBtn);
		rightBtn = (ImageButton) recipeDetail.findViewById(R.id.rightBtn);
		
		leftBtn.setOnClickListener(this);
		rightBtn.setOnClickListener(this);
		
		if(position==0){
			recipeImg.setImageDrawable(context.getResources().getDrawable(R.drawable.recipe_detail_view_1));
			determineBtnShow(false, true);
			container.addView(recipeDetail);	// 구지 position을 넣어줄 필요가 없다!!! 왜 넣었었지;;;
			return recipeDetail;
		}else if(position==1){
			recipeImg.setImageDrawable(context.getResources().getDrawable(R.drawable.recipe_detail_view_2));
			determineBtnShow(true, true);
			container.addView(recipeDetail);
			return recipeDetail;
		}else if(position==2){
			recipeImg.setImageDrawable(context.getResources().getDrawable(R.drawable.recipe_detail_view_3));
			determineBtnShow(true, true);
			container.addView(recipeDetail);
			return recipeDetail;
		}else if(position==3){
			recipeImg.setImageDrawable(context.getResources().getDrawable(R.drawable.recipe_detail_view_4));
			determineBtnShow(true, true);
			container.addView(recipeDetail);
			return recipeDetail;
		}else if(position==4){
			recipeImg.setImageDrawable(context.getResources().getDrawable(R.drawable.recipe_detail_view_5));
			determineBtnShow(true, true);
			container.addView(recipeDetail);
			return recipeDetail;
		}else if(position==5){
			recipeImg.setImageDrawable(context.getResources().getDrawable(R.drawable.recipe_detail_view_6));
			determineBtnShow(true, true);
			container.addView(recipeDetail);
			return recipeDetail;
		}else if(position==6){
			recipeImg.setImageDrawable(context.getResources().getDrawable(R.drawable.recipe_detail_view_7));
			determineBtnShow(true, true);
			container.addView(recipeDetail);
			return recipeDetail;
		}else if(position==7){
			recipeImg.setImageDrawable(context.getResources().getDrawable(R.drawable.recipe_detail_view_8));
			determineBtnShow(true, false);
			container.addView(recipeDetail);
			return recipeDetail;
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
		// TODO Auto-generated method stub
		switch(v.getId()){
			case R.id.leftBtn :
				
				break;
			case R.id.rightBtn :
				
				break;
		}
	}

	public void determineBtnShow(boolean left, boolean right){
		if(left == false){
			leftBtn.setVisibility(View.GONE);
		}else if(left == true){
			leftBtn.setVisibility(View.VISIBLE);
		}
		
		if(right == false){
			rightBtn.setVisibility(View.GONE);
		}else if(right == true){
			rightBtn.setVisibility(View.VISIBLE);
		}
	}
}
