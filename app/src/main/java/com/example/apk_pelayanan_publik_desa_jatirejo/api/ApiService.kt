package com.example.apk_pelayanan_publik_desa_jatirejo.api

import com.example.apk_pelayanan_publik_desa_jatirejo.model.ApiResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

//interface ApiService {
//    @GET("test_connection.php")
//    suspend fun testConnection(): Response<YourResponseModel>
//}

interface ApiService {
    // Endpoint untuk login
    @FormUrlEncoded
    @POST("login.php")
    suspend fun login(
        @Field("email_nomor_hp") email_nomor_hp: String,
        @Field("password") password: String
    ): Response<ApiResponse>

    // Endpoint untuk registrasi
    @FormUrlEncoded
    @POST("register.php")
    suspend fun register(
        @Field("username") username: String,
        @Field("email_nomor_hp") email_nomor_hp: String,
        @Field("nik") nik: String,
        @Field("password") password: String
    ): Response<ApiResponse>

    @POST("update_status_akun.php")
    suspend fun updateStatusAkun(@Field("nik") nik: String): Response<ApiResponse>

    // Endpoint untuk test koneksi
    @GET("test_connection.php")
    suspend fun testConnection(): Response<ApiResponse>
}

