package uk.co.reallysmall.cordova.plugin.firebase.crashlytics;

import com.crashlytics.android.Crashlytics;

import org.json.JSONArray;

public class CrashHandler implements ActionHandler {
    @Override
    public boolean handle(JSONArray args) {

        Crashlytics.getInstance().crash();

        return true;
    }
}
