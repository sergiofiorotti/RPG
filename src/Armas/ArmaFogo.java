package Armas;

import java.util.Random;

public class ArmaFogo extends Arma {

	protected int municao;
	
	public void subMunicao(){
		this.municao--;
	}
	
	public int attack(){
		int precisao = new Random().nextInt(100);
		subMunicao();
		if (precisao <= this.precisao)
			return dano;
		return 0;
	}
}
