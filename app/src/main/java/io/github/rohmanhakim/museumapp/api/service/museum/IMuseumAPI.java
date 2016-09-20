package io.github.rohmanhakim.museumapp.api.service.museum;

import io.github.rohmanhakim.museumapp.api.MuseumApiUrl;
import io.github.rohmanhakim.museumapp.api.model.GetMuseumByLatLongResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by rohmanhakim <rohmanhakim@live.com> on 9/4/16 14:35.
 */
public interface IMuseumAPI {
    @GET(MuseumApiUrl.MuseumSearchUrl)
    Observable<GetMuseumByLatLongResponse> getMuseumByLatLong(
            @Query("lintang") double lintang,
            @Query("bujur") double bujur
    );
}
