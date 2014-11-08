package Armas;

import java.util.Random;

public class ArmaBranca extends Arma {
	
	public int attack(){
		int precisao = new Random().nextInt(100);
		if (precisao <= this.precisao)
			return dano;
		return 0;
	}
}
