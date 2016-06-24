package gerenciadores;

import java.util.Scanner;

public class Analogica implements AtividadeFactory {

	private String local;
	private int horarioInicio;
	private int horarioTermino;
	private int dataDia;
	private int dataMes;
	private int qtdAlunos;
	Scanner sc = new Scanner(System.in);

	public void setLocal() {
		boolean ok = false;
		Local l = new Local();
		while (ok == false) {
			System.out.println("\nNome do Local: ");
			String local = sc.nextLine();
			ok = l.checkLocal(local.toLowerCase());
			if (ok == true) {
				l.setLocal(local);
				this.local = local.toLowerCase();
			} else {
				System.out.println("Tente novamente");
				System.out.println("Sala de atividades ou quadra");
			}
		}
	}

	public void setHorario() {
		Horario h = new Horario();
		boolean ok = false;
		int horarioInicio = -1;
		int horarioTermino = -1;
		while (ok == false) {
			System.out
					.println("\nInsira os horarios de inicio e termino (maximo 2 horas)");
			System.out.println("Horario de Inicio: ");
			horarioInicio = sc.nextInt();
			ok = h.checkHora(horarioInicio);
			if (ok == true) {
				this.horarioInicio = horarioInicio;
				ok = false;
				while (ok == false) {
					System.out.println("Horario de Termino: ");
					horarioTermino = sc.nextInt();
					ok = h.checkHora(horarioTermino);
					ok = false;
					ok = h.checkduracao(horarioInicio,horarioTermino);
				}
				this.horarioTermino = horarioTermino;
			}
		}
	}

	public void setData() {
		int dataMes = -1;
		int dataDia = -1;
		boolean ok = false;
		Mes m = new Mes();
		DiaDe d = new DiaDe();
		while (ok == false) {
			System.out.println("\nInsira o mes: ");
			dataMes = sc.nextInt();
			ok = m.checkMes(dataMes);
		}
		ok = false;
		this.dataMes = dataMes;
		while (ok == false) {
			System.out.println("Insira o dia: ");
			dataDia = sc.nextInt();
			ok = d.checkDia(dataMes, dataDia);
		}/* metodo para checar data */
		this.dataDia = dataDia;
	}

	public void setQtdAlunos() {
		System.out.println("Quantidade maxima de alunos: ");
		this.qtdAlunos = sc.nextInt();
	}

	public String toString() {
		return "Local: " + local + "\nData: " + dataDia + "/" + dataMes
				+ "\nHorario: " + horarioInicio + "-" + horarioTermino
				+ "\nQuantidade de Alunos maxima: " + qtdAlunos;
	}

	public void makeAtivGeral() {
		AtividadeDigital digital = new AtividadeDigital();
		digital.makeAtividade();
	}

}
