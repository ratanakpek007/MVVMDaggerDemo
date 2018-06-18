package delivery.food.mvvmdemo.di;

import android.app.Activity;

import com.bluelinelabs.conductor.Controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

import dagger.android.AndroidInjector;
import delivery.food.mvvmdemo.base.BaseActivity;
import delivery.food.mvvmdemo.base.BaseController;

@ActivityScope
public class ScreenInjector {

    private Map<Class<? extends Controller>, Provider<AndroidInjector.Factory<? extends Controller>>> screenInjector;

    private final Map<String, AndroidInjector<Controller>> cache = new HashMap<>();

    @Inject
    ScreenInjector(Map<Class<? extends Controller>, Provider<AndroidInjector.Factory<? extends Controller>>> screenInjector) {
        this.screenInjector = screenInjector;
    }

    public void inject(Controller controller) {
        if (!(controller instanceof BaseController)) {
            throw new IllegalArgumentException("Must extends to Base Controller!");
        }
        String instanceId = controller.getInstanceId();
        if (cache.containsKey(instanceId)) {
            cache.get(instanceId).inject(controller);
            return;
        }
        AndroidInjector.Factory<Controller> injectorFacotry = (AndroidInjector.Factory<Controller>) screenInjector.get(controller.getClass()).get();
        AndroidInjector<Controller> injector = injectorFacotry.create(controller);
        cache.put(instanceId, injector);
        injector.inject(controller);
    }
    public void clear(Controller controller){
        cache.remove(controller.getInstanceId());
    }
    public static ScreenInjector get(Activity activity){
        if(!(activity instanceof BaseActivity)){
            throw  new IllegalArgumentException("Controller must be hosted by BaseActivity!");
        }
        return ((BaseActivity)activity).getScreenInjector();
    }
}
