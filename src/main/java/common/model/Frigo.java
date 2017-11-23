package common.model;

import java.util.ArrayList;

import common.IFrigo;
import common.IFrigoSerialListener;
import common.Packet;
import common.controller.Communication;

public class Frigo implements IObservableFrigo, IFrigo, IFrigoSerialListener{
	public Frigo(int port, int consigne, ArrayList<String> contenu) {
		Consigne = consigne;
		Contenu = contenu;
		this.Port = port;
	}
	
	/* (non-Javadoc)
	 * @see common.model.IFrigoSerialListener#getCommandPacket()
	 */
	@Override
	public Packet getCommandPacket() {
		Packet ret = Packet.getPacket("C"+(int)(Consigne*10));
		return ret;
	}
	
	private ArrayList<Packet> PacketHistory = new ArrayList<Packet>();
	private double TempExt, TempInt, Hygro, Consigne;
	private int Port;
	private ArrayList<String> Contenu = new ArrayList<String>();
	/* (non-Javadoc)
	 * @see common.model.IFrigoSerialListener#AddRecievedData(common.Packet)
	 */
	/* (non-Javadoc)
	 * @see common.model.IFrigoSerialListener#AddRecievedData(common.Packet)
	 */
	@Override
	public void AddRecievedData(Packet p) {
		PacketHistory.add(p);
		this.setTempInt(p.getTempInterne());
		this.setHygro(p.getHygro());
		this.setTempExt(p.getTempExterne());
		frigoObserver.NotifyFrigo(this);
	}
	/* (non-Javadoc)
	 * @see common.model.IFrigo#GetRecievedDataHistory()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public ArrayList<Packet> GetRecievedDataHistory() {
		return (ArrayList<Packet>)PacketHistory.clone();
	}
	/* (non-Javadoc)
	 * @see common.model.IFrigo#getTempExt()
	 */
	@Override
	public double getTempExt() {
		return TempExt;
	}
	private void setTempExt(double tempExt) {
		//if(tempExt!=TempExt) {
			//frigoObserver.NotifyFrigo(this);
		//}
		TempExt = tempExt;
	}
	/* (non-Javadoc)
	 * @see common.model.IFrigo#getTempInt()
	 */
	@Override
	public double getTempInt() {
		return TempInt;
	}
	private void setTempInt(double tempInt) {
		//if(tempInt!=TempInt) {
			//frigoObserver.NotifyFrigo(this);
		//}
		TempInt = tempInt;
	}
	/* (non-Javadoc)
	 * @see common.model.IFrigo#getHygro()
	 */
	@Override
	public double getHygro() {
		return Hygro;
	}
	private void setHygro(double hygro) {
		//if(hygro!=Hygro) {
			//frigoObserver.NotifyFrigo(this);
		//}
		Hygro = hygro;
	}
	/* (non-Javadoc)
	 * @see common.model.IFrigo#getConsigne()
	 */
	@Override
	public double getConsigne() {
		return Consigne;
	}
	@Override
	public void setConsigne(double consigne) {
		//if(consigne!=Consigne) {
		System.out.print("New consigne is : ");
		System.out.println(consigne);
		Consigne = consigne;
		Communication.SendMessage("COM"+this.getPort(), this.getCommandPacket().ToString());
		frigoObserver.NotifyFrigo(this);
		//}
	}
	/* (non-Javadoc)
	 * @see common.model.IFrigo#getContenu()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public ArrayList<String> getContenu() {
		return (ArrayList<String>)Contenu.clone();
	}
	/* (non-Javadoc)
	 * @see common.model.IFrigo#AddContenu(java.lang.String)
	 */
	@Override
	public void AddContenu(String contenu) {
		Contenu.add(contenu);
	}
	/* (non-Javadoc)
	 * @see common.model.IFrigo#RemoveContenu(java.lang.String)
	 */
	@Override
	public void RemoveContenu(String contenu) {
		Contenu.remove(contenu);
	}
	
	/* (non-Javadoc)
	 * @see common.model.IFrigo#isTooHot()
	 */
	@Override
	public Boolean isTooHot() {
		return TempInt>Consigne;
	}
	/* (non-Javadoc)
	 * @see common.model.IFrigo#isTooCold()
	 */
	@Override
	public Boolean isTooCold() {
		return TempInt<Consigne;
	}
	/* (non-Javadoc)
	 * @see common.model.IFrigo#isPossible()
	 */
	@Override
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

	/* (non-Javadoc)
	 * @see common.model.IFrigoSerialListener#getPort()
	 */
	@Override
	public int getPort() {
		return Port;
	}
}
