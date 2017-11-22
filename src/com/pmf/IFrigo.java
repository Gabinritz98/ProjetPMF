package common;

import java.util.ArrayList;

public interface IFrigo {

	ArrayList<Packet> GetRecievedDataHistory();

	double getTempExt();

	double getTempInt();

	double getHygro();

	double getConsigne();
	
	void setConsigne(double consigne);

	ArrayList<String> getContenu();

	void AddContenu(String contenu);

	void RemoveContenu(String contenu);

	Boolean isTooHot();

	Boolean isTooCold();

	Boolean isPossible();

}