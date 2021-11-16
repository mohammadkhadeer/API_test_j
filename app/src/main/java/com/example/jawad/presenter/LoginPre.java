package com.example.jawad.presenter;

import org.json.JSONObject;

import okhttp3.Response;

public interface LoginPre {
    void whenLoginComplete(JSONObject obj, Response response);
    void whenYourAPIComplete( Response response);
}
