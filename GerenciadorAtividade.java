package gerenciadores;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class GerenciadorAtividade<AtividadeFactory> {

	// metodos de Atividades
	/**
	 * Cadastra nova atividade, informando primeiro os campos que devem ser
	 * preenchidos. Deve especificar o tipo de local que ocorre. Os campos são
	 * preenchidos por meio de entrada do usuário. Se já houver atividade com o
	 * mesmo nome não realiza o cadastro e uma mensagem deve ser exibida.
	 * 
	 * @return boolean - true se a atividade foi cadastrada ; false - caso
	 *         contrário
	 */
	public Atividade atividadeGenerica;
	
	public GerenciadorAtividade(){
		this.atividadeGenerica = Atividade.tipoAtividade();
	}

	public boolean cadastrarAtividade() {
		/**
		 * TODO implementar este método seguindo a descrição acima
		 */
		menu(atividadeGenerica);
		return true;
	}

	public boolean menu(Atividade atividadeBuilder) {
		Scanner sc = new Scanner(System.in);
		String atividade = null;
		String again = null;
		boolean ok = false;
		if (atividadeBuilder == null) {
			while (ok == false) {
				System.out.println("Escolha o tipo de Atividade: ");
				System.out.println("Analogica, Digital ou Fisica");
				System.out.println("Digite a inicial: (A / D / F)");
				atividade = sc.nextLine();
				atividade = atividade.toLowerCase();
				ok = Atividade.checkTipoAtividade(atividade);
			}
			if (atividade.equals("a")) {
				atividadeBuilder = new AtividadeAnalogica();
			} else if (atividade.equals("d")) {
				atividadeBuilder = new AtividadeDigital();
			} else if (atividade.equals("f")) {
				atividadeBuilder = new AtividadeFisica();
			}
			atividadeBuilder.makeAtividade(atividadeBuilder);
		}
		/*
		ok = false;
		while (ok == false) {
			System.out.println("Deseja criar outra atividade? [S/N]");
			again = sc.nextLine();
			again = again.toLowerCase();
			if (again.equals("s"))
				return true;
			if (again.equals("n"))
				return false;
			ok = false;
		}*/
		atividadeBuilder.makeAtividade(atividadeBuilder);
		return false;
	}
	
	/**
	 * Cadastra uma lista de atividades. Se já houver uma atividade com o mesmo
	 * nome não realiza o cadastro daquela, as outras são cadastradas se não
	 * houver conflito.
	 * 
	 * @param atividades
	 *            - lista de atividades a serem cadastradas segundo sua
	 *            implementação
	 * @return boolean - true se todas as atividades forem cadastradas ; false -
	 *         caso uma ou mais atividades não tiverem sido cadastradas
	 */
	public boolean cadastrarNovasAtividade(List<String> atividades) {
		/**
		 * TODO implementar este método seguindo a descrição acima
		 */
		boolean ok = false;
		ok = atividadeGenerica.addListaAtividadeLista(atividades);

		return ok;
	}

	/***
	 * Exibe todos os campos da atividade.
	 * 
	 * @param nomeAtividade
	 *            - nome da atividade a ser visualizada
	 * 
	 */
	public void visualizarAtividade(String nomeAtividade) {
		/**
		 * TODO implementar este método seguindo a descrição acima
		 */
		if (Atividade.AtividadesConstruidas.containsKey(nomeAtividade)) {
			System.out.println(Atividade.AtividadesConstruidas
					.get(nomeAtividade));
		}
	}

	/***
	 * Exibe todos os campos da atividade.
	 * 
	 * @param id
	 *            - identificador da atividade a ser visualizada
	 * 
	 */
	public void visualizarAtividade(int id) {
		/**
		 * TODO implementar este método seguindo a descrição acima
		 */
		Iterator<Atividade> it = Atividade.AtividadesConstruidas.values()
				.iterator();
		while (it.hasNext()) {
			id--;
			Atividade atual = it.next();
			if (id == 0) {
				System.out.println(atual.toString());
				return;
			}
		}
		if (id > 0) {
			System.out.println("Não existe atividade com esse id");
		}
	}

	/**
	 * Exibe o numero total de atividades cadastradas e todos os campos de cada
	 * uma.
	 * 
	 * @return int - contendo o numero de atividades cadastradas
	 */
	public int visualizarTodasAtividades() {
		int id = 0;
		Iterator<Atividade> it = Atividade.AtividadesConstruidas.values()
				.iterator();
		while (it.hasNext()) {
			id++;
			Atividade atual = it.next();
			System.out.println(atual.toString());
		}
		return id;
		/**
		 * TODO implementar este método seguindo a descrição acima
		 */
	}

	/**
	 * Altera um ou mais campos da atividade passada como parâmetro.
	 * 
	 * @param nomeAtividade
	 *            - nome da atividade a ser editada
	 * 
	 */
	public void editarAtividade(String nomeAtividade) {
		/**
		 * TODO implementar este método seguindo a descrição acima
		 */
		int opcao = -1;
		Scanner sc = new Scanner(System.in);
		boolean ok = false;
		if (Atividade.AtividadesConstruidas.containsKey(nomeAtividade)) {
			Atividade aux = Atividade.AtividadesConstruidas.get(nomeAtividade);
			while (ok == false) {
				System.out.println("Deseja alterar qual(is) campos:");
				System.out
						.println("1.Nome\n2.Local\n3.Horario de inicio e fim");
				System.out
						.println("4.Data\n5.Quantidade de Alunos maxima\n6.Pronto!");
				opcao = sc.nextInt();
				if (opcao < 0 || opcao > 6) {
					System.out.println("Valor invalido");
					ok = false;
				}
				switch (opcao) {
				case 1:
					System.out.println("Insira o novo nome para a atividade: ");
					String novoNome = sc.nextLine();
					Atividade.AtividadesConstruidas.replace(novoNome, aux, aux);
					nomeAtividade = novoNome;
					break;
				case 2:
					aux.setLocal();
					break;
				case 3:
					aux.setHorario();
					break;
				case 4:
					aux.setData();
					break;
				case 5:
					aux.setQtdAlunos();
					break;
				case 6:
					return;
				default:
					ok = false;
				}
			}
			Atividade.AtividadesConstruidas.replace(nomeAtividade, aux, aux);
		}
	}

	/**
	 * Exibe todos os campos da atividade passado como parâmetro e altera um ou
	 * mais campos. Os campos são preenchidos por meio de entrada do usuário.
	 * 
	 * @param id
	 *            - identificador da atividade a ser editada
	 * 
	 */
	public void editarAtividade(int id) {
		/**
		 * TODO implementar este método seguindo a descrição acima
		 */
		Iterator<Atividade> it = Atividade.AtividadesConstruidas.values()
				.iterator();
		while (it.hasNext()) {
			id--;
			if (id == 0) {
				Atividade atual = it.next();
				Atividade aux = Atividade.AtividadesConstruidas.get(atual);
				editarAtividade(aux.getName());
			}
		}
		if (id != 0) {
			System.out.println("Nao existe atividade com esse id");
		}
	}

	/**
	 * Exibe todos os campos da atividade e exige confirmação para realizar a
	 * remoção. confirmação é realizada por entrada do usuário.
	 * 
	 * @param nomeAtividade
	 *            - nome atividade a ser removida
	 * @return true - se confirma remoção; false - se cancela remoção
	 */
	public void removerAtividade(String nomeAtividade) {
		/**
		 * TODO implementar este método seguindo a descrição acima
		 */
		String opcao = null;
		Scanner sc = new Scanner(System.in);
		boolean ok = false;
		if (Atividade.AtividadesConstruidas.containsKey(nomeAtividade)) {
			while (ok == false) {
			System.out.println("Tem certeza que deseja remover? [S/N]");
				opcao = sc.nextLine();
				opcao = opcao.toLowerCase();
				if (opcao.equals("s"))
					Atividade.AtividadesConstruidas.remove(nomeAtividade);
				System.out.println("Atividade " + nomeAtividade
						+ " removida com sucesso");
				if (opcao.equals("n"))
					return;
				System.out.println("Opcao invalida");
			}
		}
	}

	/**
	 * Exibe todos os campos da atividade e exige confirmação para realizar a
	 * remoção. confirmação é realizada por entrada do usuário.
	 * 
	 * @param id
	 *            - identificador da atividade a ser removida
	 * @return true - se confirma remoção; false - se cancela remoção
	 */
	public void removerAtividade(int id) {
		/**
		 * TODO implementar este método seguindo a descrição acima
		 */
		Iterator<Atividade> it = Atividade.AtividadesConstruidas.values()
				.iterator();
		while (it.hasNext()) {
			id--;
			if (id == 0) {
				Atividade atual = it.next();
				Atividade aux = Atividade.AtividadesConstruidas.get(atual);
				removerAtividade(aux.getName());
			}
		}
		if (id != 0) {
			System.out.println("Nao existe atividade com esse id");
		}
	}

}