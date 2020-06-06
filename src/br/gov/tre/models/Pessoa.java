package br.gov.tre.models;

public class Pessoa {

	private String nome;
	private String municipio;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	
	public Pessoa() {
		
	}
	
	public Pessoa(String nome, String municipio) {
		super();
		this.nome = nome;
		this.municipio = municipio;
	}
	
	
}
