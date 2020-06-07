package br.gov.tre.resources.partidopolitico;

import javax.swing.JOptionPane;

import br.gov.tre.models.PartidoPolitico;

public class ListaPartidoPolitico {

	private CelulaPartidoPolitico primeiro; 
    								
	private CelulaPartidoPolitico ultimo;  


	public ListaPartidoPolitico()
	{
		primeiro = new CelulaPartidoPolitico();
		ultimo = primeiro;
	}

	public void inserirFinal(PartidoPolitico novoEleitor)
	{
		CelulaPartidoPolitico aux = new CelulaPartidoPolitico();

		ultimo.proximo = aux;

		aux.item = novoEleitor;

		ultimo = ultimo.proximo;
	}

    public PartidoPolitico retirar(String nomePartido)
    {
        CelulaPartidoPolitico aux, anterior;


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
    
    public PartidoPolitico localizar(String nomePartido)
    {
        CelulaPartidoPolitico aux;

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
    
    public PartidoPolitico retornarItem(){
    
        CelulaPartidoPolitico aux;
        PartidoPolitico eleitor = null;

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
        CelulaPartidoPolitico aux;

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
        CelulaPartidoPolitico aux;
        
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
