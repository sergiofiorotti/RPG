package Armas;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import Interfaces.IEspiao;
import Interfaces.ITanker;

public class Faca extends ArmaBranca implements IEspiao, ITanker{

	public Faca()throws SlickException
	{
		dano = 20;
		precisao = 100;
		
		imagem = new Image("imagens/faca.png");
	}
}
