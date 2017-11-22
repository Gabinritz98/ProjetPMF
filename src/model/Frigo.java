package common.model;

import java.util.ArrayList;

import common.Packet;

public class Frigo implements IObservableFrigo{
	public Frigo(int port, int consigne, ArrayList<String> contenu) {
		Consigne = consigne;
		Contenu = contenu;
		this.Port = port;
	}
	
	public Packet getCommandPacket() {
		Packet ret = Packet.getPacket("C"+Consigne);
		return ret;
	}
	
	private ArrayList<Packet> PacketHistory = new ArrayList<Packet>();
	private double TempExt, TempInt, Hygro, Consigne;
	private int Port;
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
	public double getTempExt() {
		return TempExt;
	}
	private void setTempExt(double tempExt) {
		if(tempExt!=TempExt) {
			frigoObserver.NotifyFrigo(this);
		}
		TempExt = tempExt;
	}
	public double getTempInt() {
		return TempInt;
	}
	private void setTempInt(double tempInt) {
		if(tempInt!=TempInt) {
			frigoObserver.NotifyFrigo(this);
		}
		TempInt = tempInt;
	}
	public double getHygro() {
		return Hygro;
	}
	private void setHygro(double hygro) {
		if(hygro!=Hygro) {
			frigoObserver.NotifyFrigo(this);
		}
		Hygro = hygro;
	}
	public double getConsigne() {
		return Consigne;
	}
	private void setConsigne(double consigne) {
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

	public int getPort() {
		return Port;
	}
}
