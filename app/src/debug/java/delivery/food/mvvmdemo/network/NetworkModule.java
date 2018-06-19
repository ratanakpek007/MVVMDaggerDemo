package delivery.food.mvvmdemo.network;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Call;
import okhttp3.OkHttpClient;
@Module
public abstract class NetworkModule {


    //https://api.github.com/search/repositories?q=language:java&order=desc&sort=stars


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
