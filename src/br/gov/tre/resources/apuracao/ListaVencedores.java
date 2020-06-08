package br.gov.tre.resources.apuracao;

import java.util.ArrayList;

import br.gov.tre.models.Vencedores;

public class ListaVencedores {
	private CelulaVencedores primeiro; 
	
	private CelulaVencedores ultimo;  


	public ListaVencedores()
	{
		primeiro = new CelulaVencedores();
		ultimo = primeiro;
	}

	public void inserirFinal(Vencedores novoVencedores)
	{
		CelulaVencedores aux = new CelulaVencedores();

		ultimo.proximo = aux;

		aux.item = novoVencedores;

		ultimo = ultimo.proximo;
	}

    public Vencedores retirar(String municipioNome)
    {
        CelulaVencedores aux, anterior;


        anterior = primeiro;


        aux = primeiro.proximo;


        while (aux != null)
        {

            if (aux.item.getMunicipio().getNome() == municipioNome)
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
    

    public Vencedores localizar(String municipioNome)
    {
        CelulaVencedores aux;

        aux = primeiro.proximo;

        while (aux != null)
        {
            if (aux.item.getMunicipio().getNome() == municipioNome)
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
    
    public Vencedores retornarItem(){
    
        CelulaVencedores aux;
        Vencedores Vencedores = null;

        aux = primeiro.proximo;

        while (aux != null)
        {		
        	Vencedores = aux.item;
            aux = aux.proximo;
            }
        return Vencedores;
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
        CelulaVencedores aux;

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
        CelulaVencedores aux;
        
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
    
    public ArrayList<Vencedores> listaVencedores(){
    	
    	ArrayList<Vencedores> listaVencedores = new ArrayList<Vencedores>();
    	
    	CelulaVencedores aux;

        aux = primeiro.proximo;

        if (aux == null)
        {
        	System.out.println("A lista de produtos está vazia.");
        }
        else 
        {
            while (aux != null)
            {
            	listaVencedores.add(aux.item);        
                aux = aux.proximo;
            }
        }    	
    	return listaVencedores;
    	
    }
}
