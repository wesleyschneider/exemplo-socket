package org.example;

import java.io.*;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

		try {
			Socket socket = new Socket("localhost", 7778);

			ObjectOutputStream writer = new ObjectOutputStream(socket.getOutputStream());

			System.out.println("Digite o nome do aluno: ");
			var nome = keyboard.readLine();

			System.out.println("Digite a nota do aluno: ");
			var nota = Double.parseDouble(keyboard.readLine());

			var aluno = new Aluno(nome, nota);

			writer.writeObject(aluno);

			ObjectInputStream reader = new ObjectInputStream(socket.getInputStream());
			System.out.println("Server: " + reader.readObject());

			socket.close();
		} catch (IOException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
