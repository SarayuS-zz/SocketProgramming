package com.socketprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class HelloServer {
	private ServerSocket serverSocket;
	private Socket clientSocket;
	private BufferedReader read;
	String sayHello = "Hello to server";
	
	public void connect(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		clientSocket = serverSocket.accept();
		read = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		String greet = read.readLine();
		if(sayHello.equals(greet)) {
			System.out.println("Hello client");
		} else {
			System.out.println("Wrong greeting");
		}
	}
	
	public void disconnect() throws IOException {
		read.close();
		clientSocket.close();
		serverSocket.close();
	}
	
	public static void main(String[] args) throws IOException {
		HelloServer hello = new HelloServer();
		hello.connect(7777);
	}
}