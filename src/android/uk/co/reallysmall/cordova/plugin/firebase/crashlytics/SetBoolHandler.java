package uk.co.reallysmall.cordova.plugin.firebase.crashlytics;

import android.util.Log;

import com.google.firebase.crashlytics.FirebaseCrashlytics;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;
import org.json.JSONException;

public class SetBoolHandler implements ActionHandler {
    @Override
    public boolean handle(JSONArray args, CordovaInterface cordova, final CallbackContext callbackContext) {
        try {
            final String key = args.getString(0);
            final Boolean value = args.getBoolean(1);

            FirebaseCrashlytics.getInstance().setCustomKey(key, value);
        } catch (JSONException e) {
            Log.e(FirebaseCrashlyticsPlugin.TAG, "Error setting bool", e);
        }
        return true;
    }
}
