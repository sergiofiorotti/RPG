package Armas;

import Interfaces.ISoldado;
import Interfaces.ISoldier;

public class Espada extends ArmaBranca implements ISoldado, ISoldier {

	public Espada()
	{
		dano = 40;
		precisao = 100;
	}
}
