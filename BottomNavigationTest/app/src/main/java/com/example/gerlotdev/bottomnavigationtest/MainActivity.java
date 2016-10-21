package com.example.gerlotdev.bottomnavigationtest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements OneFragment.OnFragmentInteractionListener,
		TwoFragment.OnFragmentInteractionListener, ThreeFragment.OnFragmentInteractionListener,
		FourFragment.OnFragmentInteractionListener {

	private Toolbar toolbar;
	private BottomNavigationView bottomNavigationView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
		fragmentTransaction.replace(R.id.frame_layout, OneFragment.newInstance());
		fragmentTransaction.commit();

		toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation_view);
		bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
			@Override
			public boolean onNavigationItemSelected(@NonNull MenuItem item) {
				Fragment fragment = null;
				switch (item.getItemId()) {
					case R.id.action_one:
						fragment = OneFragment.newInstance();
						break;
					case R.id.action_two:
						fragment = TwoFragment.newInstance();
						break;
					case R.id.action_three:
						fragment = ThreeFragment.newInstance();
						break;
					case R.id.action_four:
						fragment = FourFragment.newInstance();
						break;
				}
				if (fragment != null) {
					FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
					fragmentTransaction.replace(R.id.frame_layout, fragment);
					fragmentTransaction.commit();
				}
				return true;
			}
		});

	}

}
