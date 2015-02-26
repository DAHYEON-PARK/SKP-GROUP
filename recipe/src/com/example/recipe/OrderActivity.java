package com.example.recipe;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends ActionBarActivity {

	ImageButton button_order;
	ImageButton button_back;
	ImageButton button_add_other;

	ImageButton button_bacon_minus;
	ImageButton button_bacon_plus;
	ImageButton button_egg_minus;
	ImageButton button_egg_plus;
	ImageButton button_pudding_minus;
	ImageButton button_pudding_plus;
	ImageButton button_vegetable_minus;
	ImageButton button_vegetable_plus;

	EditText text_ingredient_bacon_count;
	EditText text_ingredient_egg_count;
	EditText text_ingredient_pudding_count;
	EditText text_ingredient_vegetable_count;

	TextView order_text_price;
	
	CustomDialog customDialog;

	private static final int INGREDIENT_PRICE_BACON 	= 3000;
	private static final int INGREDIENT_PRICE_EGG 		= 500;
	private static final int INGREDIENT_PRICE_PUDDING 	= 500;
	private static final int INGREDIENT_PRICE_VEGETABLE = 1000;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.order_page);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		ActionBar bar = getSupportActionBar();
		bar.hide();

		initLayout();

		setListener();

	}

	private void setListener() {
		// TODO Auto-generated method stub

		button_order.setOnClickListener(onclickListener);
		button_back.setOnClickListener(onclickListener);
		button_add_other.setOnClickListener(onclickListener);

		button_bacon_minus.setOnClickListener(ingredientOnclickListener);
		button_bacon_plus.setOnClickListener(ingredientOnclickListener);
		button_egg_minus.setOnClickListener(ingredientOnclickListener);
		button_egg_plus.setOnClickListener(ingredientOnclickListener);
		button_pudding_minus.setOnClickListener(ingredientOnclickListener);
		button_pudding_plus.setOnClickListener(ingredientOnclickListener);
		button_vegetable_minus.setOnClickListener(ingredientOnclickListener);
		button_vegetable_plus.setOnClickListener(ingredientOnclickListener);
		text_ingredient_bacon_count.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,int count) {
				// TODO Auto-generated method stub
				makePrice();
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
			@Override
			public void afterTextChanged(Editable s) {}
		});
		text_ingredient_egg_count.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				makePrice();
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
			@Override
			public void afterTextChanged(Editable s) {}
		});
		text_ingredient_pudding_count.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				makePrice();
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
			@Override
			public void afterTextChanged(Editable s) {}
		});
		text_ingredient_vegetable_count.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub
				makePrice();
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
			@Override
			public void afterTextChanged(Editable s) {}
		});
	}

	private void initLayout() {
		// TODO Auto-generated method stub
		button_order = (ImageButton) findViewById(R.id.order_button_order);
		button_back = (ImageButton) findViewById(R.id.order_button_back);
		button_add_other = (ImageButton) findViewById(R.id.order_button_add_other);

		button_bacon_minus = (ImageButton) findViewById(R.id.order_ingredient_bacon_minus);
		button_bacon_plus = (ImageButton) findViewById(R.id.order_ingredient_bacon_plus);
		button_egg_minus = (ImageButton) findViewById(R.id.order_ingredient_egg_minus);
		button_egg_plus = (ImageButton) findViewById(R.id.order_ingredient_egg_plus);
		button_pudding_minus = (ImageButton) findViewById(R.id.order_ingredient_pudding_minus);
		button_pudding_plus = (ImageButton) findViewById(R.id.order_ingredient_pudding_plus);
		button_vegetable_minus = (ImageButton) findViewById(R.id.order_ingredient_vegetable_minus);
		button_vegetable_plus = (ImageButton) findViewById(R.id.order_ingredient_vegetable_plus);

		text_ingredient_bacon_count = (EditText) findViewById(R.id.order_ingredient_bacon_edittext);
		text_ingredient_bacon_count.setText("1");

		text_ingredient_egg_count = (EditText) findViewById(R.id.order_ingredient_egg_edittext);
		text_ingredient_egg_count.setText("1");

		text_ingredient_pudding_count = (EditText) findViewById(R.id.order_ingredient_pudding_edittext);
		text_ingredient_pudding_count.setText("1");

		text_ingredient_vegetable_count = (EditText) findViewById(R.id.order_ingredient_vegetable_edittext);
		text_ingredient_vegetable_count.setText("1");
		
		order_text_price = (TextView)findViewById(R.id.order_text_price);
		makePrice();

	}

	OnClickListener onclickListener = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub

			switch (v.getId()) {
			case R.id.order_button_back:
				
				OrderActivity.this.onBackPressed();
				break;
			case R.id.order_button_add_other:
				Toast.makeText(getApplicationContext(), "추가재료 등록하기 귀찮아...",
						Toast.LENGTH_SHORT).show();
				break;
			case R.id.order_button_order:
				customDialog = new CustomDialog(OrderActivity.this, "order");
				customDialog.show();
				break;
			default:
				break;
			}
		}
	};

	OnClickListener ingredientOnclickListener = new View.OnClickListener() {

		Integer value;
		String str;

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub

			switch (v.getId()) {
			case R.id.order_ingredient_bacon_minus:
				if(text_ingredient_bacon_count.getText().toString().length()==0){
					text_ingredient_bacon_count.setText("1");
					break;
				}
				
				value = Integer.parseInt(text_ingredient_bacon_count.getText()
						.toString());

				if (!value.equals(1))
					value--;

				str = value.toString();
				text_ingredient_bacon_count.setText(str);
				break;
			case R.id.order_ingredient_bacon_plus:
				if(text_ingredient_bacon_count.getText().toString().length()==0){
					text_ingredient_bacon_count.setText("1");
					break;
				}
				
				value = Integer.parseInt(text_ingredient_bacon_count.getText()
						.toString());

				if (!value.equals(99))
					value++;

				str = value.toString();
				text_ingredient_bacon_count.setText(str);
				break;
			case R.id.order_ingredient_egg_minus:
				if(text_ingredient_egg_count.getText().toString().length()==0){
					text_ingredient_egg_count.setText("1");
					break;
				}
				
				value = Integer.parseInt(text_ingredient_egg_count.getText()
						.toString());

				if (!value.equals(1))
					value--;

				str = value.toString();
				text_ingredient_egg_count.setText(str);
				break;
			case R.id.order_ingredient_egg_plus:
				if(text_ingredient_egg_count.getText().toString().length()==0){
					text_ingredient_egg_count.setText("1");
					break;
				}
				
				value = Integer.parseInt(text_ingredient_egg_count.getText()
						.toString());

				if (!value.equals(99))
					value++;

				str = value.toString();
				text_ingredient_egg_count.setText(str);
				break;
			case R.id.order_ingredient_pudding_minus:
				if(text_ingredient_pudding_count.getText().toString().length()==0){
					text_ingredient_pudding_count.setText("1");
					break;
				}
				
				value = Integer.parseInt(text_ingredient_pudding_count.getText()
						.toString());

				if (!value.equals(1))
					value--;

				str = value.toString();
				text_ingredient_pudding_count.setText(str);
				break;
			case R.id.order_ingredient_pudding_plus:
				if(text_ingredient_pudding_count.getText().toString().length()==0){
					text_ingredient_pudding_count.setText("1");
					break;
				}
					
				value = Integer.parseInt(text_ingredient_pudding_count.getText()
						.toString());

				if (!value.equals(99))
					value++;

				str = value.toString();
				text_ingredient_pudding_count.setText(str);
				break;
			case R.id.order_ingredient_vegetable_minus:
				if(text_ingredient_vegetable_count.getText().toString().length()==0){
					text_ingredient_vegetable_count.setText("1");
					break;
				}
				
				value = Integer.parseInt(text_ingredient_vegetable_count.getText()
						.toString());

				if (!value.equals(1))
					value--;

				str = value.toString();
				text_ingredient_vegetable_count.setText(str);
				break;
			case R.id.order_ingredient_vegetable_plus:
				if(text_ingredient_vegetable_count.getText().toString().length()==0){
					text_ingredient_vegetable_count.setText("1");
					break;
				}
				value = Integer.parseInt(text_ingredient_vegetable_count.getText()
						.toString());

				if (!value.equals(99))
					value++;

				str = value.toString();
				text_ingredient_vegetable_count.setText(str);
				break;
			default:
				break;
			}
		}
	};
	
	private void makePrice() {
		// TODO Auto-generated method stub
			if(text_ingredient_bacon_count.getText().toString().length()==0 
					|| text_ingredient_egg_count.getText().toString().length()==0
					|| text_ingredient_pudding_count.getText().toString().length()==0
					|| text_ingredient_vegetable_count.getText().toString().length()==0)
				return;
		
			int count_bacon		= Integer.parseInt(text_ingredient_bacon_count.getText().toString());
			int count_egg		= Integer.parseInt(text_ingredient_egg_count.getText().toString());
			int count_pudding	= Integer.parseInt(text_ingredient_pudding_count.getText().toString());
			int count_vegetable = Integer.parseInt(text_ingredient_vegetable_count.getText().toString());;

			Integer price 		= count_bacon*INGREDIENT_PRICE_BACON + count_egg*INGREDIENT_PRICE_EGG + count_pudding*INGREDIENT_PRICE_PUDDING + count_vegetable*INGREDIENT_PRICE_VEGETABLE;
			
			order_text_price.setText(price.toString());
			
	}
}
