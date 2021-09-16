package com.example.theskillsshop;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface MessagesAPIsInterface {
    //Here we define the  request method for a particular php script
    @FormUrlEncoded
    @POST("messages.php")
    Call<ResponseModel> sendData(
            @Field("FIRST NAME") String first_name,
            @Field("SURNAME") String surname,
            @Field("MIDDLE NAME") String middle_name,
            @Field("PHONE NUMBER") String phone_number,
            @Field("EMAIL") String email,
            @Field("TEXT MESSAGE") String text_message,
            @Field("CREATED AT") String created_at
    );

}
