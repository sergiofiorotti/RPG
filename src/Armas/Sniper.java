package Armas;

import Interfaces.ISoldado;

public class Sniper extends ArmaFogo implements ISoldado{

	public Sniper()
	{
		dano = 80;
		precisao = 100;
		municao = 10;
	}
	
}
