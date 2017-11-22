package com.pmf.model;

import com.pmf.IObservableMV;

public interface IModel extends IObservableMV {
	public Frigo getRawFrigo(int i);
	public void InitializeFrigo(int i);
}
