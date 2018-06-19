package delivery.food.mvvmdemo.network;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Provides;
import okhttp3.Call;
import okhttp3.OkHttpClient;

public abstract class NetworkModule {

    @Provides
    @Singleton
    static Call.Factory provideOKHttp(){
        return new OkHttpClient.Builder().build();
    }

    @Provides
    @Named("base_url")
    static String provideBaseUrl(){
        return "https://api.github.com";
    }
}
