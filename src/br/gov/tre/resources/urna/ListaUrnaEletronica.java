package br.gov.tre.resources.urna;

import java.util.ArrayList;

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

    public int retornarIndiceItem(UrnaEletronica urna){
    
        CelulaUrnaEletronica aux;
        aux = primeiro.proximo;
        int cont = 0;

        while (aux != null)
        {	
        	if( urna.equals(aux.item)) {
        		return cont;
        	}
        	cont ++;
            aux = aux.proximo;
            }
        return 0;
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
        	System.out.println("A lista de urnas está vazia.");
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
    
    public ArrayList<UrnaEletronica> listaDeUrnas(){
    	
    	ArrayList<UrnaEletronica> listaDeUrnas = new ArrayList<>();
    	
    	CelulaUrnaEletronica aux;

        aux = primeiro.proximo;

        if (aux == null)
        {
        	System.out.println("A lista de urnas está vazia.");
        }
        else
        {
            while (aux != null)
            {
            	listaDeUrnas.add(aux.item);        
                aux = aux.proximo;
            }
        }
    	
    	return listaDeUrnas;
    	
    }
    
}
