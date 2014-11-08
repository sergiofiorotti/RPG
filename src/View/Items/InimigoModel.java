package View.Items;

import Main.Classe;

public class InimigoModel {

	int x;
	int y;
	Classe<?> classe;
	
	public InimigoModel(int x, int y, Classe<?> classe){
		this.x = x;
		this.y = y;
		this.classe = classe;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public Classe<?> getClasse(){
		return classe;
	}
}
