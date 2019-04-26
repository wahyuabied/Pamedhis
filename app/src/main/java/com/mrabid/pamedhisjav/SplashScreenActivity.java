package com.mrabid.pamedhisjav;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.mrabid.pamedhisjav.model.User;

public class SplashScreenActivity extends AppCompatActivity {


    SharedPreferences sharedPreferences;
    SharedPreferences.Editor prefs;
    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        sharedPreferences = getSharedPreferences("data",MODE_NO_LOCALIZED_COLLATORS);
        prefs = sharedPreferences.edit();
        final User user =  new Gson().fromJson(sharedPreferences.getString("user",""), User.class);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                try{
                    Log.e("test",user.getToken());
                    startActivity(new Intent(SplashScreenActivity.this,MainActivity.class));
                    finish();
                }catch (Exception e){
                    startActivity(new Intent(SplashScreenActivity.this,LoginActivity.class));
                    finish();
                }

            }
        },2000);
    }
}
