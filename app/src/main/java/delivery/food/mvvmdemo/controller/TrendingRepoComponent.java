package delivery.food.mvvmdemo.controller;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import delivery.food.mvvmdemo.TrendingRepoController;
import delivery.food.mvvmdemo.di.ScreenScope;

@ScreenScope
@Subcomponent
public interface TrendingRepoComponent extends AndroidInjector<TrendingRepoController> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<TrendingRepoController>{

    }


}
