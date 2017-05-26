package com.SelvaBalajiOutlookCom.SelvaBalajiOutlookComS73X;

import android.app.Application;

import com.SelvaBalajiOutlookCom.SelvaBalajiOutlookComS73X.estimote.BeaconID;
import com.SelvaBalajiOutlookCom.SelvaBalajiOutlookComS73X.estimote.BeaconNotificationsManager;
import com.estimote.sdk.EstimoteSDK;

public class MyApplication extends Application {

    private boolean beaconNotificationsEnabled = false;

    @Override
    public void onCreate() {
        super.onCreate();

        EstimoteSDK.initialize(getApplicationContext(), "selva-balaji-outlook-com-s-73x", "26a2ed5dcbb28a4ec19a071a77d8cce9");

        // uncomment to enable debug-level logging
        // it's usually only a good idea when troubleshooting issues with the Estimote SDK
//        EstimoteSDK.enableDebugLogging(true);
    }

    public void enableBeaconNotifications() {
        if (beaconNotificationsEnabled) { return; }

        BeaconNotificationsManager beaconNotificationsManager = new BeaconNotificationsManager(this);
        beaconNotificationsManager.addNotification(
                new BeaconID("B9407F30-F5F8-466E-AFF9-25556B57FE6D", 45629, 24271),
                "Hello, Welcome to PushKart.",
                "Goodbye, See you Soon !.");
        beaconNotificationsManager.startMonitoring();

        beaconNotificationsEnabled = true;
    }

    public boolean isBeaconNotificationsEnabled() {
        return beaconNotificationsEnabled;
    }
}
