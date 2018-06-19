package delivery.food.mvvmdemo.ui;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;

import javax.inject.Inject;

public class DefaultScreenNavigator implements ScreenNavigator {


    private Router router;

    @Inject
    DefaultScreenNavigator() {

    }

    @Override
    public void initWithRouter(Router router, Controller controller) {
        this.router = router;
        if (!router.hasRootController()) {
            router.setRoot(RouterTransaction.with(controller));
        }
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean pop() {
        return router != null & router.handleBack();
    }
}
