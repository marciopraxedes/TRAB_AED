package br.gov.tre;

import javax.swing.JOptionPane;

import br.gov.urnaeletronica.resources.ArquivoTexto;
import br.gov.urnaeletronica.resources.TabelaHash;

public class Application {

	private static ArquivoTexto dadosPesquisa = new ArquivoTexto();
	private static TabelaHash tabelaEleitores;

	public static void main(String[] args) {

		String arquivo = JOptionPane.showInputDialog(null, "Digite o nome do 'eleitores'");	

		dadosPesquisa.abrirArquivo(arquivo+".txt");
		tabelaEleitores = dadosPesquisa.lerDadosEleitores();		

		menu();
		dadosPesquisa.fecharArquivo();

	}

	private static void menu() {

		int selecao;
		do {
			selecao = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite '1' ou '-1': "));
			switch(selecao) {
			case 1: 
				tabelaEleitores.imprimirEleitores();
				break;
			case 2:

				break;

			case 3:

				break;

			default:

				break;
			}
		}
		while(selecao != -1);




	}

}
