package uk.co.reallysmall.cordova.plugin.firebase.crashlytics;

import android.util.Log;

import com.crashlytics.android.Crashlytics;

import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;
import org.json.JSONException;

public class LogPriorityHandler implements ActionHandler {
    @Override
    public boolean handle(final JSONArray args, CordovaInterface cordova) {
        cordova.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    final Integer priority = args.getInt(0);
                    final String tag = args.getString(1);
                    final String msg = args.getString(2);

                    Crashlytics.log(priority, tag, msg);
                } catch (JSONException e) {
                    Log.e(FirebaseCrashlyticsPlugin.TAG, "Error logging with priority", e);
                }
            }
        });

        return true;
    }
}
