package Armas;
import Interfaces.IEspiao;
import Interfaces.ITanker;

public class Faca extends ArmaBranca implements IEspiao, ITanker{

	public Faca(){
		dano = 20;
		precisao = 100;
	}
}
