package com.example.android.jsonanimation;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import org.jetbrains.annotations.NotNull;

public class LoginAdapter extends FragmentPagerAdapter {

    // Creating Adapter Class to switch between Fragments
    private Context context;
    int totalTabs;

    public LoginAdapter(FragmentManager fm,Context context, int totalTabs) {
        super(fm);
        this.context = context;
        this.totalTabs = totalTabs;
    }

    @NonNull
    @NotNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                LoginTabFragment loginTabFragment = new LoginTabFragment();
                return  loginTabFragment;
            case 1:
                SignUpTabFragment signUpTabFragment = new SignUpTabFragment();
                return  signUpTabFragment;
            default:
                return  null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }

//    @Override
//    public CharSequence getPageTitle(int position) {
////        return super.getPageTitle(position);
//        // Declared mContext as global variable
//        if (position == 0) {
//            return "Login";
//        } else {
//            return "SignUp";
//        }
//    }
}
