package delivery.food.mvvmdemo.network;

import com.ryanharter.auto.value.moshi.MoshiAdapterFactory;
import com.squareup.moshi.Moshi;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import delivery.food.mvvmdemo.model.AdapterFactory;
import delivery.food.mvvmdemo.model.ZonedDateTimeAdapter;
import okhttp3.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Module(includes = NetworkModule.class)
public abstract class ServiceModule {

    @Provides
    @Singleton
    static Moshi provideMoshi(){
        return new Moshi.Builder()
                .add(AdapterFactory.create())
                .add(new ZonedDateTimeAdapter())
                .build();
    }

    @Provides
    @Singleton
    static Retrofit provideRetrofit(Moshi moshi, Call.Factory call, @Named("base_url") String baseUrl){
        return new Retrofit.Builder()
                .callFactory(call)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseUrl)
                .build();

    }
}