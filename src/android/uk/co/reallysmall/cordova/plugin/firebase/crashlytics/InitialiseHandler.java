package uk.co.reallysmall.cordova.plugin.firebase.crashlytics;

import com.google.firebase.crashlytics.FirebaseCrashlytics;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;
import org.apache.cordova.PluginResult;

public class InitialiseHandler implements ActionHandler {
    @Override
    public boolean handle(JSONArray args, CordovaInterface cordova, final CallbackContext callbackContext) {

        boolean result = false;

        if (FirebaseCrashlytics.getInstance().didCrashOnPreviousExecution()) {
            result = true;
        }

        callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, result));

        return true;
    }
}
