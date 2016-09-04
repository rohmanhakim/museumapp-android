package io.github.rohmanhakim.museumapp.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;

import io.github.rohmanhakim.museumapp.MuseumApp;
import io.github.rohmanhakim.museumapp.R;
import io.github.rohmanhakim.museumapp.api.model.GetMuseumByLatLongResponse;
import io.github.rohmanhakim.museumapp.api.service.MuseumApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Inject
    MuseumApiService museumApiService;

    TextView textHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((MuseumApp) getApplication()).getMuseumComponent().inject(this);

        textHello = (TextView) findViewById(R.id.text_hello);

        museumApiService.getMuseumByLatLong(-8.2838530,115.3644660).enqueue(new Callback<GetMuseumByLatLongResponse>() {
            @Override
            public void onResponse(Call<GetMuseumByLatLongResponse> call, Response<GetMuseumByLatLongResponse> response) {
                textHello.setText(response.body().data.get(0).nama);
            }

            @Override
            public void onFailure(Call<GetMuseumByLatLongResponse> call, Throwable t) {
                textHello.setText(t.getMessage());
            }
        });
    }
}
