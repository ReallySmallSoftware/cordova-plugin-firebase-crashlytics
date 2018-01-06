package uk.co.reallysmall.cordova.plugin.firebase.crashlytics;

import android.util.Log;

import com.crashlytics.android.Crashlytics;

import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;
import org.json.JSONException;

public class SetBoolHandler implements ActionHandler {
    @Override
    public boolean handle(JSONArray args, CordovaInterface cordova) {
        try {
            final String key = args.getString(0);
            final Boolean value = args.getBoolean(1);

            Crashlytics.setBool(key, value);
        } catch (JSONException e) {
            Log.e(FirebaseCrashlyticsPlugin.TAG, "Error setting bool", e);
        }
        return true;
    }
}
