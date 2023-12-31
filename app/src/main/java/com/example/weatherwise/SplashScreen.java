package com.example.weatherwise;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

@SuppressLint("CustomSplashScreen")
public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        CustomLoderDialog dialog = new CustomLoderDialog(this);
        dialog.show();

        new Handler().postDelayed(() -> {
            dialog.dismiss();
            startActivity(new Intent(SplashScreen.this, LogInSignUp.class));
            finish();
        },1800);
    }
}