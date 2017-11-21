package model;

import java.util.ArrayList;
import packet.Packet;

public class Frigo implements IObservableFrigo{
	public Frigo(int consigne, ArrayList<String> contenu) {
		Consigne = consigne;
		Contenu = contenu;
	}
	private ArrayList<Packet> PacketHistory = new ArrayList<Packet>();
	private int TempExt, TempInt, Hygro, Consigne;
	private ArrayList<String> Contenu = new ArrayList<String>();
	public void AddRecievedData(Packet p) {
		PacketHistory.add(p);
		this.setTempInt(p.getTempInterne());
		this.setConsigne(p.getConsigne());
		this.setHygro(p.getHygro());
		this.setTempExt(p.getTempExterne());
	}
	@SuppressWarnings("unchecked")
	public ArrayList<Packet> GetRecievedDataHistory() {
		return (ArrayList<Packet>)PacketHistory.clone();
	}
	public int getTempExt() {
		return TempExt;
	}
	private void setTempExt(int tempExt) {
		if(tempExt!=TempExt) {
			frigoObserver.NotifyFrigo(this);
		}
		TempExt = tempExt;
	}
	public int getTempInt() {
		return TempInt;
	}
	private void setTempInt(int tempInt) {
		if(tempInt!=TempInt) {
			frigoObserver.NotifyFrigo(this);
		}
		TempInt = tempInt;
	}
	public int getHygro() {
		return Hygro;
	}
	private void setHygro(int hygro) {
		if(hygro!=Hygro) {
			frigoObserver.NotifyFrigo(this);
		}
		Hygro = hygro;
	}
	public int getConsigne() {
		return Consigne;
	}
	private void setConsigne(int consigne) {
		if(consigne!=Consigne) {
			frigoObserver.NotifyFrigo(this);
		}
		Consigne = consigne;
	}
	@SuppressWarnings("unchecked")
	public ArrayList<String> getContenu() {
		return (ArrayList<String>)Contenu.clone();
	}
	public void AddContenu(String contenu) {
		Contenu.add(contenu);
	}
	public void RemoveContenu(String contenu) {
		Contenu.remove(contenu);
	}
	
	public Boolean isTooHot() {
		return TempInt>Consigne;
	}
	public Boolean isTooCold() {
		return TempInt<Consigne;
	}
	public Boolean isPossible() {
		return Consigne<TempExt;
	}

	IObserverFrigo frigoObserver = null;
	
	public void SetListenerFrigo(IObserverFrigo observer) {
		frigoObserver = observer;
		
	}
	public void RemoveListenerFrigo() {
		frigoObserver = null;
		
	}
}
