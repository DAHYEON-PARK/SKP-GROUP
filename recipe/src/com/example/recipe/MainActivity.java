package com.example.recipe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;

public class MainActivity extends ActionBarActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks {

	/**
	 * Fragment managing the behaviors, interactions and presentation of the
	 * navigation drawer.
	 */
	private NavigationDrawerFragment mNavigationDrawerFragment;

	/**
	 * Used to store the last screen title. For use in
	 * {@link #restoreActionBar()}.
	 */
	private CharSequence mTitle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//추가부분//
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ActionBar bar = getSupportActionBar();
        bar.hide();
		//////////
		
		setContentView(R.layout.activity_main);

		mNavigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
		//mTitle = getTitle();
		
		// Set up the drawer.
		//mNavigationDrawerFragment.setUp(R.id.navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout));
	}

	
	
	@Override
	public void onNavigationDrawerItemSelected(int position) {
		// update the main content by replacing fragments
		FragmentManager fragmentManager = getSupportFragmentManager();
		fragmentManager
		.beginTransaction()
		.replace(R.id.container,
				PlaceholderFragment.newInstance(position + 1)).commit();
	}

	public void onSectionAttached(int number) {
		switch (number) {
		case 1:
			mTitle = getString(R.string.category1);
			break;
		case 2:
			mTitle = getString(R.string.category2);
			break;
		case 3:
			mTitle = getString(R.string.category3);
			break;
		}
	}

	public void restoreActionBar() {
		ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle(mTitle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
//		if (!mNavigationDrawerFragment.isDrawerOpen()) {
//			// Only show items in the action bar relevant to this screen
//			// if the drawer is not showing. Otherwise, let the drawer
//			// decide what to show in the action bar.
//			getMenuInflater().inflate(R.menu.main, menu);
//			restoreActionBar();
//			return true;
//		}
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment implements OnClickListener { // , OnTouchListener{

		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		private static final String ARG_SECTION_NUMBER = "section_number";

		// 추가 부분//
		static int number;
		ImageButton secView, firView;
		////////////

		/**
		 * Returns a new instance of this fragment for the given section number.
		 */
		public static PlaceholderFragment newInstance(int sectionNumber) {

			PlaceholderFragment fragment = new PlaceholderFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);

			// 추가부분//
			number = sectionNumber;

			return fragment;
		}

		public PlaceholderFragment() {

		}
		
		@Override
		public void onResume() {
			// TODO Auto-generated method stub
			super.onResume();
			//secView.setImageDrawable(getResources().getDrawable(R.drawable.tv_category_listing_2_unselected));
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

			// 변경 부분//
			View rootView = inflater.inflate(R.layout.special_page, container, false);
			
			secView = (ImageButton) rootView.findViewById(R.id.secondView);
			secView.setOnClickListener(this);
			
			firView = (ImageButton) rootView.findViewById(R.id.firstView);
			firView.setOnClickListener(this);
			/////////////
			
			return rootView;

		}

		@Override
		public void onAttach(Activity activity) {
			super.onAttach(activity);
			((MainActivity) activity).onSectionAttached(getArguments().getInt(ARG_SECTION_NUMBER));
		}

		// press설정해서 selector도 안되고, xml에서 clickable=true로 해도 안됨 ㅠㅠ 
		// action down은 되는데 왜 action up는 안됨???? 그리고 clicklistenter를 추가하면 되는거임?? click이 빈 메서드니 필요 없지 않나??
//		@Override
//		public boolean onTouch(View v, MotionEvent event) {
//		
//			ImageView view = (ImageView)v;
//			
//			switch(event.getAction()){
//			case MotionEvent.ACTION_DOWN : 
//				//view.setPressed(true);
//				view.setImageDrawable(getResources().getDrawable(R.drawable.tv_category_listing_2_selected));
//				// 이케 했더니....long press하면 화면이 넘어가진 않지만 색이 바뀜....왜 action_up이 안되지?? ㅠ
//				break;
//			case MotionEvent.ACTION_UP : 
//				//view.setPressed(false);
//				view.setImageDrawable(getResources().getDrawable(R.drawable.tv_category_listing_2_unselected));
//				Intent intent = new Intent((MainActivity) getActivity(),RecipeActivity.class);
//				((MainActivity) getActivity()).startActivity(intent);
//				break;
//			}
//			
//			return false;
//		}

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			Intent intent = null;
			
			switch(v.getId()){
				case R.id.firstView : 
					intent = new Intent(getActivity(),UploadActivity.class);
					break;
				case R.id.secondView : 
					intent = new Intent(getActivity(),RecipeActivity.class);					
					break;
			}
			
			((MainActivity) getActivity()).startActivity(intent);
			
		}

	}
}
