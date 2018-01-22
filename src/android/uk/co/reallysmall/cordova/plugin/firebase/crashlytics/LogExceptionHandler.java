package uk.co.reallysmall.cordova.plugin.firebase.crashlytics;

import android.util.Log;

import com.crashlytics.android.Crashlytics;

import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;
import org.json.JSONException;

public class LogExceptionHandler implements ActionHandler {
    @Override
    public boolean handle(final JSONArray args, CordovaInterface cordova) {
        cordova.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    final String msg = args.getString(0);

                    Exception exception = new Exception(msg);

                    Crashlytics.logException(exception);
                } catch (JSONException e) {
                    Log.e(FirebaseCrashlyticsPlugin.TAG, "Error logging exception", e);
                }
            }
        });

        return true;
    }
}
