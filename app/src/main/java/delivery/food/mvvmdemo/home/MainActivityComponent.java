package delivery.food.mvvmdemo.home;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import delivery.food.mvvmdemo.data.RepoServiceModule;
import delivery.food.mvvmdemo.di.ActivityScope;
import delivery.food.mvvmdemo.network.ServiceModule;
import delivery.food.mvvmdemo.ui.NavigationModule;

@ActivityScope
@Subcomponent(modules = {
        MainScreenBindModule.class,
        NavigationModule.class

})
public interface MainActivityComponent extends AndroidInjector<MainActivity> {


    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {

       /* @BindsInstance
        public abstract void name(@Named("string") String string);*/

        @Override
        public void seedInstance(MainActivity instance) {

        }
    }


}
