package br.gov.tre.models;

import javax.swing.JOptionPane;

public class Municipio {

	private String nome;
	private String estado;
	private int numeroHabitantes;
	private int vagasVereador;

	public Municipio(String nome, String estado, int numeroHabitantes, int vagasVereador) {
		this.nome = nome;
		this.estado = estado;
		this.numeroHabitantes = numeroHabitantes;
		this.vagasVereador = vagasVereador;
	}

	public Municipio() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getNumeroHabitantes() {
		return numeroHabitantes;
	}
	public void setNumeroHabitantes(int numeroHabitantes) {
		this.numeroHabitantes = numeroHabitantes;
	}
	public int getVagasVereador() {
		return vagasVereador;
	}
	public void setVagasVereador(int vagasVereador) {
		this.vagasVereador = vagasVereador;
	}
	
	public void imprimirDados() {
		JOptionPane.showMessageDialog(null, "Nome do Município: " + getNome() + 
				"\nNome do Estado: " + getEstado() +
				"\nNúmero de Habitantes: " + getNumeroHabitantes() +
				"\nNúmero de vagas para vereador " + getVagasVereador());
	}
	
	public String retornarDadosImpressao() {
		return ( "Nome do Município: " + getNome() + 
				"\nNome do Estado: " + getEstado() +
				"\nNúmero de Habitantes: " + getNumeroHabitantes() +
				"\nNúmero de vagas para vereador " + getVagasVereador());
	}
}

