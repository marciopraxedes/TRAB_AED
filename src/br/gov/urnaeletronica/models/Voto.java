package br.gov.urnaeletronica.models;

import br.gov.tre.models.Candidato;

public class Voto extends Candidato {

	private int quantidadeVotos;

	public int getQuantidadeVotos() {
		return quantidadeVotos;
	}

	public void setQuantidadeVotos(int quantidadeVotos) {
		this.quantidadeVotos = quantidadeVotos;
	}

	public Voto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Voto(String nome, int numero, String municipio, String partidoPolitico, char cargo, int quantidadeVotos) {
		super(nome, numero, municipio, partidoPolitico, cargo);
		this.quantidadeVotos = quantidadeVotos;
		// TODO Auto-generated constructor stub
	}
	
}
