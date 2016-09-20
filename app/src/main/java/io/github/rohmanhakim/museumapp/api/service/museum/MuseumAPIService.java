package io.github.rohmanhakim.museumapp.api.service.museum;


import io.github.rohmanhakim.museumapp.api.model.GetMuseumByLatLongResponse;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by rohmanhakim <rohmanhakim@live.com> on 9/20/16 13:33.
 */
public class MuseumAPIService {

    IMuseumAPI museumAPI;

    public MuseumAPIService(IMuseumAPI museumAPI){
        this.museumAPI = museumAPI;
    }

    public Observable<GetMuseumByLatLongResponse> getMuseumByLatLong(double lintang, double bujur){
        return museumAPI.getMuseumByLatLong(lintang, bujur)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
