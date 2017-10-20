package com.cooksys.sendFile;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class sendFile {

	public static void main(String[] args) throws IOException {
		
		String host = "10.1.1.168";
		System.out.println("Connecting...");
		
		Socket socket = null;
		DataOutputStream out = null;
		
		try {
			
			socket = new Socket(host, 8084);
			out = new DataOutputStream(socket.getOutputStream());
			out.writeChars("hello world!");
			out.flush();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			System.out.println("Done.");
			out.close();
			socket.close();
		}		
	}
}
