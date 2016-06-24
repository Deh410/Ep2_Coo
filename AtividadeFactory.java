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
	public String getLocal();
	
	public String toString();
	
	public void setHorario();
	public int getHorarioInicio();
	public int getHorarioFim();
	
	public void setData();
	public int getDataDia();
	public int getDataMes();
	
	public void setQtdAlunos();
	public int getQtdAlunos();
	
	public void makeAtivGeral();
}
