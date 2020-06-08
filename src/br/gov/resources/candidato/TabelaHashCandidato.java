package br.gov.resources.candidato;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.gov.tre.models.Candidato;

public class TabelaHashCandidato {
	private int M;

	private ListaCandidato[] tabelaCandidatos; 	
				
		public TabelaHashCandidato(int tamanho){
			
			M = tamanho;
			tabelaCandidatos = new ListaCandidato[M];
			
			for (int i=0 ; i < M ; i++ ) {
				tabelaCandidatos[i] = new ListaCandidato();
			}
		}	
	
	
	private int funcaoHash(long chave){ 
		
		Long pos;
		int posicao;
		
		pos = chave % M;
		
		posicao = Integer.parseInt(pos.toString());
		
		return posicao;
		
	}


	public int inserirCandidato(Candidato novoCandidato){
		
		long codigo;
		int posicao;
		
		codigo = novoCandidato.getNumero();		
		posicao = funcaoHash(codigo);
		
		if (tabelaCandidatos[posicao].localizar(codigo) == null) {
			tabelaCandidatos[posicao].inserirFinal(novoCandidato);
		}
		else 
			posicao = -1;
		
		return posicao;
		
	}
	
	public void retirarCandidato (long numeroCandidato) {
		
		int posicao;
		

		posicao = funcaoHash(numeroCandidato);	
		
		tabelaCandidatos[posicao].retirar(numeroCandidato);
	}


	public Candidato pesquisarCandidato(long numeroCandidato){
		
		int posicao;
		Candidato item = null;
		
		posicao = funcaoHash(numeroCandidato);
		item = tabelaCandidatos[posicao].localizar(numeroCandidato);
			
			return item;	
		}
		

	public void imprimirCandidatoes(){

		for(int i=0 ; i < M ; i++ ) {
			if ((tabelaCandidatos[i].listaVazia()!=true)) { 
				tabelaCandidatos[i].imprimirDadosCartao();
			}
		}
		
	}
	
	public void imprimirCandidatosEmLinha(){
		
		String listatabelaCandidatos = "";
		for(int i=0 ; i < M ; i++ ) {
			if ((tabelaCandidatos[i].listaVazia()!=true)) { 
				listatabelaCandidatos += tabelaCandidatos[i].retornarDadosLinha();
			}
		}
		
		JOptionPane.showMessageDialog(null, listatabelaCandidatos);
	}
	
    public ArrayList<Candidato> listaCandidatos(){
    	
    	ArrayList<Candidato> listaCandidatos = new ArrayList<Candidato>();
    	
    	for(int i=0 ; i < M ; i++ ) {
    		System.out.print(i);
			if ((tabelaCandidatos[i].listaVazia()!=true)) {
					listaCandidatos.addAll(tabelaCandidatos[i].listaCandidatos());
			}
		}    	
    	
    	return listaCandidatos;
    	
    }
}
