package br.gov.tre.models;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Vencedores {
	private Municipio municipio;
	private Candidato prefeito;
	private ArrayList<Candidato> vereadoresList;
	
	public Vencedores(Municipio municipio, Candidato prefeito, ArrayList<Candidato> vereadoresList) {
		this.municipio = municipio;
		this.prefeito = prefeito;
		this.vereadoresList = vereadoresList;
	}
	
	boolean segundoTurno;
	public Municipio getMunicipio() {
		return municipio;
	}
	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}
	public Candidato getPrefeito() {
		return prefeito;
	}
	public void setPrefeito(Candidato prefeito) {
		this.prefeito = prefeito;
	}
	public boolean isSegundoTurno() {
		return segundoTurno;
	}
	public void setSegundoTurno(boolean segundoTurno) {
		this.segundoTurno = segundoTurno;
	}
	
	public ArrayList<Candidato> getVereadoresList() {
		return vereadoresList;
	}
	public void setVereadoresList(ArrayList<Candidato> vereadoresList) {
		this.vereadoresList = vereadoresList;
	}
	public void imprimirDados() {
		JOptionPane.showMessageDialog(null, "Nome do municipio: " + getMunicipio().getNome() + 
				"\nNome do Prefeito: " + getPrefeito().getNome() +
				"\nNome dos vereadores: " + getVereadoresList());
	}
	public String retornarDadosImpressao() {
		return "Nome do municipio: " + getMunicipio().getNome() + 
				"\nNome do Prefeito: " + getPrefeito().getNome() +
				"\nNome dos vereadores: " + getVereadoresList();		 
	}
	
	
}
