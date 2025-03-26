package com.capacitor.capacitorcustomandroidnotification;

import android.util.Log;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.getcapacitor.JSObject;
import android.content.Context;
import android.os.Build;
import android.app.NotificationManager;

public class AndroidNotification {
    private Context context;

    public AndroidNotification(Context context) {
        this.context = context;
    }
        // Check Notification Permission
    public JSObject checkNotificationPermission() {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        JSObject result = new JSObject();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            result.put("status", "not_applicable"); // No permission required on Android 13+
        } else {
            boolean granted = notificationManager.areNotificationsEnabled();
            result.put("status", granted ? "granted" : "denied");
        }

        Log.d("AndroidNotification", "Notification permission: " + result.getString("status"));
        return result;
    }
}
