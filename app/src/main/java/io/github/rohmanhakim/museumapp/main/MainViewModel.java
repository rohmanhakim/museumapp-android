package io.github.rohmanhakim.museumapp.main;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

import io.github.rohmanhakim.museumapp.api.RequestManager;
import io.github.rohmanhakim.museumapp.api.model.Data;
import io.github.rohmanhakim.museumapp.api.model.GetMuseumByLatLongResponse;
import io.github.rohmanhakim.museumapp.api.service.museum.IMuseumAPI;
import io.github.rohmanhakim.museumapp.api.service.museum.MuseumAPIService;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by rohmanhakim <rohmanhakim@live.com> on 9/20/16 11:36.
 */
public class MainViewModel {
    RequestManager requestManager;
    MainView view;
    Subscriber<List<LatLng>> getMuseumByLatLongResponseSubscriber;

    public MainViewModel(MainView view, MuseumAPIService museumAPIService){
        requestManager = new RequestManager(museumAPIService);
        this.view = view;
        getMuseumByLatLongResponseSubscriber = new Subscriber<List<LatLng>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                view.showError(e.getMessage());
            }

            @Override
            public void onNext(List<LatLng> coordinates) {
                view.populateMuseumCoordinate(coordinates);
            }
        };
    }

    public void getMuseumCoordinatesByLatLong(double lintang, double bujur){
        requestManager.getMuseumByLatLong(lintang,bujur).map(new Func1<GetMuseumByLatLongResponse, List<LatLng>>() {
            @Override
            public List<LatLng> call(GetMuseumByLatLongResponse getMuseumByLatLongResponse) {
                List<LatLng> coordinates = new ArrayList<LatLng>();
                for (Data data : getMuseumByLatLongResponse.data){
                    coordinates.add(new LatLng(Double.parseDouble(data.lintang),Double.parseDouble(data.bujur)));
                }
                return coordinates;
            }
        }).subscribe(getMuseumByLatLongResponseSubscriber);
    }
}
