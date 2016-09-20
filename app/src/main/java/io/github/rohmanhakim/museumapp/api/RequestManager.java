package io.github.rohmanhakim.museumapp.api;

import android.app.Activity;
import android.content.Context;

import javax.inject.Inject;

import io.github.rohmanhakim.museumapp.MuseumApp;
import io.github.rohmanhakim.museumapp.api.model.GetMuseumByLatLongResponse;
import io.github.rohmanhakim.museumapp.api.service.museum.IMuseumAPI;
import io.github.rohmanhakim.museumapp.api.service.museum.MuseumAPIService;
import rx.Observable;

/**
 * Created by rohmanhakim <rohmanhakim@live.com> on 9/20/16 11:38.
 */
public class RequestManager {

    MuseumAPIService museumAPIService;

    public RequestManager(MuseumAPIService museumAPIService){
        this.museumAPIService = museumAPIService;
    }

    public Observable<GetMuseumByLatLongResponse> getMuseumByLatLong(double lintang, double bujur){
        return museumAPIService.getMuseumByLatLong(lintang, bujur);
    }
}
