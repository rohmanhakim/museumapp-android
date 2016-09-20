package io.github.rohmanhakim.museumapp.deps;

import javax.inject.Singleton;

import dagger.Component;
import io.github.rohmanhakim.museumapp.api.RequestManager;
import io.github.rohmanhakim.museumapp.main.MainActivity;

/**
 * Created by rohmanhakim <rohmanhakim@live.com> on 9/4/16 13:50.
 */
@Singleton
@Component(modules = {
        MuseumAppModule.class,
        MuseumApiModule.class
})
public interface MuseumComponent {
    void inject(MainActivity mainActivity);
}
