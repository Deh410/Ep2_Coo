package gerenciadores;

public class AtividadeDigital extends Atividade {
	private String nome;

	@Override
	public void makeAtividade() {
		boolean ok = false;
		Digital digital = new Digital();
		while (ok == false) {
			System.out.println("Insira o nome da atividade");
			this.nome = digital.sc.nextLine();
			super.setName(this.nome.toLowerCase());
			ok = super.addAtividadeLista();
			if (ok == false) {
				System.out.println("Nome ja existe na lista");
			}
		}

		digital.setData();
		digital.setLocal();
		digital.setQtdAlunos();
		ok = false;
		while (ok == false) {
			digital.setHorario();
			super.addAtividadeConstruida(this.nome, digital);
			ok = super.checkConflito(digital);
			if(ok == false){
				System.out.println("Conflito no horario, insira outro");
			}
		}
		System.out.println("Nome da atividade: " + nome);
		System.out.println(digital.toString());
	}

}
