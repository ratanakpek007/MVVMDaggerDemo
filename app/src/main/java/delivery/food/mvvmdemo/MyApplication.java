package delivery.food.mvvmdemo;

import android.app.Application;

import javax.inject.Inject;

import delivery.food.mvvmdemo.base.ApplicationComponent;
import delivery.food.mvvmdemo.base.ApplicationModule;
import delivery.food.mvvmdemo.base.DaggerApplicationComponent;
import delivery.food.mvvmdemo.di.ActivityInjector;
import timber.log.Timber;


public class MyApplication extends Application {
    @Inject
    ActivityInjector activityInjector;

    private ApplicationComponent applicaitonComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicaitonComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicaitonComponent.inject(this);

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    public ActivityInjector getActivityInjector() {
        return activityInjector;
    }
}
