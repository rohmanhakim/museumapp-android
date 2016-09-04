package io.github.rohmanhakim.museumapp.deps;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by rohmanhakim <rohmanhakim@live.com> on 9/4/16 13:41.
 */
@Module
public class MuseumAppModule {
    private final Context context;

    public MuseumAppModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    @SuppressWarnings("unused")
    public Context providesContext() {
        return context;
    }
}
