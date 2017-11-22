package space.toolreaz.model;

import java.util.Timer;
import java.util.TimerTask;

import space.toolreaz.Packet;
import space.toolreaz.controller.Communication;

public class Trigger {
	Timer t;
	
	Frigo frigo;

	public Trigger(Frigo frigo) {
		t = new Timer();
		this.frigo = frigo;
	}
	
	public void TriggerStart(int msDelay) {
		t.schedule(new Event(frigo), 0, 1000);
	}
	
	public void TriggerStop() {
		t.cancel();
	}

	class Event extends TimerTask {

		private Frigo frigo;
		
		public Event(Frigo frigo) {
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
