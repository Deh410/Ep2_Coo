package gerenciadores;

public class Local {
	private String local;
	
	public void setLocal(String local){
		this.local = local.toLowerCase();
	}
	
	public boolean checkLocal(String local){

		if(local.equals("sala de atividades")){ return true;}
		if(local.equals("quadra")){ return true;}
		
		return false;
	}
}
