package uk.co.reallysmall.cordova.plugin.firebase.crashlytics;

import android.util.Log;

import com.google.firebase.crashlytics.FirebaseCrashlytics;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

public class LogErrorHandler implements ActionHandler {
    @Override
    public boolean handle(final JSONArray args, CordovaInterface cordova, final CallbackContext callbackContext) {
        cordova.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                JavascriptException exception = null;

                try {
                    final String msg = args.getString(0);
                    final JSONArray stl = args.getJSONArray(1);
                    final StackTraceLine[] stackTraceLines = getStackTraceLines(stl);

                    exception = new JavascriptException(msg, stackTraceLines);
                }
                catch(JSONException e) {
                    Log.e(FirebaseCrashlyticsPlugin.TAG, "Unable to convert args to Exception object", e);
                }

                if(exception != null) {
                    FirebaseCrashlytics.getInstance().recordException(exception);
                }
            }
        });

        return true;
    }

    private StackTraceLine[] getStackTraceLines(JSONArray array) throws JSONException {
        final int length = array.length();

        StackTraceLine[] stackTraceLines = new StackTraceLine[length];
        for(int i = 0; i < length; i ++) {
            JSONObject json = array.getJSONObject(i);
            stackTraceLines[i] = StackTraceLine.fromJSONObject(json);
        }

        return stackTraceLines;
    }

    private static class JavascriptException extends Exception {
        public JavascriptException(String message, StackTraceLine[] stackTraceLines) {
            super(message);
            StackTraceElement[] stackTrace = new StackTraceElement[stackTraceLines.length];
            for(int i = 0; i < stackTraceLines.length; i++) {
                stackTrace[i] = new StackTraceElement(
                    stackTraceLines[i].className,
                    stackTraceLines[i].functionName,
                    stackTraceLines[i].fileName,
                    stackTraceLines[i].lineNumber
                );
            }

            setStackTrace(stackTrace);
        }
    }

    private static class StackTraceLine {
        public String className;
        public String functionName;
        public String fileName;
        public int lineNumber;

        private StackTraceLine() {
        }

        public static StackTraceLine fromJSONObject(JSONObject json) throws JSONException {
            StackTraceLine sl = new StackTraceLine();

            sl.className = json.optString("className", "<<undefined>>");
            sl.functionName = json.optString("functionName", "<<undefined>>");
            sl.fileName = json.getString("fileName");
            sl.lineNumber = json.getInt("lineNumber");

            return sl;
        }
    }
}