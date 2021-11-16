package com.example.jawad.presenter;

import static com.example.jawad.functions.Functions.checkIfAndroidVBiggerThan9;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Login {

    public static void Login(LoginPre loginPre)
    {
        if (checkIfAndroidVBiggerThan9()) {
            Log.w("TAG", "Message " + "whenLoginCompleteSuccess");

            JSONObject obj = null;
            String token="ANqVF8PzLrCt0sxt7ZqPsuqrPPX0Z" +
                    "i5CXnF699-DmG6txOlpz5iom0Z7JxpKnLWmlBMcYr2YG9C1ef331cOTj" +
                    "sI7OlUVbQwGhvA5CR8ISwqSllvqtBPU83LWCueuwtc4mXNL6QbW7DzEqmd" +
                    "eQdGfCgIXHX8nxC_0NMo4-FkqAkEgE2XbJ0NUe-GdEhNsjBFZI0KWSEBAka" +
                    "IAiekLjN0pY5znei62mRyayUwlMI0KKtHqOKJ96g3yk2NtsMGqGC8EYeMcB" +
                    "H30Oy_z8M6NirCgjssKj_fTtUdQUq-jc2gRW_JewgjirFzgsS6NeAdx3e0mN-" +
                    "Zawk1qqTy7L0BCO037UA";
            String email_str="raza@gmail.com",pass= "123456";

            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();

            RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                    .addFormDataPart("Email","raza@gmail.com")
                    .addFormDataPart("Password","123456")
                    .build();

            Request request = new Request.Builder()
                    .url("http://192.168.0.115/api/User/Login")
                    .method("POST", body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Accept", "application/json ")
                    .build();

            //.addHeader("Authorization", "Bearer " + token)


            try {
                Response response = client.newCall(request).execute();
                try {
                    Log.w("TAG", "Response " + response);
                    loginPre.whenYourAPIComplete(response);

                    obj = new JSONObject(response.body().string());
                    JSONObject data = obj.getJSONObject("Result");

                    Log.w("TAG", "Result " + data);
                    //send response by interface

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }



    public static void SuccessTest(LoginPre loginPre)
    {
        String platform_token="d0EuzqTo5jA:APA91bEGbyLFcYODAoFKME27cXGx_HpbqXKgcbRWsRkBfo5yDXn82E1v6VjdIwP5--xPy1SlJD6MsQiCFsB68aUW-S_LgZHbOCIfEdXSDb4Q7x5aWpS9J7Znnas4TVzB9VsKi6rzTisJ";
        String photoURL = "https://graph.facebook.com/2949594945090128/picture?type=normal";

        if (checkIfAndroidVBiggerThan9()){


            JSONObject obj = null;
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                    .addFormDataPart("name","Mohammad Obiedat")
                    .addFormDataPart("email","abukhadeer@gmail.com")
                    .addFormDataPart("password","123456")
                    .addFormDataPart("platform","facebook")
                    .addFormDataPart("platform_id","2949594945090128")
                    .addFormDataPart("platform_token",platform_token)
                    .addFormDataPart("photo",photoURL)
                    .addFormDataPart("phone","00")
                    .build();
            Request request = new Request.Builder()
                    .url("http://174.138.4.155/api/login")
                    .method("POST", body)
                    .addHeader("Accept", "application/json")
                    .build();
            try {
                Response response = client.newCall(request).execute();
                try {
                    //send response by interface
                    Log.w("TAG", "Response " + response);

                    obj = new JSONObject(response.body().string());
                    JSONObject data = obj.getJSONObject("DATA");

                    Log.w("TAG", "Result " + data);
                    loginPre.whenLoginComplete(data,response);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
