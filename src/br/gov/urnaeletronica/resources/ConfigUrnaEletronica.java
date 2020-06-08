package br.gov.urnaeletronica.resources;

import br.gov.tre.models.Candidato;

public class ConfigUrnaEletronica extends Candidato {

	private int Id;
	private long numeroTitulo;
	private int zonaEleitoral;
	private int secaoEleitoral;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
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
	
	public ConfigUrnaEletronica(int id, long numeroTitulo, int zonaEleitoral, int secaoEleitoral) {
		super();
		Id = id;
		this.numeroTitulo = numeroTitulo;
		this.zonaEleitoral = zonaEleitoral;
		this.secaoEleitoral = secaoEleitoral;
	}
	public ConfigUrnaEletronica() {
		// TODO Auto-generated constructor stub
	}
		
}
