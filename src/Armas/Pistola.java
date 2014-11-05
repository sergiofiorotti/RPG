package Armas;
import Interfaces.IEspiao;
import Interfaces.ITanker;

public class Pistola extends ArmaFogo implements IEspiao, ITanker{

	public Pistola()
	{
		dano = 10;
		precisao = 70;
		municao = 40;
	}
}
