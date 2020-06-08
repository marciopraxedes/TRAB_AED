package br.gov.urnaeletronica.resources;

import java.io.*;

import javax.swing.JOptionPane;

import br.gov.resources.candidato.TabelaHashCandidato;
import br.gov.tre.models.Candidato;
import br.gov.tre.models.Eleitor;
import br.gov.tre.models.Municipio;
import br.gov.tre.models.PartidoPolitico;
import br.gov.tre.models.UrnaEletronica;
import br.gov.tre.resources.eleitor.TabelaHashEleitor;
import br.gov.tre.resources.municipio.ListaMunicipio;
import br.gov.tre.resources.partidopolitico.ListaPartidoPolitico;
import br.gov.tre.resources.urna.ListaUrnaEletronica;

public class ArquivoTexto {

	FileInputStream inicio;
	BufferedReader entrada;
	BufferedWriter saida;
	BufferedWriter saidaTemp;

	String nomeArquivoLocal;

	public void abrirArquivo(String nomeArquivo){	

		try {
			inicio = new FileInputStream (nomeArquivo);
			entrada = new BufferedReader(new InputStreamReader(inicio));
			saida = new BufferedWriter(new FileWriter(nomeArquivo, true));

			nomeArquivoLocal = nomeArquivo;
			System.out.println("Arquivo " + nomeArquivoLocal + " aberto");	
		}
		catch (FileNotFoundException excecao) {
			System.out.println("Arquivo n�o encontrado");
		}
		catch (IOException excecao) {
			System.out.println("Erro na abertura do arquivo de escrita: " + excecao);
		}
	}

	public void criarArquivo (String nomeArquivo) {

		try {
			nomeArquivoLocal = nomeArquivo+".txt";
			saidaTemp = new BufferedWriter(new FileWriter(nomeArquivoLocal));
			abrirArquivo(nomeArquivoLocal);			
		}
		catch (FileNotFoundException excecao) {
			System.out.println("Arquivo não encontrado");
		}
		catch (IOException excecao) {
			System.out.println("Erro na abertura do arquivo de escrita: " + excecao);
		}

	}

	public void retornarInicioArquivo() {

		// Reposiciona diretamente o ponteiro do arquivo
		try {
			inicio.getChannel().position(0);
		} catch (IOException e) {
			System.err.println(String.format("Falha reposicionar arquivo para byte 0: %s. Erro: %s", e.getMessage()));
			System.exit(0);

		}

		// Criar novo leitor
		entrada = new BufferedReader(new InputStreamReader(inicio)); 

	}

	public void fecharArquivo() {

		try {
			entrada.close();
			saida.close();
			System.out.println("Arquivo " + nomeArquivoLocal + " fechado");	
		}
		catch (IOException excecao) {
			System.out.println("Erro no fechamento do arquivo de leitura: " + excecao);	
		}
	}

	public void fecharTemp() {

		try {
			saidaTemp.close();
		}
		catch (IOException excecao) {
			System.out.println("Erro no fechamento do arquivo de leitura: " + excecao);	
		}

	}

	public int qtdDados() {

		int cont=0;
		try {

			while (entrada.readLine() != null) {
				cont++;
			}
			retornarInicioArquivo();
		}


		catch (EOFException excecao) { //Exce��o de final de arquivo.
			System.out.println("Fim de arquivo." + excecao);

		}
		catch (IOException excecao) {
			System.out.println("Erro de leitura: " + excecao);

		}
		return cont;
	}

	public TabelaHashEleitor lerDadosEleitores() {

		int cont = qtdDados();
		TabelaHashEleitor tabelaEleitor = new TabelaHashEleitor(cont);

		try {
			for (int index = 0 ; index < cont ; index++) {

				//CONVERTE CADA LINHA EM UM VETOR DE STRING
				String arrayConversor[];
				arrayConversor = entrada.readLine().replace("; ", ";").split(";");

				//ARMAZEVA E CONVERTE O VALOR DE CADA POSICAO DO VETOR EM UMA VARIAVEL
				Eleitor novoEleitor = new Eleitor();
				novoEleitor.setNome(arrayConversor[0]); 
				novoEleitor.setNumeroTitulo(Long.parseLong(arrayConversor[1]));
				novoEleitor.setMunicipio(arrayConversor[2]);
				novoEleitor.setZonaEleitoral(Integer.valueOf(arrayConversor[3]));
				novoEleitor.setSecaoEleitoral(Integer.valueOf(arrayConversor[4]));

				//INSERE UMA NOVA PESSOA. SE RETORNAR -1, PESSOA J� EXITE
				if((tabelaEleitor.inserirEleitor(novoEleitor) == -1)) {
					JOptionPane.showMessageDialog(null,"Erro ao carregar dados. \nOs dados do eleitor já foram carregados");
					break;
				}					
			}			
			retornarInicioArquivo();		

		}


		catch (EOFException excecao) { //Exce��o de final de arquivo.
			System.out.println("Fim de arquivo." + excecao);

		}
		catch (IOException excecao) {
			System.out.println("Erro de leitura: " + excecao);
		}

		catch (NumberFormatException excecao) {
			System.out.println("\nERROR - N�o � n�mero" + excecao + "\n");
		}

		return tabelaEleitor;
	}
	public TabelaHashCandidato lerDadosCandidatos() {

		int cont = qtdDados();
		TabelaHashCandidato tabelaCandidato = new TabelaHashCandidato(cont);

		try {
			for (int index = 0 ; index < cont ; index++) {

				//CONVERTE CADA LINHA EM UM VETOR DE STRING
				String arrayConversor[];
				arrayConversor = entrada.readLine().replace("; ", ";").split(";");

				//ARMAZEVA E CONVERTE O VALOR DE CADA POSICAO DO VETOR EM UMA VARIAVEL
				Candidato novoCandidato = new Candidato();
				novoCandidato.setNome(arrayConversor[0]); 
				novoCandidato.setNumero(Integer.valueOf(arrayConversor[1]));
				novoCandidato.setMunicipio(arrayConversor[2]);
				novoCandidato.setPartidoPolitico(arrayConversor[3]);
				novoCandidato.setCargo(arrayConversor[4].charAt(0));

				//INSERE UMA NOVA PESSOA. SE RETORNAR -1, PESSOA J� EXITE
				if((tabelaCandidato.inserirCandidato(novoCandidato) == -1)) {
					JOptionPane.showMessageDialog(null,"Erro ao carregar dados. \nOs dados do eleitor já foram carregados");
					break;
				}					
			}			
			retornarInicioArquivo();		

		}


		catch (EOFException excecao) { //Exce��o de final de arquivo.
			System.out.println("Fim de arquivo." + excecao);

		}
		catch (IOException excecao) {
			System.out.println("Erro de leitura: " + excecao);
		}

		catch (NumberFormatException excecao) {
			System.out.println("\nERROR - N�o � n�mero" + excecao + "\n");
		}

		return tabelaCandidato;
	}
	public ListaPartidoPolitico lerDadosPartidoPolitico() {

		int cont = qtdDados();
		ListaPartidoPolitico tabelaEleitor = new ListaPartidoPolitico();

		try {
			for (int index = 0 ; index < cont ; index++) {

				//CONVERTE CADA LINHA EM UM VETOR DE STRING
				String arrayConversor[];
				arrayConversor = entrada.readLine().split(";");

				//ARMAZEVA E CONVERTE O VALOR DE CADA POSICAO DO VETOR EM UMA VARIAVEL
				PartidoPolitico novoPartidoPolitico = new PartidoPolitico();
				novoPartidoPolitico.setNome(arrayConversor[0]); 
				novoPartidoPolitico.setSigla(arrayConversor[1]);

				//INSERE UMA NOVA PESSOA. SE RETORNAR -1, PESSOA J� EXITE
				tabelaEleitor.inserirFinal(novoPartidoPolitico);
									
			}			
			retornarInicioArquivo();		

		}


		catch (EOFException excecao) { //Exce��o de final de arquivo.
			System.out.println("Fim de arquivo." + excecao);

		}
		catch (IOException excecao) {
			System.out.println("Erro de leitura: " + excecao);
		}

		catch (NumberFormatException excecao) {
			System.out.println("\nERROR - N�o � n�mero" + excecao + "\n");
		}

		return tabelaEleitor;
	}
	public ListaMunicipio lerDadosMunicipios() {

		int cont = qtdDados();
		ListaMunicipio tabelaMunicipio = new ListaMunicipio();

		try {
			for (int index = 0 ; index < cont ; index++) {

				//CONVERTE CADA LINHA EM UM VETOR DE STRING
				String arrayConversor[];
				arrayConversor = entrada.readLine().split(";");

				//ARMAZEVA E CONVERTE O VALOR DE CADA POSICAO DO VETOR EM UMA VARIAVEL
				Municipio novoMunicipio = new Municipio();
				novoMunicipio.setNome(arrayConversor[0]); 
				novoMunicipio.setEstado(arrayConversor[1]);
				novoMunicipio.setNumeroHabitantes(Integer.parseInt(arrayConversor[2]));
				novoMunicipio.setVagasVereador(Integer.parseInt(arrayConversor[3]));

				//INSERE UM NOVO MUNICIPIO. SE RETORNAR -1, MUNICIPIO JA EXITE
				tabelaMunicipio.inserirFinal(novoMunicipio);
									
			}			
			retornarInicioArquivo();		

		}


		catch (EOFException excecao) { //Exceção  de final de arquivo.
			System.out.println("Fim de arquivo." + excecao);

		}
		catch (IOException excecao) {
			System.out.println("Erro de leitura: " + excecao);
		}

		catch (NumberFormatException excecao) {
			System.out.println("\nERROR - N�o � n�mero" + excecao + "\n");
		}

		return tabelaMunicipio;
	}
	public ListaUrnaEletronica lerDadosUrnasEletronicas() {

		int cont = qtdDados();
		ListaUrnaEletronica listaUrnaEletronica = new ListaUrnaEletronica();

		try {
			for (int index = 0 ; index < cont ; index++) {

				//CONVERTE CADA LINHA EM UM VETOR DE STRING
				String arrayConversor[];
				arrayConversor = entrada.readLine().split(";");

				//ARMAZEVA E CONVERTE O VALOR DE CADA POSICAO DO VETOR EM UMA VARIAVEL
				UrnaEletronica novaUrnaEletronica = new UrnaEletronica();
				novaUrnaEletronica.setMunicipio(arrayConversor[0]); 
				novaUrnaEletronica.setZonaEleitoral(Integer.parseInt(arrayConversor[1]));
				novaUrnaEletronica.setSecaoEleitoral(Integer.parseInt(arrayConversor[2]));

				//INSERE UMA NOVA PESSOA. SE RETORNAR -1, PESSOA J� EXITE
				listaUrnaEletronica.inserirFinal(novaUrnaEletronica);
									
			}			
			retornarInicioArquivo();		

		}


		catch (EOFException excecao) { //Exce��o de final de arquivo.
			System.out.println("Fim de arquivo." + excecao);

		}
		catch (IOException excecao) {
			System.out.println("Erro de leitura: " + excecao);
		}

		catch (NumberFormatException excecao) {
			System.out.println("\nERROR - N�o � n�mero" + excecao + "\n");
		}

		return listaUrnaEletronica;
	}
	
/*
	public void alterarEleitor (long numeroTitulo) {
		int opcao = 0;
		
		if (lerDadosEleitor().pesquisarEleitor(numeroTitulo).getNumeroTitulo() == numeroTitulo ) {

			while (opcao == 0) {
				lerDadosEleitor().pesquisarEleitor(numeroTitulo).exibirDados();
				opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Deseja alterar os dados dessa pessoa? 1 - Sim | 2 - Não "));
			}
			if (opcao == 1) {
				try {
					editarEleitor(numeroTitulo);
				} catch (IOException e) {
					System.out.println("Erro - "+e);
					e.printStackTrace();
				}			
			}
			else if (opcao == 2){
				JOptionPane.showMessageDialog(null,"Digite outro número de Titulo: ");
			}
		}

	}

	public void editarEleitor(long numeroTitulo) throws IOException {

		int cont = qtdDados();

		ArquivoTexto arquivo = new ArquivoTexto();
		arquivo.criarArquivoTemporario(nomeArquivoLocal);

		TabelaHashMunicipio tabelaEleitor = new TabelaHashMunicipio(cont);
		String arrayConversor[];

		try {

			Scanner in = new Scanner(System.in);
			if(tabelaEleitor.pesquisarEleitor(numeroTitulo) == null ) {
				System.out.println("Pessoa removidad com sucesso!");
			}

			Long identidade;
			String nome;
			char sexo;
			int idade;
			String localidade;
			String estadoCivil;
			String raca;

			String linha;

			for (int index = 0 ; index < cont ; index++) {

				//CONVERTE CADA LINHA EM UM VETOR DE STRING
				arrayConversor = entrada.readLine().split(";");

				//ARMAZEVA E CONVERTE O VALOR DE CADA POSICAO DO VETOR EM UMA VARIAVEL
				identidade = Long.parseLong(arrayConversor[0]);

				if(identidade == numeroTitulo){

					System.out.println("Digite a identidade: ");

				}

				nome = arrayConversor[1];
				sexo = arrayConversor[2].charAt(0);
				idade = Integer.valueOf(arrayConversor[3]);
				localidade = arrayConversor[4];
				estadoCivil = arrayConversor[5];
				raca = arrayConversor[6];

				linha = identidade+";"+nome+";"+sexo+";"+idade+";"+localidade+";"+estadoCivil+";"+raca;
				arquivo.escreverTemp(linha);

				//INSERE UMA NOVA PESSOA. SE RETORNAR -1, PESSOA J� EXITE
				if((tabelaEleitor.inserirEleitor(new Eleitor(identidade, nome, sexo, idade, localidade, estadoCivil, raca)) == -1)) {
					JOptionPane.showMessageDialog(null,"Erro ao inserir dados. \nOs dados do eleitor já foram cadastrados");
				}
			}
			in.close();


		}
		catch (IOException e) {
			System.out.println("Erro ao abrir arquivo - "+e);
		}

	}
*/
	public Boolean verificarEleitorDuplicado(Long identidade) {

		if (lerDadosEleitores().pesquisarEleitor(identidade) == null)
			return false;
		else
			return true;
	}

	public void inserirEleitor(Eleitor novoEleitor) {

		String dadosPessoa = null;

		try {		

			if (verificarEleitorDuplicado(novoEleitor.getNumeroTitulo()) == true) 
				System.out.println("N�o foi poss�vel inserir uma nova pessoa. Pessoa j� existe");
			else {				
				dadosPessoa = novoEleitor.getNome()+";"+novoEleitor.getNumeroTitulo()+";"+
			novoEleitor.getMunicipio()+";"+novoEleitor.getZonaEleitoral()+";"+novoEleitor.getSecaoEleitoral();
			}

			if (dadosPessoa != null) { 
				escrever(dadosPessoa);
				fecharArquivo();
				JOptionPane.showMessageDialog(null,"Eleitor cadastrado com com SUCESSO!");
				abrirArquivo(nomeArquivoLocal);
			}
		}
		catch (NullPointerException e) {
			System.out.println("Erro - " + e);
		}
	}

	public void escrever(String textoEntrada) {

		try {
			saida.write(textoEntrada);
			saida.newLine();
		}
		catch (IOException excecao){
			System.out.println("Erro de entrada/saída " + excecao);
		}
	}

}


