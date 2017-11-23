package common;

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
			if(preparse[0].contains(":")) {
				preparse[0] = preparse[0].split(":")[1];
			}
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

	public double getTempInterne() {
		return (double)TempInterne/10;
	}

	public void setTempInterne(double tempInterne) {
		TempInterne = (int)(tempInterne*10);
	}

	public double getTempExterne() {
		return (double)TempExterne/10;
	}

	public void setTempExterne(double tempExterne) {
		TempExterne = (int)(tempExterne/10);
	}

	public double getConsigne() {
		return (double)Consigne/10;
	}

	public void setConsigne(double consigne) {
		Consigne = (int)(consigne/10);
	}

	public double getHygro() {
		return (double)Hygro/10;
	}

	public void setHygro(double hygro) {
		Hygro = (int)hygro;
	}
}
