package space.toolreaz.model;

import java.util.ArrayList;

import space.toolreaz.IObservableMV;
import space.toolreaz.IObserverMV;

public class Model implements IObservableMV, IObserverFrigo, IModel {
	
    private static Model modelInstance;
    
    public static Model getModelInstance() {
        if(modelInstance == null) {
            modelInstance = new Model();
        }
        return modelInstance;
    }
    
    private Model() {
        InitializeFrigo(4);
    }
    
    public void InitializeFrigo(int port) {
    	frigo = new Frigo(port, new ArrayList<String>());
    	frigo.SetListenerFrigo(this);
    }
    
    private Frigo frigo;

    private IObserverMV observer = null;
    
	public void SetListenerMV(IObserverMV observer) {
		this.observer = observer;
	}

	public void RemoveListenerMV() {
		this.observer = null;
	}
    
	public void TriggerObserverMV() {
		if(observer!=null) {
			observer.NotifyMV(this);
		}
	}

	public void NotifyFrigo(IObservableFrigo observable) {
		observer.NotifyMV(this);
	}

	@Override
	public Frigo getRawFrigo(int i) {
		return frigo;
	}
    
}
