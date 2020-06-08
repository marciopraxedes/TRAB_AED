package br.gov.tre.resources.eleitor;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.gov.tre.models.Eleitor;


public class TabelaHashEleitor {

	private int M;

	private ListaEleitor[] tabelaEleitores; 	
				
		public TabelaHashEleitor(int tamanho){
			
			M = tamanho;
			tabelaEleitores = new ListaEleitor[M];
			
			for (int i=0 ; i < M ; i++ ) {
				tabelaEleitores[i] = new ListaEleitor();
			}
		}	
	
	
	private int funcaoHash(long chave){ 
		
		Long pos;
		int posicao;
		
		pos = chave % M;
		
		posicao = Integer.parseInt(pos.toString());
		
		return posicao;
		
	}


	public int inserirEleitor(Eleitor novoEleitor){
		
		long codigo;
		int posicao;
		
		codigo = novoEleitor.getNumeroTitulo();		
		posicao = funcaoHash(codigo);
		
		if (tabelaEleitores[posicao].localizar(codigo) == null) {
			tabelaEleitores[posicao].inserirFinal(novoEleitor);
		}
		else 
			posicao = -1;
		
		return posicao;
		
	}
	
	public void retirarEleitor (long numeroTitulo) {
		
		int posicao;
		

		posicao = funcaoHash(numeroTitulo);	
		
		tabelaEleitores[posicao].retirar(numeroTitulo);
	}


	public Eleitor pesquisarEleitor(long numeroTitulo){
		
		int posicao;
		Eleitor item = null;
		
		posicao = funcaoHash(numeroTitulo);
		item = tabelaEleitores[posicao].localizar(numeroTitulo);
			
			return item;	
		}
		

	public void imprimirEleitores(){

		for(int i=0 ; i < M ; i++ ) {
			if ((tabelaEleitores[i].listaVazia()!=true)) { 
				tabelaEleitores[i].imprimirDadosCartao();
			}
		}
		
	}
	
	public void imprimirEleitoresEmLinha(){
		
		String listaTabelaEleitores = "";
		for(int i=0 ; i < M ; i++ ) {
			if ((tabelaEleitores[i].listaVazia()!=true)) { 
				listaTabelaEleitores += tabelaEleitores[i].retornarDadosLinha();
			}
		}
		
		JOptionPane.showMessageDialog(null, listaTabelaEleitores);
	}
	
    public ArrayList<Eleitor> listaEleitores(){
    	
    	ArrayList<Eleitor> listaEleitores = new ArrayList<Eleitor>();
    	
    	for(int i=0 ; i < M ; i++ ) {
    		System.out.print(i);
			if ((tabelaEleitores[i].listaVazia()!=true)) {
					listaEleitores.addAll(tabelaEleitores[i].listaEleitores());
			}
		}    	
    	
    	return listaEleitores;
    	
    }
		
}

