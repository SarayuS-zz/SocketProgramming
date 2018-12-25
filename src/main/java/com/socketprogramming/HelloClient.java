package com.socketprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HelloClient {
	private Socket clientSocket;
	private BufferedReader read;
	private PrintWriter write;
	
	public void communicate(String ip, int port) throws IOException {
		clientSocket = new Socket(ip,port);
		read = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		write = new PrintWriter(clientSocket.getOutputStream(), true);
	}
	
	public String sendMessage(String msg) throws IOException {
		write.println(msg);
		String resp = read.readLine();
		return resp;
	}
	
	public void disconnect() throws IOException {
		read.close();
		write.close();
		clientSocket.close();
	}

	public static void main(String[] args) throws IOException {
		HelloClient client = new HelloClient();
		client.communicate("127.0.0.1", 7777);
		String resp = client.sendMessage("Hello to server");
		System.out.println(resp);
	}

}
