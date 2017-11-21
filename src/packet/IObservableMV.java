package packet;

public interface IObservableMV {
	public void SetListenerMV(IObserverMV observer);
	public void RemoveListenerMV();
}
