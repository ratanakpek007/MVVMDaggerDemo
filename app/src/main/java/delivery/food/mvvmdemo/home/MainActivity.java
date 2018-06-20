package delivery.food.mvvmdemo.home;

import com.bluelinelabs.conductor.Controller;

import delivery.food.mvvmdemo.R;
import delivery.food.mvvmdemo.base.BaseActivity;
import delivery.food.mvvmdemo.trending.TrendingReposController;

public class MainActivity extends BaseActivity {


    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected Controller initialScreen() {
        return new TrendingReposController();
    }
}
