package uk.co.reallysmall.cordova.plugin.firebase.crashlytics;

import android.util.Log;

import com.crashlytics.android.Crashlytics;

import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;
import org.json.JSONException;

public class SetUserIdentifierHandler implements ActionHandler {
    @Override
    public boolean handle(JSONArray args, CordovaInterface cordova) {
        try {
            final String identifier = args.getString(0);

            Crashlytics.setUserIdentifier(identifier);
        } catch (JSONException e) {
            Log.e(FirebaseCrashlyticsPlugin.TAG, "Error setting user identifier", e);
        }
        return true;
    }
}
