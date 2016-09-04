package io.github.rohmanhakim.museumapp.deps;

import android.content.Context;
//import com.google.gson.Gson;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.DateTypeAdapter;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.github.rohmanhakim.museumapp.R;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rohmanhakim <rohmanhakim@live.com> on 9/4/16 13:33.
 */

@Module
public class MuseumApiModule {

    @Provides
    @Singleton
    @SuppressWarnings("unused")
    public Gson providesGson() {
        return new GsonBuilder().create();
    }

    @Provides
    @Singleton
    @SuppressWarnings("unused")
    @Named("baseOkhtpp")
    public okhttp3.OkHttpClient providesOkHttpClient3() {
        int timeout = 2;
        return new okhttp3.OkHttpClient.Builder()
                .readTimeout(timeout, TimeUnit.SECONDS)
                .writeTimeout(timeout, TimeUnit.SECONDS)
                .connectTimeout(timeout, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    @Singleton
    @SuppressWarnings("unused")
    @Named("baseRetrofit")
    public Retrofit providesBaseRetrofit(Context context, okhttp3.OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(context.getString(R.string.app_base_url))
                .client(okHttpClient)
                .build();
    }
}
