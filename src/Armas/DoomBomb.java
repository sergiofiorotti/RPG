package Armas;

import Interfaces.*;

public class DoomBomb extends ArmaFogo implements IEngenheiro, ISoldado, IEspiao, IEngineer, ISoldier, ITanker {

	public DoomBomb()
	{
		dano = 9000;
		precisao = 100;
		municao = 1;
	}
}
