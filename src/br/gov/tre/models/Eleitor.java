package br.gov.tre.models;

import javax.swing.JOptionPane;

public class Eleitor extends Pessoa {

	private long numeroTitulo;
	private int zonaEleitoral;
	private int secaoEleitoral;
	
	public long getNumeroTitulo() {
		return numeroTitulo;
	}
	public void setNumeroTitulo(long numeroTitulo) {
		this.numeroTitulo = numeroTitulo;
	}
	public int getZonaEleitoral() {
		return zonaEleitoral;
	}
	public void setZonaEleitoral(int zonaEleitoral) {
		this.zonaEleitoral = zonaEleitoral;
	}
	public int getSecaoEleitoral() {
		return secaoEleitoral;
	}
	public void setSecaoEleitoral(int secaoEleitoral) {
		this.secaoEleitoral = secaoEleitoral;
	}
	
	public Eleitor() {
		super();
	}
	
	public Eleitor(String nome, String municipio, long numeroTitulo, int zonaEleitoral, int secaoEleitoral) {
		super(nome, municipio);
		this.numeroTitulo = numeroTitulo;
		this.zonaEleitoral = zonaEleitoral;
		this.secaoEleitoral = secaoEleitoral;
	}
	
	public void exibirDados() {
		JOptionPane.showMessageDialog(null, "Nome do eleitor: " + super.getNome() + 
				"\nNúmero do título: " + getNumeroTitulo() +
				"\nMunicípio: " + super.getMunicipio() + 
				"\nZona eleitoral: " + getZonaEleitoral() +
				"\nSeção eleitoral: " + getSecaoEleitoral());
	}
	
}
