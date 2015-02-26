package com.example.recipe;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;

public class CustomDialog extends Dialog{

	ImageView popup_dialog_title;
	ImageView popup_dialog_body;
	ImageButton popup_dialog_button_confirm;
	String activityName;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();    
		lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
		lpWindow.dimAmount = 0.5f;
		getWindow().setAttributes(lpWindow);
		
		if(activityName.equals("order"))
			setContentView(R.layout.popup_dialog_order);
		else if(activityName.equals("upload"))
			setContentView(R.layout.popup_dialog_register);

		setLayout();
		
		popup_dialog_button_confirm.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				cancel();
			}
		});
	}

	private void setLayout() {
		// TODO Auto-generated method stub
		popup_dialog_title = (ImageView)findViewById(R.id.popup_dialog_title);
		popup_dialog_body = (ImageView)findViewById(R.id.popup_dialog_body);
		popup_dialog_button_confirm = (ImageButton)findViewById(R.id.popup_dialog_button_confirm);
	}

	public CustomDialog(Context context,String activityName) {
		super(context , android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
		this.activityName=activityName;
		// TODO Auto-generated constructor stub
	}
}
