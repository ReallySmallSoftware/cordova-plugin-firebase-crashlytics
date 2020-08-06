package uk.co.reallysmall.cordova.plugin.firebase.crashlytics;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;

public interface ActionHandler {
    boolean handle(JSONArray args, CordovaInterface cordova, final CallbackContext callbackContext);
}
