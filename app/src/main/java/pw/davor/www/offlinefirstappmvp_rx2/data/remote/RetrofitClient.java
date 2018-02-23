package pw.davor.www.offlinefirstappmvp_rx2.data.remote;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by bnc on 16.2.2018..
 */

public class RetrofitClient {
    private static Retrofit client;


    public static Retrofit getInstance(String baseUrl) {
        if (client == null) {
            synchronized (RetrofitClient.class) {
                if (client == null) {
                    client = new Retrofit.Builder()
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .baseUrl(baseUrl)
                            .build();
                }
            }
        }

        return client;

    }
}
