package delivery.food.mvvmdemo.di;

import android.app.Activity;
import android.content.Context;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

import dagger.android.AndroidInjector;
import delivery.food.mvvmdemo.MyApplication;
import delivery.food.mvvmdemo.base.BaseActivity;

public class ActivityInjector {

    private Map<Class<? extends Activity>, Provider<AndroidInjector.Factory<? extends Activity>>> activityInjector;
    private final Map<String, AndroidInjector<? extends Activity>> cache = new HashMap<>();

    @Inject
    ActivityInjector(Map<Class<? extends Activity>, Provider<AndroidInjector.Factory<? extends Activity>>> activityInjector) {
        this.activityInjector = activityInjector;
    }

    public void inject(Activity activity){
        if(!(activity instanceof BaseActivity)){
            throw new IllegalArgumentException("Activity must extends from base Activity!!!");
        }

        String instanceId= ((BaseActivity) activity).getInstanceId();
        if(cache.containsKey(instanceId)){
            ((AndroidInjector<Activity>)cache.get(instanceId)).inject(activity);
            return;
        }

        //no activity object found
        AndroidInjector.Factory<Activity> injectFactory= (AndroidInjector.Factory<Activity>) activityInjector.get(activity.getClass()).get();
        AndroidInjector<Activity> injector=injectFactory.create(activity);
        cache.put(instanceId, injector);
        injector.inject(activity);
    }
    public void clear(Activity activity){
        if(!(activity instanceof BaseActivity)){
            throw new IllegalArgumentException("Activity must extends from base Activity!!!");
        }
        cache.remove(((BaseActivity) activity).getInstanceId());
    }

    public static ActivityInjector get(Context context){
       return ((MyApplication)context.getApplicationContext()).getActivityInjector();
    }


}
