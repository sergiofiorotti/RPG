package Armas;
import Interfaces.IEspiao;

public class Fuzil extends ArmaFogo implements IEspiao{

	public Fuzil()
	{
		dano = 30;
		precisao = 70;
		municao = 30;
	}
	
}
