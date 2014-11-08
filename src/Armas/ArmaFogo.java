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
		if (precisao <= this.precisao && getMunicao() > 0){
			subMunicao();
			return dano;
		}
		return 0;
	}
}
