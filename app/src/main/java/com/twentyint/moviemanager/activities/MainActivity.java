package com.twentyint.moviemanager.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.twentyint.moviemanager.R;
import com.twentyint.moviemanager.fragments.NowPlayingFragment;
import com.twentyint.moviemanager.fragments.UpcomingFragment;

public class  MainActivity extends AppCompatActivity{
	
	private AppBarConfiguration mAppBarConfiguration;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toolbar toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		
		DrawerLayout drawer = findViewById(R.id.drawer_layout);
		NavigationView navigationView = findViewById(R.id.nav_view);
		
		// Passing each menu ID as a set of Ids because each
		// menu should be considered as top level destinations.
		mAppBarConfiguration = new AppBarConfiguration.Builder(
				R.id.nav_now_playing, R.id.nav_upcoming)
				.setDrawerLayout(drawer)
				.build();
		
		NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
		NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
		NavigationUI.setupWithNavController(navigationView, navController);
		
		showFragment(NowPlayingFragment.class);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onSupportNavigateUp() {
		NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
		return NavigationUI.navigateUp(navController, mAppBarConfiguration)
				|| super.onSupportNavigateUp();
	}
	
	private void showFragment(Class fragmentClass) {
		Fragment fragment;
		try {
			fragment = (Fragment) fragmentClass.newInstance();
			FragmentManager fragmentManager = getSupportFragmentManager();
			fragmentManager.beginTransaction()
					.replace(R.id.flContent, fragment)
					.commit();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
	}
}
