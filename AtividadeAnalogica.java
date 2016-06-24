package gerenciadores;

public class AtividadeAnalogica extends Atividade{
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
			if(ok == false){
				System.out.println("Nome ja existe na lista");
			}
		}
		digital.setLocal();
		digital.setHorario();
		digital.setData();
		digital.setQtdAlunos();
		System.out.println("Nome da atividade: " + nome);
		System.out.println(digital.toString());
	}
}
