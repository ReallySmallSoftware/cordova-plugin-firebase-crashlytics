package uk.co.reallysmall.cordova.plugin.firebase.crashlytics;

import android.util.Log;

import com.crashlytics.android.Crashlytics;

import org.json.JSONArray;
import org.json.JSONException;

public class SetFloatHandler implements ActionHandler {
    @Override
    public boolean handle(JSONArray args) {
        try {
            final String key = args.getString(0);
            final Double value = args.getDouble(1);

            Crashlytics.setFloat(key, value.floatValue());
        } catch (JSONException e) {
            Log.e(FirebaseCrashlyticsPlugin.TAG, "Error setting float", e);
        }
        return true;
    }
}
