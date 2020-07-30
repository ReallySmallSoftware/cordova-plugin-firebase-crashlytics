package uk.co.reallysmall.cordova.plugin.firebase.crashlytics;

import com.google.firebase.crashlytics.FirebaseCrashlytics;

import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;

public class CrashHandler implements ActionHandler {
    @Override
    public boolean handle(JSONArray args, CordovaInterface cordova) {

        cordova.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException();
            }
        });

        return true;
    }
}
