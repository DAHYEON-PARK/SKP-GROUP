package com.example.recipe;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

public class OrderActivity extends ActionBarActivity {

	ImageButton button_order;
	ImageButton button_back;
	ImageButton button_add_other;
	CustomDialog customDialog;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.order_page);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		ActionBar bar = getSupportActionBar();
        bar.hide();

        button_order = (ImageButton) findViewById(R.id.order_button_order);
		button_back = (ImageButton) findViewById(R.id.order_button_back);
		button_add_other = (ImageButton)findViewById(R.id.order_button_add_other);
		
		
		button_order.setOnClickListener(onclickListener);
		button_back.setOnClickListener(onclickListener);
		button_add_other.setOnClickListener(onclickListener);
	}
	OnClickListener onclickListener = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub

			switch (v.getId()) {
			case R.id.order_button_back:
				Toast.makeText(getApplicationContext(), "뒤로 가기 구현하기 귀찮아...",Toast.LENGTH_SHORT).show();
				break;
			case R.id.order_button_add_other:
				Toast.makeText(getApplicationContext(), "추가재료 등록하기 귀찮아...",Toast.LENGTH_SHORT).show();
				break;
			case R.id.order_button_order:
				customDialog = new CustomDialog(OrderActivity.this,"order");
				customDialog.show();
				break;
			default:
				break;
			}
		}
	};
}
