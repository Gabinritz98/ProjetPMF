package com.pmf.model;

import com.pmf.IObservableMV;
import com.pmf.IObserverMV;
import java.util.ArrayList;

public class Model implements IModel {
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
        frigo.SetListenerFrigo((IObserverFrigo) this);
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
            observer.NotifyMV((IObservableMV) this);
        }
    }

    public void NotifyFrigo(IObservableFrigo observable) {
        observer.NotifyMV((IObservableMV) this);
    }

    public Frigo getRawFrigo(int i) {
        return frigo;
    }
}
