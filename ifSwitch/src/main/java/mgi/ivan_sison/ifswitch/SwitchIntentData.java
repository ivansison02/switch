package mgi.ivan_sison.ifswitch;

import android.content.Intent;
import android.support.v4.app.Fragment;

public class SwitchIntentData {

    String tag;
    Intent intent;

    public SwitchIntentData(String tag, Intent intent) {
        this.tag = tag;
        this.intent = intent;
    }

    public String getTag() {
        return tag;
    }

    public Intent getIntent() {
        return intent;
    }
}
