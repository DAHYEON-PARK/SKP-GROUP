package com.example.recipe;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class OrderActivity extends ActionBarActivity {

	Button payButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.order_page);
		
		ActionBar bar = getSupportActionBar();
        bar.hide();

//		payButton = (Button) findViewById(R.id.payButton);
//
//		payButton.setOnClickListener(onclickListener);

	}

//	OnClickListener onclickListener = new View.OnClickListener() {
//
//		@Override
//		public void onClick(View v) {
//			// TODO Auto-generated method stub
//
//			switch (v.getId()) {
//
//			case R.id.payButton:
//				AlertDialog.Builder builder = new AlertDialog.Builder(
//						PayActivity.this);
//				builder.setTitle("결제 창")
//						.setMessage("결제를 진행하시겠습니까?")
//						.setCancelable(false)
//						.setPositiveButton("확인",
//								new DialogInterface.OnClickListener() {
//
//									@Override
//									public void onClick(DialogInterface dialog,
//											int which) {
//										// TODO Auto-generated method stub
//										
//										Toast.makeText(getApplicationContext(), "결제가 완료되었습니다.",Toast.LENGTH_SHORT).show();
//									}
//								})
//						.setNegativeButton("취소",
//								new DialogInterface.OnClickListener() {
//
//									@Override
//									public void onClick(DialogInterface dialog,
//											int which) {
//										// TODO Auto-generated method stub
//										Toast.makeText(getApplicationContext(), "결제가 취소되었습니다.",Toast.LENGTH_SHORT).show();
//									}
//								});
//
//				AlertDialog dialog = builder.create();
//				dialog.show();
//
//				break;
//			default:
//				break;
//			}
//		}
//	};
}
