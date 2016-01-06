package edu.oscail.cs.tdassignfour;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Fanglin Chen on 12/18/14.
 *
 */

public class ActionTabsViewPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragments;

    public static final int EVENT = 0;
    public static final int GALLERY = 1;
    public static final int MATCH = 2;
    public static final int SETTINGS = 3;
    public static final String UI_TAB_EVENT = "EVENT";
    public static final String UI_TAB_GALLERY = "GALLERY";
    public static final String UI_TAB_MATCH = "MATCH";
    public static final String UI_TAB_SETTINGS = "SETTINGS";

    public ActionTabsViewPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragments){
        super(fm);
        this.fragments = fragments;
    }

    public Fragment getItem(int pos){
        return fragments.get(pos);
    }

    public int getCount(){
        return fragments.size();
    }

    public CharSequence getPageTitle(int position) {
        switch (position) {
            case EVENT:
                return UI_TAB_EVENT;
            case GALLERY:
                return UI_TAB_GALLERY;
            case MATCH:
                return UI_TAB_MATCH;
            case SETTINGS:
                return UI_TAB_SETTINGS;
            default:
                break;
        }
        return null;
    }
}
