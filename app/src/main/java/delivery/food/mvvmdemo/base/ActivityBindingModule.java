package delivery.food.mvvmdemo.base;


import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import delivery.food.mvvmdemo.home.MainActivity;
import delivery.food.mvvmdemo.home.MainActivityComponent;

@Module(subcomponents = {
        MainActivityComponent.class
})
public abstract class ActivityBindingModule  {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> provideMainActivityInjector(MainActivityComponent.Builder builder);
}
