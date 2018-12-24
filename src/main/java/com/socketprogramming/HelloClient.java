package com.socketprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class HelloClient {
	private Socket clientSocket;
	private BufferedReader read;
	
	public void communicate(String ip, int port) throws IOException {
		clientSocket = new Socket(ip,port);
		read = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	}
	
	public String sendMessage(String msg) throws IOException {
		System.out.println(msg);
		String resp = read.readLine();
		return resp;
	}
	
	public void disconnect() throws IOException {
		read.close();
		clientSocket.close();
	}

	public static void main(String[] args) throws IOException {
		HelloClient client = new HelloClient();
		client.communicate("127.0.0.1", 7777);
		String resp = client.sendMessage("Hello to server");
		System.out.println(resp);	
	}

}
