package delivery.food.mvvmdemo.ui;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;

public interface ScreenNavigator {

    void initWithRouter(Router router, Controller controller);
    void clear();
    boolean pop();
}
