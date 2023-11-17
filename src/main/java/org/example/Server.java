package org.example;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	public static void main(String[] args) {
		var alunos = new ArrayList<Aluno>();

		try {
			ServerSocket serverSocket = new ServerSocket(7778);

			while (true) {
				Socket socket = serverSocket.accept();

				System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

				ObjectInputStream reader = new ObjectInputStream(socket.getInputStream());
				ObjectOutputStream writer = new ObjectOutputStream(socket.getOutputStream());

				var aluno = (Aluno) reader.readObject();

				if(aluno == null) break;

				alunos.add(aluno);

				System.out.println("Alunos cadastrados: ");
				alunos.forEach(a -> System.out.println(a.getNome() + " - " + a.getNota()));

				writer.writeObject("Aluno inserido com sucesso!");
			}
		} catch (IOException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

}