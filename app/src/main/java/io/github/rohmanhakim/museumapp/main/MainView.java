package io.github.rohmanhakim.museumapp.main;

import com.google.android.gms.maps.model.LatLng;

import java.util.List;

/**
 * Created by rohmanhakim <rohmanhakim@live.com> on 9/20/16 14:00.
 */
public interface MainView {
    void showError(String message);
    void populateMuseumCoordinate(List<LatLng> museumCoordinates);
    void initMap();
}
