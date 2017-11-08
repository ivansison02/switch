package mgi.ivan_sison.ifswitch;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

public class SwitchMethod {

    private Context context;
    private Bundle bundle;

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private int frame;

    private SwitchIntentAdapter switchIntentAdapter;
    private SwitchFragAdapter switchFragAdapter;

    public SwitchMethod(Context context, FragmentManager fragmentManager) {
        this.context = context;
        this.fragmentManager = fragmentManager;

        getRefClass();

    }

    public void initTransact() {
        fragmentTransaction = fragmentManager.beginTransaction();
    }

    public void getRefClass() {
        switchIntentAdapter = new SwitchIntentAdapter(context);
        switchFragAdapter = new SwitchFragAdapter(context);
    }

    public Bundle getBundle() {
        return bundle;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }

    public void setFrame(int frame, FragmentManager fragmentManager) {
        this.frame = frame;
        this.fragmentManager = fragmentManager;
    }

    public void addIntent(String tag, Intent intent) {
        switchIntentAdapter.addData(tag, intent);
    }

    public void addFragment(String tag, Fragment fragment) {
        switchFragAdapter.addData(tag, fragment);
    }

    public void removeIntent(String tag) {
        switchIntentAdapter.removeData(tag);
    }

    public void removeFragment(String tag) {
        switchFragAdapter.removeData(tag);
    }

    public void clearIntent() {
        switchIntentAdapter.clearData();
    }

    public void clearFragment() {
        switchFragAdapter.clearData();
    }

    public String getIntents() {
        return switchIntentAdapter.getIntents();
    }

    public String getFragments() {
        return switchFragAdapter.getFragments();
    }

    public boolean hasIntentData(String tag) {
        return switchIntentAdapter.hasData(tag);
    }

    public boolean hasFragData(String tag) {
        return switchFragAdapter.hasData(tag);
    }

    public void showActivity(String tag) {

        if (hasIntentData(tag)) {
            if (bundle != null) {
                Log.i(Switch.with(context).getTag(), "Passing some data to " + switchIntentAdapter.getIntent(tag) +  ". ID: " + bundle.getString("id"));
                context.startActivity(switchIntentAdapter.getIntent(tag).putExtras(getBundle()));
            }
            else {
                Log.i(Switch.with(context).getTag(), "No data pass to " + switchIntentAdapter.getIntent(tag));
                context.startActivity(switchIntentAdapter.getIntent(tag));
            }
        }
        else {
            Log.e(Switch.with(context).getTag(), "Invalid tag");
        }
    }

    public void showFragment(String tag) {
        try {
            if (hasFragData(tag)) {
                initTransact();

                Fragment fragment = switchFragAdapter.getFragment(tag);

                fragmentTransaction.replace(frame, fragment);

                if (bundle != null) {
                    fragment.setArguments(getBundle());
                }

                fragmentTransaction.commit();
            }
            else {
                Log.e(Switch.with(context).getTag(), "Invalid tag");
            }
        }
        catch (Exception e) {
            if (e.toString().contains("non-zero container")) {
                Log.e(Switch.with(context).getTag(), "There is no frame." + "\nERROR: " + e.toString());
            }
            else if (e.toString().contains("android.support.v4.app.FragmentTransaction")) {
                Log.e(Switch.with(context).getTag(), "There is no fragment manager");
            }

            Log.e(Switch.with(context).getTag(),  e.toString());
        }
    }
}
