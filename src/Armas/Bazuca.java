package Armas;

import Interfaces.IEngenheiro;
import Interfaces.IEngineer;

public class Bazuca extends ArmaFogo implements IEngenheiro, IEngineer {

	public Bazuca()
	{
		dano = 100;
		precisao = 80;
		municao = 5;
	}
}
