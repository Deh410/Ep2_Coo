package gerenciadores;

public class AtividadeDigital extends Digital {
	private String nome;
	
	public AtividadeDigital(){
		
	}
	@Override
	public void makeAtividade(Atividade atividade) {
		boolean ok = false;
		while (ok == false) {
			System.out.println("Insira o nome da atividade");
			this.nome = super.sc.next();
			super.setNome(this.nome.toLowerCase());
			ok = super.addAtividadeLista();
			if (ok == false) {
				System.out.println("Nome ja existe na lista");
			}
		}
		super.setName(this.nome.toLowerCase());
		super.setData();
		super.setLocal();
		super.setQtdAlunos();
		ok = false;
		while (ok == false) {
			super.setHorario();
			ok = Digital.checkConflito((Digital)atividade);
			if(ok == false){
				System.out.println("Conflito no horario, insira outro");
			}
		}
		super.addAtividadeConstruida(this.nome, atividade);
		System.out.println("Nome da atividade: " + nome);
		System.out.println(super.toString());
		super.addToAtividade();
	}
	@Override
	public void makeAtividade() {
		// TODO Auto-generated method stub
		
	}
}
