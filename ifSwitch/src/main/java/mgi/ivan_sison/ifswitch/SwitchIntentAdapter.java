package mgi.ivan_sison.ifswitch;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.ArrayList;

public class SwitchIntentAdapter {

    Context context;

    private ArrayList<SwitchIntentData> data;

    public SwitchIntentAdapter(Context context) {
        this.context = context;

        data = new ArrayList<>();
    }

    public void addData(String tag, Intent intent) {
        data.add(new SwitchIntentData(tag, intent));
    }

    public void removeData(String tag) {
        int index = getItemIndex(tag);
        data.remove(index);
    }

    public void clearData() {
        data.clear();
    }

    public Intent getIntent(String tag) {
        int index = getItemIndex(tag);
        return data.get(index).getIntent();
    }

    public String getIntents() {
        return data.toString();
    }

    public int getItemIndex(String tag) {
        int index = 0;

        for (int i = 0; i < data.size(); i++) {
            if (tag.equals(data.get(i).getTag())) {
                index = i;
            }
        }

        return index;
    }

    public boolean hasData(String tag) {
        boolean has = false;

        for (int i = 0; i < data.size(); i++) {
            if (tag.equals(data.get(i).getTag())) {
                has = true;
            }
        }

        return has;
    }
}
