package common;

import common.controller.Controller;
import common.model.Model;
import common.view.View;
import common.view.courbe.TraceurCourbes;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        // Setup Model
        Model model = Model.getModelInstance();
        // Setup Controller
        Controller controller = Controller.getControllerInstance();
        // Setup View
        View view = View.GetInstance();
        TraceurCourbes courbes = new TraceurCourbes();
        view.SetCourbe(courbes);
        model.SetListenerMV(view);
        controller.setModel(model);
        controller.init();

        //controller.setView(view);
        //controller.setModel(model);
    }
}
