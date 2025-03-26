package com.capacitor.capacitorcustomandroidnotification;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.getcapacitor.Bridge;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.os.Build;
import android.util.Log;

@CapacitorPlugin(name = "AndroidNotification")
public class AndroidNotificationPlugin extends Plugin {

    private AndroidNotification implementation;
    private static Bridge staticBridge;

    @Override
    public void load() {
        super.load();
        
        staticBridge = this.getBridge(); // Store the Bridge instance
        implementation = new AndroidNotification(getContext());
        
    }

    public static Bridge getStaticBridge() {
        return staticBridge;
    }
    @PluginMethod
    public void checkNotificationPermission(PluginCall call) {
        JSObject result = implementation.checkNotificationPermission();
        call.resolve(result);
    }
    public void triggerCustomEvent(String message) {
        JSObject eventData = new JSObject();
        eventData.put("message", message);
    
        notifyListeners("inAppNotificationTriggered", eventData);
        Log.d("NotificationPluginPlugin", "Custom event triggered: " + message);
    }
}
