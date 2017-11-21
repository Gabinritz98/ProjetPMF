package space.toolreaz.controller;

import space.toolreaz.IObservableMV;
import space.toolreaz.IObserverMV;
import space.toolreaz.model.Model;
import space.toolreaz.view.View;

public class Controller {

    private static Controller controllerInstance;
    private View view;
    private Model model;
    
    public static Controller getControllerInstance() {
        if(controllerInstance == null) {
            controllerInstance = new Controller();
        }
        return controllerInstance;
    }

    public void setView(View view) {
        this.view = view;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void init() {
    }
}
