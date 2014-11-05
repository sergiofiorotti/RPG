package Armas;

import Interfaces.ISoldier;

public class Missel extends ArmaFogo implements ISoldier {

	public Missel()
	{
		dano = 100;
		precisao = 100;
		municao = 5;
	}
	
}
