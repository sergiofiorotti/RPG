package Armas;

import Interfaces.ISoldado;
import Interfaces.ISoldier;

public class Metralhadora extends ArmaFogo implements ISoldado, ISoldier {

	public Metralhadora()
	{
		dano = 20;
		precisao = 60;
		municao = 50;
	}
	
}
