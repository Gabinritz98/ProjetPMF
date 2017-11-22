package common.model;

import java.util.ArrayList;

import common.IObservableMV;
import common.IObserverMV;

public class Model implements IObservableMV, IObserverFrigo, IModel {
	
    private static Model modelInstance;
    
    public static Model getModelInstance() {
        if(modelInstance == null) {
            modelInstance = new Model();
        }
        return modelInstance;
    }
    
    private Model() {
        InitializeFrigo(4, 0);
    }
    
    public void InitializeFrigo(int port, int consigneInitiale) {
    	frigo = new Frigo(port, consigneInitiale, new ArrayList<String>());
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
