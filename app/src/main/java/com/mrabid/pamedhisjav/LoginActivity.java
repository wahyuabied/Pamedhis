package com.mrabid.pamedhisjav;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.mrabid.pamedhisjav.helper.Validator;
import com.mrabid.pamedhisjav.helper.retrofit.CallbackSelf;
import com.mrabid.pamedhisjav.helper.retrofit.ServicesPamedhis;
import com.mrabid.pamedhisjav.model.User;
import com.mrabid.pamedhisjav.model.response.ResponseUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    EditText username,password;
    ProgressBar loading;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor prefs;
    User user;
    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPreferences = this.getSharedPreferences("data",MODE_NO_LOCALIZED_COLLATORS);
        prefs = sharedPreferences.edit();
        username = findViewById(R.id.login_etUsername);
        loading = findViewById(R.id.login_pb);
        password = findViewById(R.id.login_etPassword);
        btnLogin = findViewById(R.id.login_btLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Validator.input(username) && Validator.input(password)){
                    loading.setVisibility(View.VISIBLE);
                    login(new CallbackSelf() {
                        @Override
                        public void onSuccess(boolean result) {
                            if(result){
                                prefs.putString("user",new Gson().toJson(user));
                                prefs.apply();
                                loading.setVisibility(View.GONE);
                                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                                finish();
                            }
                            loading.setVisibility(View.GONE);
                        }
                    });
                }
            }
        });

    }

    public void login(final CallbackSelf callbackSelf){
        ServicesPamedhis.buildServiceClient().login(username.getText()+"",password.getText()+"").enqueue(new Callback<ResponseUser>() {
            @Override
            public void onResponse(Call<ResponseUser> call, Response<ResponseUser> response) {
                if(response.body().getStatus()){
                    user = response.body().getData();
                    callbackSelf.onSuccess(true);
                }else{
                    Toast.makeText(LoginActivity.this, response.body().getMessage()+"", Toast.LENGTH_SHORT).show();
                    callbackSelf.onSuccess(false);
                }
            }
            @Override
            public void onFailure(Call<ResponseUser> call, Throwable t) {
                Log.e("Response",t.toString());
                Toast.makeText(LoginActivity.this, "Check internet connection", Toast.LENGTH_SHORT).show();
                callbackSelf.onSuccess(false);
            }
        });
    }
}
