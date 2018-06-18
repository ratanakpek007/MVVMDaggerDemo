package delivery.food.mvvmdemo;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules ={
        ApplicationModule.class,
        ActivityBindingModule.class
})
public interface ApplicaitonComponent {
    void inject(MyApplication myApplication);
}
