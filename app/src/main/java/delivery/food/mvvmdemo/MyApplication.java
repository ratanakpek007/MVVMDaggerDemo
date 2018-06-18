package delivery.food.mvvmdemo;

import android.app.Application;

import javax.inject.Inject;

import delivery.food.mvvmdemo.di.ActivityInjector;

public class MyApplication extends Application {
    @Inject
    ActivityInjector activityInjector;

    private ApplicaitonComponent applicaitonComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicaitonComponent = DaggerApplicaitonComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicaitonComponent.inject(this);
    }

    public ActivityInjector getActivityInjector() {
        return activityInjector;
    }
}
