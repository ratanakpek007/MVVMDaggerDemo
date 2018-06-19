package delivery.food.mvvmdemo.base;

import javax.inject.Singleton;

import dagger.Component;
import delivery.food.mvvmdemo.MyApplication;
import delivery.food.mvvmdemo.data.RepoServiceModule;
import delivery.food.mvvmdemo.network.ServiceModule;

@Singleton
@Component(modules ={
        ApplicationModule.class,
        ActivityBindingModule.class,
        ServiceModule.class,
        RepoServiceModule.class
})
public interface ApplicationComponent {
    void inject(MyApplication myApplication);
}
