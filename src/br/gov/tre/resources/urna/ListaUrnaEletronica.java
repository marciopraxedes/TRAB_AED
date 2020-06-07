package br.gov.tre.resources.urna;

import javax.swing.JOptionPane;

import br.gov.tre.models.UrnaEletronica;


public class ListaUrnaEletronica {
	
	private CelulaUrnaEletronica primeiro; 
	
	private CelulaUrnaEletronica ultimo;  


	public ListaUrnaEletronica()
	{
		primeiro = new CelulaUrnaEletronica();
		ultimo = primeiro;
	}

	public void inserirFinal(UrnaEletronica novaUrnaEletronica)
	{
		CelulaUrnaEletronica aux = new CelulaUrnaEletronica();

		ultimo.proximo = aux;

		aux.item = novaUrnaEletronica;

		ultimo = ultimo.proximo;
	}
/*
    public UrnaEletronica retirar(String urnaEletronica)
    {
    	CelulaUrnaEletronica aux, anterior;


        anterior = primeiro;


        aux = primeiro.proximo;


        while (aux != null)
        {

            if (aux.item.getNome() == urnaEletronica)
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
    */
    public UrnaEletronica retornarItem(){
    
        CelulaUrnaEletronica aux;
        UrnaEletronica urnaEletronica = null;

        aux = primeiro.proximo;

        while (aux != null)
        {		
        	urnaEletronica = aux.item;
            aux = aux.proximo;
            }
        return urnaEletronica;
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
        CelulaUrnaEletronica aux;

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
        CelulaUrnaEletronica aux;
        
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
