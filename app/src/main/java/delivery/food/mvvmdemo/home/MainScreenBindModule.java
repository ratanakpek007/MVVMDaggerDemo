package delivery.food.mvvmdemo.home;

import com.bluelinelabs.conductor.Controller;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import delivery.food.mvvmdemo.di.ControllerKey;
import delivery.food.mvvmdemo.trending.TrendingReposComponent;
import delivery.food.mvvmdemo.trending.TrendingReposController;

@Module(subcomponents = {
        TrendingReposComponent.class
})
public abstract class MainScreenBindModule {

    @Binds
    @IntoMap
    @ControllerKey(TrendingReposController.class)
    abstract AndroidInjector.Factory<? extends Controller> bindTrendingRepoInjector(TrendingReposComponent.Builder builder);
}
