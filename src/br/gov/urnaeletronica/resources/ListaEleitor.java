package br.gov.urnaeletronica.resources;

import br.gov.tre.models.Eleitor;

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

    public void imprimir()
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
                aux.item.exibirDados();                
                aux = aux.proximo;
            }
        }
    }    

    
}
