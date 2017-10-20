package com.cooksys.sendFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ReceiveFile {
	
	public static void main(String[] args) throws IOException{
		
		ServerSocket socket = null;
		Socket sock = null;
		InputStream in = null;
		FileOutputStream fstream = null;
		File f = null;
		
		System.out.println("Waiting...");
		
		try {
			socket = new ServerSocket(8084);
			sock = socket.accept();
		    System.out.println("Accepted Connection...");
		    
			f = new File("hello.txt");
			fstream = new FileOutputStream(f);
		    in = sock.getInputStream();
            byte[] input = null;
            while(in.available() != 0){
            	in.read(input);
            	fstream.write(input);
            }

		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			in.close();
			socket.close();
			sock.close();
			fstream.close();
		}
		
	}
}
