package gerenciadores;

public class DiaDe {
	public boolean checkDia(int mes, int dia){
		switch(mes){
		case 2:
			if(dia<1 || dia > 29){
				System.out.println("Insira um dia entre 1 e 29");
				return false;
			}
			break;
		case 1: case 3:case 5:case 7:case 8:case 10:case 12:
			if(dia<1 || dia > 31){
				System.out.println("Insira um dia entre 1 e 31");
				return false;
			}
			break;
		default:
			if(dia<1 || dia > 30){
				System.out.println("Insira um dia entre 1 e 30");
				return false;
			}
		}
		return true;
	}
}
