package org.example;

import java.io.Serializable;

public class Aluno implements Serializable {
	private String nome;
	private Double nota;

	public Aluno(String nome, Double nota) {
		this.nome = nome;
		this.nota = nota;
	}

	public String getNome() {
		return nome;
	}

	public Double getNota() {
		return nota;
	}
}
