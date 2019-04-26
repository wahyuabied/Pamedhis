package com.mrabid.pamedhisjav.helper.retrofit;

import com.mrabid.pamedhisjav.model.Artikel;
import com.mrabid.pamedhisjav.model.Dokter;
import com.mrabid.pamedhisjav.model.User;
import com.mrabid.pamedhisjav.model.response.ResponseArtikel;
import com.mrabid.pamedhisjav.model.response.ResponseDokter;
import com.mrabid.pamedhisjav.model.response.ResponseRiwayat;
import com.mrabid.pamedhisjav.model.response.ResponseUser;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface API {

    //3010
    @POST("user/signin")
    @FormUrlEncoded
    Call<ResponseUser> login(@Field("username") String username, @Field("password") String password);

    @POST("user/dokter/byid")
    @FormUrlEncoded
    Call<ResponseDokter> getDokter(@Field("idUser") String idUser);

    //3020
    @POST("riwayat/byid")
    @FormUrlEncoded
    Call<ResponseRiwayat> getRiwayat(@Field("idPasien") String idPasien,@Header("Authorization")String Authorization);

    @POST("riwayat/giveAccess")
    @FormUrlEncoded
    Call<ResponseUser> getPermission(@Field("idPasien") String idPasien,@Field("idDokter") String idDokter,@Header("Authorization")String Authorization);

    //3030

    @GET("social/artikel/all")
    Call<ResponseArtikel> getArtikel(@Header("Authorization") String Authorization);

}
