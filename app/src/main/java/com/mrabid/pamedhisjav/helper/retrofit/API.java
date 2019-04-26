package com.mrabid.pamedhisjav.helper.retrofit;

import com.mrabid.pamedhisjav.model.User;
import com.mrabid.pamedhisjav.model.response.ResponseRiwayat;
import com.mrabid.pamedhisjav.model.response.ResponseUser;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface API {

    @POST("user/signin")
    @FormUrlEncoded
    Call<ResponseUser> login(@Field("username") String username, @Field("password") String password);

    @POST("riwayat/byid")
    @FormUrlEncoded
    Call<ResponseRiwayat> getRiwayat(@Field("idPasien") String idPasien);
}
