package Armas;

import Interfaces.IEngenheiro;
import Interfaces.IEngineer;

public class Granada extends ArmaFogo implements IEngenheiro, IEngineer {

	public Granada()
	{
		dano = 50;
		precisao = 50;
		municao = 5;
	}
	
}
