package Armas;

import Interfaces.IEngenheiro;
import Interfaces.IEngineer;

public class Mecha extends ArmaFogo implements IEngenheiro, IEngineer{

	public Mecha()
	{
		dano = 40;
		precisao = 60;
		municao = 5;
	}
}
