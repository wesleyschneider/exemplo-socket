package org.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		System.out.println("Enter a string: ");
		BufferedReader valueKeyboard = new BufferedReader(new InputStreamReader(System.in));

		try {
			Socket socket = new Socket("localhost", 7777);

			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

			writer.writeBytes(valueKeyboard.readLine() + "\n");

			System.out.println("Server: " + reader.readLine());

			socket.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
