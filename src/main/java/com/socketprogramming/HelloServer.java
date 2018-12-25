package com.socketprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class HelloServer {
	private ServerSocket serverSocket;
	private Socket clientSocket;
	private PrintWriter write;
	private BufferedReader read;
	String sayHello = "Hello to server";
	
	public void connect(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		clientSocket = serverSocket.accept();
		write = new PrintWriter(clientSocket.getOutputStream(), true);
		read = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		String greet = read.readLine();
		if(sayHello.equals(greet)) {
			write.println("Hello client");
		} else {
			write.println("Wrong greeting");
		}
	}
	
	public void disconnect() throws IOException {
		read.close();
		write.close();
		clientSocket.close();
		serverSocket.close();
	}
	
	public static void main(String[] args) throws IOException {
		HelloServer hello = new HelloServer();
		hello.connect(7777);
	}
}