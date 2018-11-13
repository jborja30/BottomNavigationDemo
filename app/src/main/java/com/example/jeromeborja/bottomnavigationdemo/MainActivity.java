package com.example.jeromeborja.bottomnavigationdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

/*
Bottom navigation
Bottom navigation bars allow movement between primary destinations in an app
 */
public class MainActivity extends AppCompatActivity
implements BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        //sets the home fragment as the default fragment
        loadFragment(new HomeFragment());
    }

    //method for loading fragments
    public boolean loadFragment(Fragment fragment){
        if(fragment != null)
        {
            //Interaction with fragments is done through FragmentManager, which can be obtained
            // via Fragment.getFragmentManager().
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            return true;
        }
        //if there is no fragment return false.
            return false;
    }

    //override method that handles the action of when an item is clicked
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Fragment fragment = null;

        //Determines which item is selected
        switch (menuItem.getItemId()){
            case R.id.navigation_home:
                fragment = new HomeFragment();
                break;
            case R.id.navigation_dashboard:
                fragment = new DashboardFragment();
                break;
            case R.id.navigation_notifications:
                fragment = new NotificationsFragment();
                break;
        }

        //return the fragment that has been selected
        return loadFragment(fragment);
    }
}
