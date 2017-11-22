package common.model;

import common.IFrigo;

public interface IObservableFrigo {
	public void SetListenerFrigo(IObserverFrigo observer);
	public void RemoveListenerFrigo();
	public default IFrigo GetFrigo() {
		return (IFrigo)this;
	}
}
