package common;

public interface IFrigoSerialListener {

	Packet getCommandPacket();

	/* (non-Javadoc)
	 * @see common.model.IFrigoSerialListener#AddRecievedData(common.Packet)
	 */
	void AddRecievedData(Packet p);

	int getPort();

}