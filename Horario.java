package gerenciadores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Calendar;

public class Horario {

	private int hInicio;

	private int hFim;

	private String salaDeAtividade;

	public int gethInicio() {
		return hInicio;
	}

	public void sethInicio(int hInicio) {
		this.hInicio = hInicio;
	}

	public int gethFim() {
		return hFim;
	}

	public boolean checkHora(int hora) {
		if (hora > 22 || hora < 8) {
			System.out.println("Insira um horario entre 8h e 22h");
			return false;
		}
		return true;
	}

	public boolean checkduracao(int hInicio, int hFim) {
		int duracao = hFim - hInicio;
		if (duracao > 2) {
			System.out.println("Duracao deve ser menor que 2 horas");
			return false;
		}
		return true;
	}
	
	public void sethFim(int hFim) {
		this.hFim = hFim;
	}

	public String getSalaDeAtividade() {
		return salaDeAtividade;
	}

	public void setSalaDeAtividade(String salaDeAtividade) {
		this.salaDeAtividade = salaDeAtividade;
	}

}
