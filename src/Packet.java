package space.toolreaz;

public class Packet {
	private int TempInterne,TempExterne,Consigne,Hygro;
	
	public Packet(int TempInt,int TempExt,int Consigne, int Hygro) {
		TempInterne = TempInt;
		TempExterne = TempExt;
		this.Consigne = Consigne;
		this.Hygro = Hygro;
	}
	
	public static Packet getPacket(String packetStr) {
		int TempI=-274,Consigne=-274,TempE=-274,Hygro=-1;
		String[] preparse = packetStr.split("d");
		for(String field:preparse) {
			switch (field.charAt(0)){
			case 'I':TempI    = Integer.parseInt(field.substring(1));break;
			case 'C':Consigne = Integer.parseInt(field.substring(1));break;
			case 'E':TempE    = Integer.parseInt(field.substring(1));break;
			case 'H':Hygro    = Integer.parseInt(field.substring(1));break;
			}
		}
		return new Packet(TempI, TempE, Consigne, Hygro);
	}
	
	public String ToString() {
		return "I"+TempInterne+"dC"+Consigne+"dE"+TempExterne+"dH"+Hygro;
	}

	public int getTempInterne() {
		return TempInterne;
	}

	public void setTempInterne(int tempInterne) {
		TempInterne = tempInterne;
	}

	public int getTempExterne() {
		return TempExterne;
	}

	public void setTempExterne(int tempExterne) {
		TempExterne = tempExterne;
	}

	public int getConsigne() {
		return Consigne;
	}

	public void setConsigne(int consigne) {
		Consigne = consigne;
	}

	public int getHygro() {
		return Hygro;
	}

	public void setHygro(int hygro) {
		Hygro = hygro;
	}
}
