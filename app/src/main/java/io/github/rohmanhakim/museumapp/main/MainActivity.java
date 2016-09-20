package io.github.rohmanhakim.museumapp.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import io.github.rohmanhakim.museumapp.MuseumApp;
import io.github.rohmanhakim.museumapp.R;
import io.github.rohmanhakim.museumapp.api.service.museum.IMuseumAPI;
import io.github.rohmanhakim.museumapp.api.service.museum.MuseumAPIService;


public class MainActivity extends AppCompatActivity implements MainView {

    @Inject
    MuseumAPIService museumAPIService;

    MainViewModel viewModel;
    TextView textHello;
    Button btnTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((MuseumApp) getApplication()).getMuseumComponent().inject(this);

        viewModel = new MainViewModel(this,museumAPIService);

        textHello = (TextView) findViewById(R.id.text_hello);
        btnTest = (Button) findViewById(R.id.btn_test);

        btnTest.setOnClickListener(v -> viewModel.getMuseumByLatLong(-8.2838530, 115.3644660));
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT);
    }

    @Override
    public void setMuseumName(String name) {
        textHello.setText(name);
    }

}
