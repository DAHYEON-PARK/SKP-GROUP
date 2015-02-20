package com.example.recipe;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.webkit.WebView.FindListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                .commit();
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
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
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
    public static class PlaceholderFragment extends Fragment implements OnClickListener {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
        
        //추가 부분//        
        static int number;
        
        ImageView foodImg;
        TextView nickName;
        ImageView direction;
        
        TextView payment;
        //////////
        
        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            
            number = sectionNumber;
            
            return fragment;
        }

        public PlaceholderFragment() {
        	
        	payment.setOnClickListener(this);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        	
        	//변경 부분//
        	View rootView = inflater.inflate(R.layout.fragment_category, container, false);
        	foodImg = (ImageView) rootView.findViewById(R.id.foodImg);
        	nickName = (TextView) rootView.findViewById(R.id.nickName);
        	direction = (ImageView) rootView.findViewById(R.id.direction);
        	
        	if(number==1){
        		foodImg.setImageDrawable(getResources().getDrawable(R.drawable.recipe_detail_food_img1));
        		direction.setImageDrawable(getResources().getDrawable(R.drawable.recipe_detail_direction1));
        	}else if(number==2){
        		foodImg.setImageDrawable(getResources().getDrawable(R.drawable.recipe_detail_food_img2));
        		direction.setImageDrawable(getResources().getDrawable(R.drawable.recipe_detail_direction2));
        	}else if(number==3){
        		foodImg.setImageDrawable(getResources().getDrawable(R.drawable.recipe_detail_food_img3));
        		direction.setImageDrawable(getResources().getDrawable(R.drawable.recipe_detail_direction3));
        	}
        	
        	nickName.setText("page "+number);
        	///////////
        	
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			startActivity(intent);
		}
    }

}
