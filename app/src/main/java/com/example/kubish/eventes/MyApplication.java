package com.example.kubish.eventes;

import android.app.Application;
import android.content.Intent;
import android.content.res.Configuration;
import android.widget.Toast;

import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKAccessTokenTracker;
import com.vk.sdk.VKSdk;

/**
 * Created by Kubish on 05.09.2015.
 */



public class MyApplication extends Application {
    VKAccessTokenTracker vkAccessTokenTracker = new VKAccessTokenTracker() {
        @Override
        public void onVKAccessTokenChanged(VKAccessToken oldToken, VKAccessToken newToken) {
            if (newToken == null) {
                Toast.makeText(MyApplication.this, "AccessToken invalidated", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MyApplication.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        }
    };


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onCreate() {
       // Toast.makeText(MyApplication.this, "!!!!!!!!!!!!!", Toast.LENGTH_LONG).show();
        vkAccessTokenTracker.startTracking();
        VKSdk.initialize(this);
        super.onCreate();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

}