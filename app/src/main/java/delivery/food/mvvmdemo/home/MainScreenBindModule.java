package delivery.food.mvvmdemo.home;

import com.bluelinelabs.conductor.Controller;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import delivery.food.mvvmdemo.TrendingRepoController;
import delivery.food.mvvmdemo.controller.TrendingRepoComponent;
import delivery.food.mvvmdemo.di.ControllerKey;

@Module(subcomponents = {
        TrendingRepoComponent.class
})
public abstract class MainScreenBindModule {
    @Binds
    @IntoMap
    @ControllerKey(TrendingRepoController.class)
    abstract AndroidInjector.Factory<? extends Controller> bindTrendingRepoInjector(TrendingRepoComponent.Builder builder);
}
