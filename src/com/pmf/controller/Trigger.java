package common.controller;

import java.util.Timer;
import java.util.TimerTask;

import common.IFrigoSerialListener;
import common.Packet;

public class Trigger {
	Timer t;
	
	IFrigoSerialListener frigo;

	public Trigger(IFrigoSerialListener frigo2) {
		t = new Timer();
		this.frigo = frigo2;
	}
	
	public void TriggerStart(int msDelay) {
		t.schedule(new Event(frigo), 0, 1000);
	}
	
	public void TriggerStop() {
		t.cancel();
	}

	class Event extends TimerTask {

		private IFrigoSerialListener frigo;
		
		public Event(IFrigoSerialListener frigo) {
			this.frigo = frigo;
		}
		
		public void run() {
			Communication.SendMessage("COM"+frigo.getPort(), frigo.getCommandPacket().ToString());
			String response = Communication.WaitMessage();
			OnTrigger(response);
		}
		
		private synchronized void OnTrigger(String message) {
			Packet packetResponse = Packet.getPacket(message);
			frigo.AddRecievedData(packetResponse);
		}
	}
}
