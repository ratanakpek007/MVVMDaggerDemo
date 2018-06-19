package delivery.food.mvvmdemo.home;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import delivery.food.mvvmdemo.di.ActivityScope;

@ActivityScope
@Subcomponent(modules = {
        MainScreenBindModule.class
})
public interface MainActivityComponent extends AndroidInjector<MainActivity> {


    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity>{

    }


}
