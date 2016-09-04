package io.github.rohmanhakim.museumapp;

import android.app.Application;

import io.github.rohmanhakim.museumapp.deps.DaggerMuseumComponent;
import io.github.rohmanhakim.museumapp.deps.MuseumApiModule;
import io.github.rohmanhakim.museumapp.deps.MuseumAppModule;
import io.github.rohmanhakim.museumapp.deps.MuseumComponent;

/**
 * Created by rohmanhakim <rohmanhakim@live.com> on 9/4/16 13:52.
 */
public class MuseumApp extends Application{
    private MuseumComponent museumComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        museumComponent = DaggerMuseumComponent.builder()
                .museumAppModule(new MuseumAppModule(this))
                .museumApiModule(new MuseumApiModule())
                .build();
    }
}
