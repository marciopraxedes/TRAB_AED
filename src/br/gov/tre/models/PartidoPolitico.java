package br.gov.tre.models;

import javax.swing.JOptionPane;

public class PartidoPolitico {
	
	private String nome;
	private String sigla;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	public PartidoPolitico(String nome, String sigla) {
		super();
		this.nome = nome;
		this.sigla = sigla;
	}	
	
	
	public PartidoPolitico() {
		// TODO Auto-generated constructor stub
	}
	public void imprimirDados() {
		JOptionPane.showMessageDialog(null, "Nome do Partido: " + getNome() + 
				"\nSigla do Partido: " + getSigla());
	}
	
	public String retornarDadosImpressao() {
		return "Nome do Partido: " + getNome() + 
				" - Sigla do Partido: " + getSigla();		 
	}

}
