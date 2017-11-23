package common.controller;

import common.IFrigoSerialListener;
import common.IModel;

public class Controller {

    private static Controller controllerInstance;
    
    public static Controller getControllerInstance() {
        if(controllerInstance == null) {
            controllerInstance = new Controller();
        }
        return controllerInstance;
    }
    
    private IModel model;

    public void setModel(IModel model) {
		this.model = model;
	}

	public void init() {
		IFrigoSerialListener frigo = model.getRawFrigo(0);
		Trigger t = new Trigger(frigo);
		t.TriggerStart(1000);
    }
}
