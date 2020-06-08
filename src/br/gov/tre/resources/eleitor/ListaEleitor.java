package br.gov.tre.resources.eleitor;

import java.util.ArrayList;

import br.gov.tre.models.Eleitor;
import br.gov.tre.models.UrnaEletronica;
import br.gov.tre.resources.urna.CelulaUrnaEletronica;

public class ListaEleitor {

	private CelulaEleitor primeiro; 
    								
	private CelulaEleitor ultimo;  


	public ListaEleitor()
	{
		primeiro = new CelulaEleitor();
		ultimo = primeiro;
	}

	public void inserirFinal(Eleitor novoEleitor)
	{
		CelulaEleitor aux = new CelulaEleitor();

		ultimo.proximo = aux;

		aux.item = novoEleitor;

		ultimo = ultimo.proximo;
	}

    public Eleitor retirar(long numeroTitulo)
    {
        CelulaEleitor aux, anterior;


        anterior = primeiro;


        aux = primeiro.proximo;


        while (aux != null)
        {

            if (aux.item.getNumeroTitulo() == numeroTitulo)
            {

                anterior.proximo = aux.proximo;

                if (aux == ultimo)
                {

                    ultimo = anterior;
                }
                return aux.item;
            }
            else
            {

                anterior = aux;
                aux = aux.proximo;
            }
        }
        return null;
    }
    

    public Eleitor localizar(long numeroTitulo)
    {
        CelulaEleitor aux;

        aux = primeiro.proximo;

        while (aux != null)
        {
            if (aux.item.getNumeroTitulo() == numeroTitulo)
            {
                return aux.item;
            }
            else
            {
                aux = aux.proximo;
            }
        }
        return null;
    }
    
    public Eleitor retornarItem(){
    
        CelulaEleitor aux;
        Eleitor eleitor = null;

        aux = primeiro.proximo;

        while (aux != null)
        {		
        	eleitor = aux.item;
            aux = aux.proximo;
            }
        return eleitor;
        }
        
    public Boolean listaVazia()
    {
        if (primeiro == ultimo)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void imprimirDadosCartao()
    {
        CelulaEleitor aux;

        aux = primeiro.proximo;

        if (aux == null)
        {
            System.out.println("A lista de produtos est� vazia.");
        }
        else
        {
            while (aux != null)
            {
                aux.item.imprimirDados();                
                aux = aux.proximo;
            }
        }
    }
    public String retornarDadosLinha()
    {
        CelulaEleitor aux;
        
        String dadosEmLinha = "";

        aux = primeiro.proximo;

        if (aux == null)
        {
            System.out.println("A lista de produtos está vazia.");
        }
        else
        {
            while (aux != null)
            {
            	dadosEmLinha += aux.item.retornarDadosImpressao() +"\n";                
                aux = aux.proximo;
            }
        }
        return dadosEmLinha;
    }
    
    public ArrayList<Eleitor> listaEleitores(){
    	
    	ArrayList<Eleitor> listaEleitores = new ArrayList<Eleitor>();
    	
    	CelulaEleitor aux;

        aux = primeiro.proximo;

        if (aux == null)
        {
        	System.out.println("A lista de produtos está vazia.");
        }
        else 
        {
            while (aux != null)
            {
            	listaEleitores.add(aux.item);        
                aux = aux.proximo;
            }
        }    	
    	return listaEleitores;
    	
    }
    

    
}
