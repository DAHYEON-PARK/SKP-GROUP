package com.example.recipe;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

public class MainActivity extends ActionBarActivity {
	
	ActionBarDrawerToggle dtToggle;
	FirstPage firstPage;
	DrawerLayout dlDrawer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_page);
		
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().hide(); 
		
		firstPage =  new FirstPage().newInstance();
		getSupportFragmentManager().beginTransaction().replace(R.id.fl_activity_main, firstPage).commit();
		
		dlDrawer = (DrawerLayout) findViewById(R.id.dl_activity_main);
		dtToggle = new ActionBarDrawerToggle(this, dlDrawer, R.drawable.ic_drawer,0, 0);
	}
	
	@Override
	protected void onPostResume() {
		// TODO Auto-generated method stub
		super.onPostResume();
	}

	
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		dtToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		dtToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (dtToggle.onOptionsItemSelected(item)) {
			return true;
		}
		return super.onOptionsItemSelected(item);
		
	}
	
	public void drawerA(View view) {
		dlDrawer.openDrawer(Gravity.RIGHT);
	}
	
	public void drawerclick(View view) {
		dlDrawer.closeDrawer(Gravity.RIGHT);
		
		Intent intent = new Intent(this, SpecialActivity.class);
		startActivity(intent);
	}
	
	public void write(View view) {
		Intent intent = new Intent(this, UploadActivity.class);
		startActivity(intent);
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			AlertDialog.Builder alertDlg = new AlertDialog.Builder(this);

			alertDlg.setMessage("종료 하시겠습니까?");
			alertDlg.setPositiveButton("예",
					new DialogInterface.OnClickListener() { // 확인 버튼
						@Override
						public void onClick(DialogInterface dialog,	int whichButton) {
							System.exit(0); // 시스템 종료
						}
					});
			alertDlg.setNegativeButton("아니오",
					new DialogInterface.OnClickListener() { // 취소 버튼
						@Override
						public void onClick(DialogInterface dialog,	int whichButton) {
							dialog.cancel();
						}
					});
			AlertDialog alert = alertDlg.create();
			alert.show();
		}
		return false;
	}

}
