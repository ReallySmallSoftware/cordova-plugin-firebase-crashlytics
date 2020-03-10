/**
 */
package uk.co.reallysmall.cordova.plugin.firebase.crashlytics;

import android.util.Log;

import com.crashlytics.android.Crashlytics;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

import io.fabric.sdk.android.Fabric;

public class FirebaseCrashlyticsPlugin extends CordovaPlugin {
    static final String TAG = "FBCrashlyticsPlugin";
    private Map<String, ActionHandler> handlers = new HashMap<String, ActionHandler>();

    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);

        handlers.put("crash", new CrashHandler());
        handlers.put("logPriority", new LogPriorityHandler());
        handlers.put("log", new LogHandler());
        handlers.put("setString", new SetStringHandler());
        handlers.put("setBool", new SetBoolHandler());
        handlers.put("setDouble", new SetDoubleHandler());
        handlers.put("setFloat", new SetFloatHandler());
        handlers.put("setInt", new SetIntHandler());
        handlers.put("logException", new LogExceptionHandler());
        handlers.put("logError", new LogErrorHandler());
        handlers.put("setUserIdentifier", new SetUserIdentifierHandler());

        Log.d(TAG, "Initializing FBCrashlyticsPlugin");

        Fabric.with(cordova.getActivity(), new Crashlytics());
    }

    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
        Log.d(TAG, action);

        if (handlers.containsKey(action)) {
            return handlers.get(action).handle(args, this.cordova);
        }

        return false;
    }
}
