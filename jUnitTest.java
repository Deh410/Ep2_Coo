package gerenciadores;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;


public class jUnitTest {

	@Test
	public void testTurma() {
		Main i = new Main();
        Mes meses = new Mes();
		Agenda agenda = new Agenda();
		Map<Integer, Mes> calendarioAno = new HashMap<Integer, Mes>();
		
		int[] diasSemana = new int[2];
        diasSemana[0] = 4;
        diasSemana[1] = 6;
        int duracao = 4;
        int hInicio = 8;
        int hFim = 10;
        int mes = 2;

		i.inicializarCalendario(meses, calendarioAno);
		Turma turma1 = new Turma();
		i.matricularTurma(agenda, calendarioAno, meses, 24, turma1, diasSemana, duracao,  hInicio, hFim, mes);
		String a = "SALA DE ATIVIDADE";
		assertEquals(8, turma1.getHorarios().gethInicio());
		assertEquals(10, turma1.getHorarios().gethFim());
		assertEquals(8, turma1.getHorarios().gethInicio());
		
		
	}
	
	@Test
	public void testTurmaEUsuario() {
		Main i = new Main();
        Mes meses = new Mes();
		Agenda agenda = new Agenda();
		Map<Integer, Mes> calendarioAno = new HashMap<Integer, Mes>();
		
		int[] diasSemana = new int[2];
        diasSemana[0] = 4;
        diasSemana[1] = 6;
        int duracao = 4;
        int hInicio = 8;
        int hFim = 10;
        int mes = 2;

		i.inicializarCalendario(meses, calendarioAno);
		Turma turma1 = new Turma();
		i.matricularTurma(agenda, calendarioAno, meses, 24, turma1, diasSemana, duracao,  hInicio, hFim, mes);
		Usuario monitor = new Usuario();
		i.matriculaAluno("Monitor", turma1, agenda, monitor);
		assertEquals("Monitor", monitor.getNome());
		assertEquals(1, monitor.getId());
		assertEquals(turma1, monitor.getTurmas().get(0));
		
		
	}
	
	@Test
	public void testConflitoTurma() {
		Main i = new Main();
        Mes meses = new Mes();
		Agenda agenda = new Agenda();
		Map<Integer, Mes> calendarioAno = new HashMap<Integer, Mes>();
		
		int[] diasSemana = new int[2];
        diasSemana[0] = 4;
        diasSemana[1] = 6;
        int duracao = 5;
        int hInicio = 8;
        int hFim = 10;
        int mes = 2;

		i.inicializarCalendario(meses, calendarioAno);
		Turma turma1 = new Turma();
		Turma turma2 = new Turma();
		Turma turma3 = new Turma();
		i.matricularTurma(agenda, calendarioAno, meses, 24, turma1, diasSemana, duracao,  hInicio, hFim, mes);
		i.matricularTurma(agenda, calendarioAno, meses, 24, turma2, diasSemana, duracao,  hInicio, hFim, mes);
		i.matricularTurma(agenda, calendarioAno, meses, 24, turma3, diasSemana, duracao,  hInicio, hFim, mes);
		//i.imprimeCalendario(mes, calendarioAno);
		assertEquals(2, calendarioAno.get(2015).fevereiro.get(24).getTurmasInscritas().size());
		
		
		
	}
	
	@Test
	public void testConflitoUsuario() {
		Main i = new Main();
        Mes meses = new Mes();
		Agenda agenda = new Agenda();
		Map<Integer, Mes> calendarioAno = new HashMap<Integer, Mes>();
		
		int[] diasSemana = new int[2];
        diasSemana[0] = 4;
        diasSemana[1] = 6;
        int duracao = 5;
        int hInicio = 8;
        int hFim = 10;
        int mes = 2;

		i.inicializarCalendario(meses, calendarioAno);
		Turma turma1 = new Turma();
		Turma turma2 = new Turma();
		
		i.matricularTurma(agenda, calendarioAno, meses, 24, turma1, diasSemana, duracao,  hInicio, hFim, mes);
		i.matricularTurma(agenda, calendarioAno, meses, 24, turma2, diasSemana, duracao,  hInicio, hFim , mes);
		Usuario Xena = new Usuario();
		i.matriculaAluno("XenaGuerreira", turma1, agenda, Xena);
		i.matriculaAluno("XenaGuerreira", turma2, agenda, Xena);
		assertEquals(1, Xena.getTurmas().size());
		
		
		
	}
	
	@Test
	public void testConflitoUsuario2() {
		Main i = new Main();
        Mes meses = new Mes();
		Agenda agenda = new Agenda();
		Map<Integer, Mes> calendarioAno = new HashMap<Integer, Mes>();
		
		int[] diasSemana = new int[2];
        diasSemana[0] = 4;
        diasSemana[1] = 6;
        int duracao = 5;
        int hInicio = 8;
        int hIni2 = 15;
        int hFim2 = 18;
        
        int hFim = 10;
        int mes = 2;

		i.inicializarCalendario(meses, calendarioAno);
		Turma turma1 = new Turma();
		Turma turma2 = new Turma();
		
		i.matricularTurma(agenda, calendarioAno, meses, 24, turma1, diasSemana, duracao,  hInicio, hFim, mes);
		i.matricularTurma(agenda, calendarioAno, meses, 24, turma2, diasSemana, duracao,  hIni2, hFim2 , mes);
		Usuario Xena = new Usuario();
		i.matriculaAluno("XenaGuerreira", turma1, agenda, Xena);
		i.matriculaAluno("XenaGuerreira", turma2, agenda, Xena);
		assertEquals(2, Xena.getTurmas().size());
		
		
		
		
		
	}
	
	@Test
	public void conflitoRankingUsuarios() {
		Main i = new Main();
        Mes meses = new Mes();
		Agenda agenda = new Agenda();
		Map<Integer, Mes> calendarioAno = new HashMap<Integer, Mes>();
		
		int[] diasSemana = new int[2];
        diasSemana[0] = 4;
        diasSemana[1] = 6;
        int duracao = 5;
        int hInicio = 8;
        int hIni2 = 15;
        int hFim2 = 18;
        
        int hFim = 10;
        int mes = 2;

		i.inicializarCalendario(meses, calendarioAno);
		Turma turma1 = new Turma();
		Turma turma2 = new Turma();
		
		i.matricularTurma(agenda, calendarioAno, meses, 24, turma1, diasSemana, duracao,  hInicio, hFim, mes);
		i.matricularTurma(agenda, calendarioAno, meses, 24, turma2, diasSemana, duracao,  hIni2, hFim2 , mes);
		Usuario Xena = new Usuario();
		i.matriculaAluno("XenaGuerreira", turma1, agenda, Xena);
		i.matriculaAluno("XenaGuerreira", turma2, agenda, Xena);
		Usuario CleberMenino = new Usuario();
		i.matriculaAluno("CleberMenino", turma1, agenda, CleberMenino);
		i.matriculaAluno("CleberMenino", turma2, agenda, CleberMenino);
		Xena.setPontuacao(69);
		CleberMenino.setPontuacao(24);
		Usuario campeao = i.achaORei(agenda.getUsuarios());
		assertEquals("XenaGuerreira", campeao.getNome());		
		
		
	}
	
	@Test
	public void conflitoRankingEquipes() {
		Main i = new Main();
        Mes meses = new Mes();
		Agenda agenda = new Agenda();
		Map<Integer, Mes> calendarioAno = new HashMap<Integer, Mes>();
		
		int[] diasSemana = new int[2];
        diasSemana[0] = 4;
        diasSemana[1] = 6;
        int duracao = 5;
        int hInicio = 8;
        int hIni2 = 15;
        int hFim2 = 18;
        
        int hFim = 10;
        int mes = 2;

		i.inicializarCalendario(meses, calendarioAno);
		Turma turma1 = new Turma();
		Turma turma2 = new Turma();
		
		i.matricularTurma(agenda, calendarioAno, meses, 24, turma1, diasSemana, duracao,  hInicio, hFim, mes);
		i.matricularTurma(agenda, calendarioAno, meses, 24, turma2, diasSemana, duracao,  hIni2, hFim2 , mes);
		Usuario Xena = new Usuario();
		i.matriculaAluno("XenaGuerreira", turma1, agenda, Xena);
		i.matriculaAluno("XenaGuerreira", turma2, agenda, Xena);
		Usuario CleberMenino = new Usuario();
		i.matriculaAluno("CleberMenino", turma1, agenda, CleberMenino);
		i.matriculaAluno("CleberMenino", turma2, agenda, CleberMenino);
		Usuario AgnaldoTimoteo = new Usuario();
		i.matriculaAluno("AgnaldoTimoteo", turma1, agenda, AgnaldoTimoteo);
		i.matriculaAluno("AgnaldoTimoteo", turma2, agenda, AgnaldoTimoteo);
		
		Equipe equipe1 = new Equipe();
		Equipe equipe2 = new Equipe();
		equipe1.adicionaIntegrante(Xena);
		equipe1.adicionaIntegrante(CleberMenino);
		equipe2.adicionaIntegrante(AgnaldoTimoteo);
		equipe1.modalidade = "Quadra";
		equipe2.modalidade = "Quadra";
		equipe1.adicionaPontuacao(69);
		equipe2.adicionaPontuacao(24);
		agenda.setEquipes(equipe1);
		agenda.setEquipes(equipe2);
		i.achaAEquipeRei(agenda.getEquipes());
		assertEquals(equipe1, i.achaAEquipeRei(agenda.getEquipes()));
		
	}
	
	
	
	

}
