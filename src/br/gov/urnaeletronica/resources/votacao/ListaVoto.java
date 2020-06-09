package br.gov.urnaeletronica.resources.votacao;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.gov.urnaeletronica.models.Voto;

public class ListaVoto {

	private CelulaVoto primeiro;

	private CelulaVoto ultimo;
	
	public ListaVoto() {
		primeiro = new CelulaVoto();
		ultimo = primeiro;
	}
	// Método responsável por inserir novo voto na contagem.
	public void inserirFinal(Voto novoVoto) {
		CelulaVoto aux = new CelulaVoto();

		ultimo.proximo = aux;

		aux.item = novoVoto;

		ultimo = ultimo.proximo;
	}
	
	public int retornarIndiceItem(Voto voto) {

		CelulaVoto aux;
		aux = primeiro.proximo;
		int cont = 0;

		while (aux != null) {
			if (voto.equals(aux.item)) {
				return cont;
			}
			cont++;
			aux = aux.proximo;
		}
		return 0;
	}
	// Método responsável por atualizar a quantidade de votos de cada candidato.
	public boolean atualizarVotosCandidato(int numeroCandidato) {

		CelulaVoto aux;
		aux = primeiro.proximo;

		while (aux != null) {

			if (aux.item.getNumero() == numeroCandidato) {
				aux.item.setQuantidadeVotos(aux.item.getQuantidadeVotos() + 1);
				return true;
			}
			aux = aux.proximo;
		}
		System.out.println("Candidato não encontrato");
		return false;
	}
	// Método responsável por retornar se a lista está vazia ou não.
	public Boolean listaVazia() {
		if (primeiro == ultimo) {
			return true;
		} else {
			return false;
		}
	}
	// Método responsável por imprimir individualmente a lista de votos ou retornar uma mensagem caso esteja vazia.
	public void imprimirIndividualmente() {
		CelulaVoto aux;

		aux = primeiro.proximo;

		if (aux == null) {
			System.out.println("A lista de votos está vazia.");
		} else {
			while (aux != null) {
				aux.item.imprimirDados();
				aux = aux.proximo;
			}
		}
	}
	// Método responsável por imprimir todos os dados da lista de votos ou retornar uma mensagem caso a lista esteja vazia.
	public void imprimirTodosDados() {
		CelulaVoto aux;

		String dadosEmLinha = "";

		aux = primeiro.proximo;

		if (aux == null) {
			System.out.println("A lista de votos está vazia.");
		} else {
			while (aux != null) {
				dadosEmLinha += aux.item.retornarDadosImpressao() + "\n";
				aux = aux.proximo;
			}
		}
		JOptionPane.showMessageDialog(null, dadosEmLinha);
	}
	// Método responsável por listar as urnas ou retornar uma mensagem caso a lista de urnas esteja vazia.
	public ArrayList<Voto> listaVotos() {

		ArrayList<Voto> listaDeUrnas = new ArrayList<Voto>();

		CelulaVoto aux;

		aux = primeiro.proximo;

		if (aux == null) {
			System.out.println("A lista de urnas está vazia.");
		} else {
			while (aux != null) {
				listaDeUrnas.add(aux.item);
				aux = aux.proximo;
			}
		}

		return listaDeUrnas;

	}
}
