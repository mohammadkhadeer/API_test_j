package com.example.jawad.functions;

import android.os.StrictMode;

public class Functions {

    public static boolean checkIfAndroidVBiggerThan9() {
        // we use this method cos OkHttpClient not allwed less than 9
        boolean value = false;
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            value = true;
        }else{
            value = false;
        }
        return value;
    }
}
