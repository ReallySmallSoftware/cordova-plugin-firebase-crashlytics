package uk.co.reallysmall.cordova.plugin.firebase.crashlytics;

import android.util.Log;

import com.google.firebase.crashlytics.FirebaseCrashlytics;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;
import org.json.JSONException;

public class LogExceptionHandler implements ActionHandler {
    @Override
    public boolean handle(final JSONArray args, CordovaInterface cordova, final CallbackContext callbackContext) {
        cordova.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    final String msg = args.getString(0);

                    Exception exception = new Exception(msg);

                    FirebaseCrashlytics.getInstance().recordException(exception);
                } catch (JSONException e) {
                    Log.e(FirebaseCrashlyticsPlugin.TAG, "Error logging exception", e);
                }
            }
        });

        return true;
    }
}
