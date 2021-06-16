package org.dieschnittstelle.mobile.android.skeleton.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.dieschnittstelle.mobile.android.skeleton.crud.remote.ServiceFactory;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class RouterEmptyActivity extends Activity {

    public static final String INTENT_IS_WEB_API_ACCESSIBLE = "IS_WEB_API_ACCESSIBLE";
    private static final String TAG = RouterEmptyActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toast.makeText(this, "Checking connectivity...", Toast.LENGTH_SHORT);
        Future<Boolean> connectivityFuture = checkConnectivityAsync();
        Intent intent;

        try {
            if (connectivityFuture.get()) {
                Toast.makeText(this, "Backend accessible", Toast.LENGTH_SHORT).show();

                intent = new Intent(this, LoginActivity.class);

            } else {
                Toast.makeText(this, "Backend not accessible", Toast.LENGTH_SHORT).show();

                intent = new Intent(this, OverviewActivity.class);
            }
        }
        catch(Exception e){
            Toast.makeText(this, "Got exception: " + e, Toast.LENGTH_SHORT).show();
            intent = new Intent(this, OverviewActivity.class);
        }
        Toast.makeText(this, "Application started...", Toast.LENGTH_SHORT).show();

        this.startActivity(intent);
        finish();

    }


    public Future<Boolean> checkConnectivityAsync(){
        CompletableFuture<Boolean> future = new CompletableFuture<>();

        new Thread(()->{
            boolean connectionAvailable = checkConnectivity();
            future.complete(connectionAvailable);
        }).start();

        return future;
    }

    public boolean checkConnectivity(){
        HttpURLConnection conn = null;
        try {
            conn = (HttpURLConnection) new URL("http://10.0.2.2:8080").openConnection();
            conn.setReadTimeout(1000);
            conn.setConnectTimeout(1000);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.connect();
            conn.getInputStream();
            return true;
        }catch(Exception e){
            Log.e("RouterEmptyActivity", "Got exception: " + e,e);
            return false;
        }
        finally {
            if(conn != null){
                conn.disconnect();
            }
        }

    }


}