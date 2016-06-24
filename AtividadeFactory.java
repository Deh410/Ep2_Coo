package gerenciadores;

/* Factory para atividades "cabeça" -> Digitais, Analogicas e Fisicos
 * As atividades "cabeça" implementam a interface Factory
 * as atividades "cabeça" usam o método makeAtivGeral() para dar new nas atividades "especificas"
 * as atividades "especificas" extendem a classe abstrata atividade
 * as atividades "especificas" usam o método makeAtividade para deixar o usuario settar nomes, datas, horarios etc.
 * A classe GerenciadorAtividade mantem uma lista com todas as atividades e nao permite a criacao de atividades repetidas
 * */


public interface AtividadeFactory {
	public void setLocal();
	public String toString();
	public void setHorario();
	public void setData();
	public void setQtdAlunos();
	public void makeAtivGeral();
}
