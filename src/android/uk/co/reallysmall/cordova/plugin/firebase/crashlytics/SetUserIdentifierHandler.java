package uk.co.reallysmall.cordova.plugin.firebase.crashlytics;

import android.util.Log;

import com.google.firebase.crashlytics.FirebaseCrashlytics;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;
import org.json.JSONException;

public class SetUserIdentifierHandler implements ActionHandler {
    @Override
    public boolean handle(JSONArray args, CordovaInterface cordova, final CallbackContext callbackContext) {
        try {
            final String identifier = args.getString(0);

            FirebaseCrashlytics.getInstance().setUserId(identifier);
        } catch (JSONException e) {
            Log.e(FirebaseCrashlyticsPlugin.TAG, "Error setting user identifier", e);
        }
        return true;
    }
}
