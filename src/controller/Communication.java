package space.toolreaz.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Communication {
	public static RandomAccessFile pipe;
	public static void SendToSerial(String serial, String message) {
		SetupConnection();
		String processedMessage = "["+serial+"]:"+message;
		try {
			pipe.write(processedMessage.getBytes());
		} catch (IOException e) {
		}
	}
	private static void SetupConnection() {
		if(pipe==null)
		{
			try {
				pipe=new RandomAccessFile("\\\\.\\pipe\\JavaComConnection", "rw");
			} catch (FileNotFoundException e) {
			}
		}
	}
	public static String WaitMessage() {
		SetupConnection();
		try {
			return pipe.readLine();
		} catch (IOException e) {
			return "";
		}
	}
}
