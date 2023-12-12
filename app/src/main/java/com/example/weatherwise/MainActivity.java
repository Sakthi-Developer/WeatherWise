package com.example.weatherwise;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.weatherwise.ApiPackage.ApiClient;
import com.example.weatherwise.ApiPackage.ApiInterface;
import com.example.weatherwise.ApiPackage.CurrentWeatherResponseModel;
import com.example.weatherwise.ApiPackage.HourlyWeatherResponseModel;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.material.imageview.ShapeableImageView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_LOCATION = 2535;
    TextView temperature;
    TextView wind;
    TextView pressure;
    TextView humidity;
    private double longitude, latitude;
    RecyclerView recyclerView;
    ApiInterface apiInterface;
    Adapter adapter;
    RelativeLayout logout_button;
    ArrayList<HourlyWeatherResponseModel.Hour> foreCastList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ShapeableImageView shapeableImageView = findViewById(R.id.background_image);

        Glide.with(this).load(R.drawable.evening_forest).centerCrop().into(shapeableImageView);
        CustomLoderDialog customLoderDialog = new CustomLoderDialog(MainActivity.this);
        getCurrentLocation();

        logout_button = findViewById(R.id.logout_button);
        logout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                customLoderDialog.show();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        if (FirebaseAuthManager.getInstance().signOut()) {
                            customLoderDialog.dismiss();
                            startActivity(new Intent(MainActivity.this, LogInSignUp.class));
                        }

                    }
                },2000);

            }
        });

    }

    private void getCurrentLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE_LOCATION);

        }

        FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        fusedLocationProviderClient.getLastLocation()
                .addOnSuccessListener(this, location -> {
                    if (location == null) {

                        Toast.makeText(this, "Turn On Device GPS", Toast.LENGTH_SHORT).show();

                        if (!(isLocationEnabled(this))){

                                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                this.startActivity(intent);

                        }

                    }

                    latitude = Objects.requireNonNull(location).getLatitude();
                    longitude = Objects.requireNonNull(location).getLongitude();


                    getCurrentWeather(String.valueOf(latitude)+','+ longitude);
                    getHourlyForecast(String.valueOf(latitude)+','+ longitude);


                }).addOnFailureListener(this, e -> {
                    Log.d("OnFail", Objects.requireNonNull(e.getMessage()));
                    Toast.makeText(MainActivity.this, " LocationServices.API is not available on this device", Toast.LENGTH_LONG).show();

                });

    }

    private void getCurrentWeather(String q) {
        Log.d("q",q);
        apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);
        Call<CurrentWeatherResponseModel.Root> currentWeatherInterfaceCall = apiInterface.getCurrentWeather(q);

        currentWeatherInterfaceCall.enqueue(new Callback<CurrentWeatherResponseModel.Root>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(@NonNull Call<CurrentWeatherResponseModel.Root> call, @NonNull Response<CurrentWeatherResponseModel.Root> response) {

                temperature = findViewById(R.id.CurrentWeatherDisplay);
                wind = findViewById(R.id.windValue);
                pressure = findViewById(R.id.pressureValue);
                humidity = findViewById(R.id.humidityValue);


                Log.d("success", String.valueOf(response.code()));

                if (response.body() != null) {

                    temperature.setText(Math.round(response.body().getCurrent().getTemp_c()) + "°C");
                    wind.setText(Math.round(response.body().getCurrent().getWind_kph()) + " km/h");
                    pressure.setText(Math.round(response.body().getCurrent().getPressure_mb()) + "mb");
                    humidity.setText(response.body().getCurrent().getHumidity() + " %");

                    Log.d("tag", String.valueOf(response.body().getCurrent().getHumidity()));

                }else {
                    Toast.makeText(MainActivity.this, "Null", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<CurrentWeatherResponseModel.Root> call, @NonNull Throwable t) {
                Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_LONG).show();
                Log.d("exception", Objects.requireNonNull(t.getMessage()));
            }
        });

    }

    public void getHourlyForecast(String q){

        apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);
        Call<HourlyWeatherResponseModel.Root> hourlyWeatherResponseModelCall = apiInterface.getHourlyWeather(q, 0);

        hourlyWeatherResponseModelCall.enqueue(new Callback<HourlyWeatherResponseModel.Root>() {
            @Override
            public void onResponse(@NonNull Call<HourlyWeatherResponseModel.Root> call, @NonNull Response<HourlyWeatherResponseModel.Root> response) {


                if (response.body()!=null){

                    foreCastList = new ArrayList<>();

                    foreCastList.addAll(response.body().getForecast().getForecastday().get(0).getHour());

                    String time = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());

                    recyclerView = findViewById(R.id.recyclerview);
                    adapter = new Adapter(MainActivity.this, foreCastList);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL, false));

                    recyclerView.scrollToPosition(Integer.parseInt(time.substring(0,2)) - 1);
                    LinearLayout layout = findViewById(R.id.recyclerLayout);

                    layout.setVisibility(View.VISIBLE);
                    logout_button.setVisibility(View.VISIBLE);

                }else{
                    Log.d("Code when null", String.valueOf(response.code()));
                    Log.d("Body when null", String.valueOf(response.body()));
                    Toast.makeText(MainActivity.this, "Response is Null", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(@NonNull Call<HourlyWeatherResponseModel.Root> call, @NonNull Throwable t) {
                Log.d("the t", Objects.requireNonNull(t.getMessage()));
                TextView textView = findViewById(R.id.msg);
                textView.setText(t.getMessage());
                Toast.makeText(MainActivity.this, "Weather Forecast Api Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_LOCATION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, get the location and weather
                getCurrentLocation();
            } else {
                // Permission denied, handle accordingly
                Toast.makeText(this, "Location permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public static boolean isLocationEnabled(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        return locationManager != null && (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
                || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER));
    }

}
