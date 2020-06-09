package br.gov.tre.models;

import javax.swing.JOptionPane;

public class Candidato extends Pessoa{
	private int numero;
	private String partidoPolitico;
	private char cargo;
	private int qtdVotos;	
	
	public int getQtdVotos() {
		return qtdVotos;
	}

	public void setQtdVotos(int qtdVotos) {
		this.qtdVotos = qtdVotos;
	}

	public Candidato() {
		super();
	}
	
	public  Candidato(String nome, int numero, String municipio, String partidoPolitico, char cargo) { 
		super(nome, municipio);
		this.numero = numero;
		this.partidoPolitico = partidoPolitico;
		this.cargo = cargo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getPartidoPolitico() {
		return partidoPolitico;
	}

	public void setPartidoPolitico(String partidoPolitico) {
		this.partidoPolitico = partidoPolitico;
	}

	public char getCargo() {
		return cargo;
	}

	public void setCargo(char cargo) {
		this.cargo = cargo;
	}
	
	public void imprimirDados() {
		JOptionPane.showMessageDialog(null, "Nome do candidato: " + super.getNome() + 
				"\nNúmero do título: " + getNumero() +
				"\nMunicípio: " + super.getMunicipio() + 
				"\nPartido Politico: " + getPartidoPolitico() +
				"\nCargo: " + getCargo());
	}
	
	public String retornarDadosImpressao() {
		return "Nome do candidato: " + super.getNome() + 
				" - Número do título: " + getNumero() +
				" - Município: " + super.getMunicipio() + 
				" - Partido Politico: " + getPartidoPolitico() +
				" - Cargo: " + getCargo();		 
	}
}
