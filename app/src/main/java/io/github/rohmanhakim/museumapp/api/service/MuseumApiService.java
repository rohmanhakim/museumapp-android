package io.github.rohmanhakim.museumapp.api.service;

import io.github.rohmanhakim.museumapp.api.MuseumApiUrl;
import io.github.rohmanhakim.museumapp.api.model.GetMuseumByLatLongResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by rohmanhakim <rohmanhakim@live.com> on 9/4/16 14:35.
 */
public interface MuseumApiService {
    @GET(MuseumApiUrl.MuseumSearchUrl)
    Call<GetMuseumByLatLongResponse> getMuseumByLatLong(
            @Query("lintang") double lintang,
            @Query("bujur") double bujur
    );
}
