package com.example.tinderv2;

import android.app.Application;

import com.yandex.metrica.YandexMetrica;
import com.yandex.metrica.YandexMetricaConfig;

public class tinderv2 extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // Creating an extended library configuration.
        YandexMetricaConfig config = YandexMetricaConfig.newConfigBuilder("ac6cc3ac-7008-4bd1-b7a8-ac954f6578d0").build();
        // Initializing the AppMetrica SDK.
        YandexMetrica.activate(getApplicationContext(), config);
        // Automatic tracking of user activity.
        YandexMetrica.enableActivityAutoTracking(this);
    }

}
