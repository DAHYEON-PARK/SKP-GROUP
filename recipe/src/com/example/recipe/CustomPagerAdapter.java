package com.example.recipe;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomPagerAdapter extends PagerAdapter{
	
	// List<ViewGroup> viewHolder = new ArrayList<ViewGroup>();  재활용??
	
	Context context;
	LinearLayout recipeDetail;
	ImageView img;
	ImageView recipeText;
	//TextView recipeText, ingredient;
	
	private final int pageNum = 3;
	
	public CustomPagerAdapter(Context context){
		this.context = context;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return pageNum;
	}
	
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		// TODO Auto-generated method stub
		
		recipeDetail = (LinearLayout) View.inflate(context, R.layout.recipe_detail_cell_page, null);
		img = (ImageView) recipeDetail.findViewById(R.id.foodImg);
		recipeText = (ImageView) recipeDetail.findViewById(R.id.recipeText);
		//recipeText = (TextView) recipeDetail.findViewById(R.id.recipeText);
		//ingredient = (TextView) recipeDetail.findViewById(R.id.ingredient);
		
		if(position==0){
			img.setImageDrawable(context.getResources().getDrawable(R.drawable.recipe_detail_img_1));
			recipeText.setImageDrawable(context.getResources().getDrawable(R.drawable.recipe_detail_text_1));
			
			container.addView(recipeDetail, position);
			return recipeDetail;
			
		}else if(position==1){
			img.setImageDrawable(context.getResources().getDrawable(R.drawable.recipe_detail_img_2));
			recipeText.setImageDrawable(context.getResources().getDrawable(R.drawable.recipe_detail_text_2));
			
			container.addView(recipeDetail, position);
			return recipeDetail;
			
		}else if(position==2){
			img.setImageDrawable(context.getResources().getDrawable(R.drawable.recipe_detail_img_3));
			recipeText.setImageDrawable(context.getResources().getDrawable(R.drawable.recipe_detail_text_3));
			
			container.addView(recipeDetail, position);
			return recipeDetail;
		}

		return null; //super.instantiateItem(container, position);
	}


	@Override
	public boolean isViewFromObject(View v, Object obj) {
		// TODO Auto-generated method stub
			
		return v==obj; //false;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// TODO Auto-generated method stub
		//super.destroyItem(container, position, object);
		container.removeView((View)object);
	}

}
