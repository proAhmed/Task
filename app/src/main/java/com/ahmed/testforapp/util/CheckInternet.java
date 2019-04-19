package com.ahmed.testforapp.util;

import android.content.Context;
import android.net.ConnectivityManager;

import javax.inject.Inject;

public class CheckInternet {
    private Context context;

    @Inject
    public CheckInternet(Context context) {
        this.context = context;
    }


    public boolean isConnectingToInternet(){
        ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return (cm != null ? cm.getActiveNetworkInfo() : null) != null && cm.getActiveNetworkInfo().isConnected();

    }
}
