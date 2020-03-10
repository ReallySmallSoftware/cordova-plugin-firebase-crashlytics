package uk.co.reallysmall.cordova.plugin.firebase.crashlytics;

import android.util.Log;

import com.crashlytics.android.Crashlytics;

import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LogErrorHandler implements ActionHandler {
    @Override
    public boolean handle(final JSONArray args, CordovaInterface cordova) {
        cordova.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    final String msg = args.getString(0);
                    final JSONArray stackFrames = args.getJSONArray(1);

                    Exception exception = new Exception(msg);
                    try {
                        exception.setStackTrace(convertStackFrames(stackFrames));
                    } catch (JSONException e) {
                        Crashlytics.logException(e);
                    }

                    Crashlytics.logException(exception);
                } catch (JSONException e) {
                    Log.e(FirebaseCrashlyticsPlugin.TAG, "Error logging exception", e);
                }
            }
        });

        return true;
    }

    private StackTraceElement[] convertStackFrames(JSONArray stackFrames) throws JSONException {
        StackTraceElement[] newStack = new StackTraceElement[stackFrames.length()];
        int count = stackFrames.length();
        for (int i = 0; i < count; i++) {
            if (stackFrames.isNull(i)) {
                continue;
            }

            JSONObject data = stackFrames.getJSONObject(i);
            String functionName = data.has("functionName") ? data.getString("functionName") : "";
            String fileName = data.has("fileName") ? data.getString("fileName") : "";
            int lineNumber = data.has("lineNumber") ? data.getInt("lineNumber") : 0;

            newStack[i] = new StackTraceElement(
                    "",
                    functionName,
                    fileName,
                    lineNumber
            );
        }
        return newStack;
    }
}
