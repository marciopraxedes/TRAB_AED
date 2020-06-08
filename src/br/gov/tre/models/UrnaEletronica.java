package br.gov.tre.models;

import javax.swing.JOptionPane;

public class UrnaEletronica {

	private String municipio;
	private int zonaEleitoral;
	private int secaoEleitoral;
	
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
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
	
	public UrnaEletronica(String municipio, int zonaEleitoral, int secaoEleitoral) {
		super();
		this.municipio = municipio;
		this.zonaEleitoral = zonaEleitoral;
		this.secaoEleitoral = secaoEleitoral;
	}
	
	public UrnaEletronica() {
		// TODO Auto-generated constructor stub
	}
	public void imprimirDados() {
		JOptionPane.showMessageDialog(null, "Municipio: " + getMunicipio() + 
				"\nZona Eleitoral: " + getZonaEleitoral() +
				"\nSeção eleitoral: " + getSecaoEleitoral());
	}
	
	public String retornarDadosImpressao() {
		return "Municipio: " + getMunicipio() + 
				" - Zona Eleitoral: " + getZonaEleitoral() +
				" - Seção eleitoral: " + getSecaoEleitoral();		 
	}
}
