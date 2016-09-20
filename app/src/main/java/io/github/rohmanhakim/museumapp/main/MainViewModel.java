package io.github.rohmanhakim.museumapp.main;

import io.github.rohmanhakim.museumapp.api.RequestManager;
import io.github.rohmanhakim.museumapp.api.model.GetMuseumByLatLongResponse;
import io.github.rohmanhakim.museumapp.api.service.museum.IMuseumAPI;
import io.github.rohmanhakim.museumapp.api.service.museum.MuseumAPIService;
import rx.Subscriber;

/**
 * Created by rohmanhakim <rohmanhakim@live.com> on 9/20/16 11:36.
 */
public class MainViewModel {
    RequestManager requestManager;
    MainView view;
    Subscriber<GetMuseumByLatLongResponse> getMuseumByLatLongResponseSubscriber;

    public MainViewModel(MainView view, MuseumAPIService museumAPIService){
        requestManager = new RequestManager(museumAPIService);
        this.view = view;
        getMuseumByLatLongResponseSubscriber = new Subscriber<GetMuseumByLatLongResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                view.showError(e.getMessage().toString());
            }

            @Override
            public void onNext(GetMuseumByLatLongResponse getMuseumByLatLongResponse) {
                view.setMuseumName(getMuseumByLatLongResponse.data.get(0).nama);
            }
        };
    }

    public void getMuseumByLatLong(double lintang, double bujur){
        requestManager.getMuseumByLatLong(lintang,bujur).subscribe(getMuseumByLatLongResponseSubscriber);
    }
}
