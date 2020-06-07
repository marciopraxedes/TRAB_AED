package br.gov.resources.candidato;

import br.gov.tre.models.Candidato;

public class ListaCandidato {
	
	private CelulaCandidato primeiro; 	
	private CelulaCandidato ultimo;  


	public ListaCandidato()
	{
		primeiro = new CelulaCandidato();
		ultimo = primeiro;
	}
	
	public void inserirFinal(Candidato novoCandidato)
	{
		CelulaCandidato aux = new CelulaCandidato();

		ultimo.proximo = aux;

		aux.item = novoCandidato;

		ultimo = ultimo.proximo;
	}

    public Candidato retirar(long numeroTitulo)
    {
        CelulaCandidato aux, anterior;


        anterior = primeiro;


        aux = primeiro.proximo;


        while (aux != null)
        {

            if (aux.item.getNumero() == numeroTitulo)
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
    

    public Candidato localizar(long numeroTitulo)
    {
        CelulaCandidato aux;

        aux = primeiro.proximo;

        while (aux != null)
        {
            if (aux.item.getNumero() == numeroTitulo)
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
    
    public Candidato retornarItem(){
    
        CelulaCandidato aux;
        Candidato Candidato = null;

        aux = primeiro.proximo;

        while (aux != null)
        {		
        	Candidato = aux.item;
            aux = aux.proximo;
            }
        return Candidato;
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
        CelulaCandidato aux;

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
        CelulaCandidato aux;
        
        String dadosEmLinha = "";

        aux = primeiro.proximo;

        if (aux == null)
        {
            System.out.println("A lista de produtos est� vazia.");
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
}
