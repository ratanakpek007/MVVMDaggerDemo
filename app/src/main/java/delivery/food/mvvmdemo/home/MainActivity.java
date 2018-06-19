package delivery.food.mvvmdemo.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bluelinelabs.conductor.Controller;

import delivery.food.mvvmdemo.R;
import delivery.food.mvvmdemo.base.BaseActivity;
import delivery.food.mvvmdemo.trending.TrendingRepoController;

public class MainActivity extends BaseActivity {


    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected Controller initialScreen() {
        return new TrendingRepoController();
    }
}
