package common.controller;

import common.model.Model;
import common.view.View;

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
