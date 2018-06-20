package delivery.food.mvvmdemo.trending;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import delivery.food.mvvmdemo.di.ScreenScope;


@ScreenScope
@Subcomponent
public interface TrendingReposComponent extends AndroidInjector<TrendingReposController> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<TrendingReposController> {

    }
}
