package common.model;

public interface IObservableFrigo {
	public void SetListenerFrigo(IObserverFrigo observer);
	public void RemoveListenerFrigo();
	public default Frigo GetFrigo() {
		return (Frigo)this;
	}
}
