package com.android.bibi.driver.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.android.bibi.driver.fragment.ConfirmPassengerPresence;
import com.android.bibi.driver.fragment.StartRoute;
import com.android.bibi.driver.fragment.ViewDestinys;
import com.android.bibi.driver.fragment.ViewPassengers;

/**
 * Created by jsalgado on 30/05/15.
 */
public class ViewDriverPagerAdapter extends FragmentStatePagerAdapter {

    CharSequence Titles[]; // This will Store the Titles of the Tabs which are Going to be passed when ViewPassangerPagerAdapter is created
    int NumbOfTabs; // Store the number of tabs, this will also be passed when the ViewPassangerPagerAdapter is created


    // Build a Constructor and assign the passed Values to appropriate values in the class
    public ViewDriverPagerAdapter(FragmentManager fm, CharSequence mTitles[], int mNumbOfTabsumb) {
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
                return new StartRoute();
            case 2 :
                return new ViewPassengers();
            case 3:
                return new ConfirmPassengerPresence();
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
