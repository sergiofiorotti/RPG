package Armas;

import java.util.Random;

public class ArmaFogo extends Arma {

	protected int municao;
	
	public int getMunicao(){
		return municao;
	}
	
	public void subMunicao(){
		if (municao > 0)
			this.municao--;
	}
	
	public void addMunicao(int municao){
		this.municao += municao;
	}
	
	public int attack(){
		int precisao = new Random().nextInt(100);
		
		if (getMunicao() > 0)
			subMunicao();
		else
			return 0;
		
		if (precisao <= this.precisao)
			return dano;
		return 0;
	}
}
