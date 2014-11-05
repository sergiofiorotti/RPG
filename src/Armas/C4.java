package Armas;

import Interfaces.IEngenheiro;
import Interfaces.IEngineer;

public class C4 extends ArmaFogo implements IEngenheiro, IEngineer {

	public C4()
	{
		dano = 50;
		precisao = 70;
		municao = 5;
	}
}
