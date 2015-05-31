package com.android.bibi.passenger.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.android.bibi.passenger.fragment.ConfirmPresence;
import com.android.bibi.passenger.fragment.FollowRoute;
import com.android.bibi.passenger.fragment.ViewDestinys;
import com.android.bibi.passenger.fragment.DriverInfo;
import com.android.bibi.passenger.fragment.ViewPassengers;

/**
 * Created by jsalgado on 26/05/15.
 */
public class ViewPassangerPagerAdapter extends FragmentStatePagerAdapter {

    CharSequence Titles[]; // This will Store the Titles of the Tabs which are Going to be passed when ViewPassangerPagerAdapter is created
    int NumbOfTabs; // Store the number of tabs, this will also be passed when the ViewPassangerPagerAdapter is created


    // Build a Constructor and assign the passed Values to appropriate values in the class
    public ViewPassangerPagerAdapter(FragmentManager fm, CharSequence mTitles[], int mNumbOfTabsumb) {
        super(fm);

        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;

    }

    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new ViewDestinys();
            case 1:
                return new ViewPassengers();
            case 2:
                return new FollowRoute();
            case 3 :
                return new ConfirmPresence();
            case 4:
                return new DriverInfo();
            default:
                return new ViewDestinys();
        }

    }

    // This method return the titles for the Tabs in the Tab Strip

    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }

    // This method return the Number of tabs for the tabs Strip

    @Override
    public int getCount() {
        return NumbOfTabs;
    }
}