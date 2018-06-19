package delivery.food.mvvmdemo.base;

import javax.inject.Singleton;

import dagger.Component;
import delivery.food.mvvmdemo.MyApplication;

@Singleton
@Component(modules ={
        ApplicationModule.class,
        ActivityBindingModule.class
})
public interface ApplicationComponent {
    void inject(MyApplication myApplication);
}
