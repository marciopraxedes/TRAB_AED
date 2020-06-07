package br.gov.tre.resources.municipio;

import javax.swing.JOptionPane;

import br.gov.tre.models.Municipio;

public class ListaMunicipio {

	private CelulaMunicipio primeiro; 
    								
	private CelulaMunicipio ultimo;  


	public ListaMunicipio()
	{
		primeiro = new CelulaMunicipio();
		ultimo = primeiro;
	}

	public void inserirFinal(Municipio novoEleitor)
	{
		CelulaMunicipio aux = new CelulaMunicipio();

		ultimo.proximo = aux;

		aux.item = novoEleitor;

		ultimo = ultimo.proximo;
	}

    public Municipio retirar(String nomePartido)
    {
        CelulaMunicipio aux, anterior;


        anterior = primeiro;


        aux = primeiro.proximo;


        while (aux != null)
        {

            if (aux.item.getNome() == nomePartido)
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
    
    public Municipio localizar(String nomePartido)
    {
        CelulaMunicipio aux;

        aux = primeiro.proximo;

        while (aux != null)
        {
            if (aux.item.getNome() == nomePartido)
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
    
    public Municipio retornarItem(){
    
        CelulaMunicipio aux;
        Municipio eleitor = null;

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

    public void imprimirIndividualmente()
    {
        CelulaMunicipio aux;

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
    
    public void imprimirTodosDados()
    {
        CelulaMunicipio aux;
        
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
        JOptionPane.showMessageDialog(null, dadosEmLinha);
    }    

    
}
