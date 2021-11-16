package com.example.jawad;

import static com.example.jawad.presenter.Login.Login;
import static com.example.jawad.presenter.Login.SuccessTest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jawad.presenter.LoginPre;

import org.json.JSONObject;

import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements LoginPre{

    TextView response_content,data_content;

    RelativeLayout success_test,ur_api;
    LoginPre loginPre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //init interface
        this.loginPre = (LoginPre) this;

        cast();
        actionListenerToSuccess_test();
        actionListenerToUrApi();
    }

    private void actionListenerToUrApi() {
        ur_api.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login(loginPre);
            }
        });
    }

    private void actionListenerToSuccess_test() {
        success_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SuccessTest(loginPre);
            }
        });
    }

    private void cast() {
        success_test = (RelativeLayout) findViewById(R.id.success_test);
        ur_api = (RelativeLayout) findViewById(R.id.ur_api);
        response_content= (TextView) findViewById(R.id.response_content);
        data_content= (TextView) findViewById(R.id.data_content);

    }

    @Override
    public void whenLoginComplete(JSONObject obj, Response response) {
        response_content.setText("");
        data_content.setText("");
        response_content.setText(response.toString());
        data_content.setText(obj.toString());
    }

    @Override
    public void whenYourAPIComplete(Response response) {
        response_content.setText("");
        data_content.setText("");
        data_content.setText("Null");
        response_content.setText(response.toString());
    }
}