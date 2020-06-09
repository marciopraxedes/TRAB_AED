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

	public Boolean listaVazia() {
		if (primeiro == ultimo) {
			return true;
		} else {
			return false;
		}
	}

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
