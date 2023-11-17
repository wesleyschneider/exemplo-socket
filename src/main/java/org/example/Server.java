package org.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(7777);

			while (true) {
				Socket socket = serverSocket.accept();

				System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

				writer.writeBytes(reader.readLine().toUpperCase() + "\n");

			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}