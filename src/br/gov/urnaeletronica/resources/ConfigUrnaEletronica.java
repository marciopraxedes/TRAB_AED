package br.gov.urnaeletronica.resources;

import br.gov.resources.candidato.TabelaHashCandidato;
import br.gov.tre.resources.eleitor.TabelaHashEleitor;

public class ConfigUrnaEletronica  {
	
	private String municipio;
	private int zonaEleitoral;
	private int secaoEleitoral;
	private TabelaHashCandidato tabelaCandidatos;
	private TabelaHashEleitor tabelaEleitores;
	
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
	public TabelaHashCandidato getTabelaCandidatos() {
		return tabelaCandidatos;
	}
	public void setTabelaCandidatos(TabelaHashCandidato tabelaCandidatos) {
		this.tabelaCandidatos = tabelaCandidatos;
	}
	public TabelaHashEleitor getTabelaEleitores() {
		return tabelaEleitores;
	}
	public void setTabelaEleitores(TabelaHashEleitor tabelaEleitores) {
		this.tabelaEleitores = tabelaEleitores;
	}
	
	public ConfigUrnaEletronica(String municipio, int zonaEleitoral, int secaoEleitoral,
			TabelaHashCandidato tabelaCandidatos, TabelaHashEleitor tabelaEleitores) {
		this.municipio = municipio;
		this.zonaEleitoral = zonaEleitoral;
		this.secaoEleitoral = secaoEleitoral;
		this.tabelaCandidatos = tabelaCandidatos;
		this.tabelaEleitores = tabelaEleitores;
	}
	
	public ConfigUrnaEletronica() {
		
	}

	
	
		
}
