package mgi.ivan_sison.ifswitch;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;

public class Switch {

    public void frameLayout() {

    }

    private static final String TAG = "Switch";

    private static Switch instance;
    private static SwitchMethod switchMethod;

    private static Context mContext;
    private static int mFrame;
    private static FragmentManager mFragmentManager;
    private static Bundle mBundle;

    public static Switch with(Context context) {
        if (instance == null) {
            setRefClass(context);
        }
        return instance;
    }

    public Switch passData(Bundle bundle) {
        mBundle = bundle;

        return this;
    }

    public Switch setFrameLayout(int frameLayout) {
        mFrame = frameLayout;

        return this;
    }

    public Switch from(FragmentManager fragmentManager) {
        mFragmentManager = fragmentManager;

        return this;
    }

    private static void setRefClass(Context context) {
        mContext = context;
        instance = new Switch();
        switchMethod = new SwitchMethod(context, getFragmentActivity().getSupportFragmentManager());
    }

    private static FragmentActivity getFragmentActivity() {
        return (FragmentActivity) mContext;
    }

    public String getTag() {
        return TAG;
    }

    public void addIntent(String tag, Intent intent) {
        switchMethod.addIntent(tag, intent);
    }

    public void addFragment(String tag, Fragment fragment) {
        switchMethod.addFragment(tag, fragment);
    }

    public void removeIntent(String tag) {
        switchMethod.removeIntent(tag);
    }

    public void removeFragment(String tag) {
        switchMethod.removeFragment(tag);
    }

    public void clearIntent() {
        switchMethod.clearIntent();
    }

    public void clearFragment() {
        switchMethod.clearFragment();
    }

    public String getIntents() {
        return switchMethod.getIntents();
    }

    public String getFragments() {
        return switchMethod.getFragments();
    }

    /*public void showIntent(String tag) {
        if (mBundle != null) {
            switchMethod.setBundle(mBundle);
        }

        switchMethod.showActivity(tag);
    }


    public void showFragment(String tag) {
        if (mBundle != null) {
            switchMethod.setBundle(mBundle);
        }

        switchMethod.setFrame(mFrame, mFragmentManager);
        switchMethod.showFragment(tag);
    }*/

    public void to(String tag) {
        if (mBundle != null) {
            switchMethod.setBundle(mBundle);
        }

        if (switchMethod.hasFragData(tag) && switchMethod.hasIntentData(tag)) {
            Log.e(Switch.with(mContext).getTag(), "Invalid tag: " + tag + " has found both in intent and fragment");
        }
        else if (switchMethod.hasFragData(tag)) {
            switchMethod.setFrame(mFrame, mFragmentManager);
            switchMethod.showFragment(tag);
        }
        else if (switchMethod.hasIntentData(tag)) {
            switchMethod.showActivity(tag);
        }
    }
}
