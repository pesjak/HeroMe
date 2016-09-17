package com.applications.primoz.herome.Activites;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.applications.primoz.herome.Fragments.BackstoryFragment;
import com.applications.primoz.herome.Fragments.MainFragment;
import com.applications.primoz.herome.Fragments.PickPowerFragment;
import com.applications.primoz.herome.R;

public class MainActivity extends AppCompatActivity implements MainFragment.MainFragmentInteractionListener, PickPowerFragment.PickPowerInteractionListerner, BackstoryFragment.BackStoryInteractionListener {

    public static String POWER_HOW = "";
    public static String POWER_PICKED = "";
    public static String POWER_ACTUAL = "";
    public static String POWER_SECONDARY = "";
    public static String HERO_NAME = "";
    public static int POWER_SRC_IMG = 0;
    public static int POWER_SRC_SECONDARY_IMG = 0;
    public static int HERO_IMG = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment = new MainFragment();
            manager.beginTransaction().add(R.id.fragment_container, fragment).commit();

        }


    }


    public void loadPickPowerScreen() {
        PickPowerFragment pickPowerFragment = new PickPowerFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, pickPowerFragment).addToBackStack(null).commit();
    }

    public void loadMain() {
        MainFragment mainFragment = new MainFragment();
        getSupportFragmentManager().popBackStack();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, mainFragment).commit();
    }

    public void loadBackstory() {
        BackstoryFragment backstoryFragment = new BackstoryFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, backstoryFragment).addToBackStack(null).commit();


    }


    @Override
    public void onMainFragmentInteraction(Uri uri) {

    }

    @Override
    public void onFragmentInteraction(String primaryPower) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
