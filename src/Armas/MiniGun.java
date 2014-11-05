package Armas;

import Interfaces.ITanker;

public class MiniGun extends ArmaFogo implements ITanker {

	public MiniGun()
	{
		dano = 20;
		precisao = 40;
		municao = 60;
	}
	
}
