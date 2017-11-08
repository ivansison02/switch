package mgi.ivan_sison.ifswitch;

import android.content.Intent;
import android.support.v4.app.Fragment;

public class SwitchFragData {

    String tag;
    Fragment fragment;

    public SwitchFragData(String tag, Fragment fragment) {
        this.tag = tag;
        this.fragment = fragment;
    }

    public String getTag() {
        return tag;
    }

    public Fragment getFragment() {
        return fragment;
    }
}
