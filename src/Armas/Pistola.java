package Armas;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import Interfaces.IEspiao;
import Interfaces.ITanker;

public class Pistola extends ArmaFogo implements IEspiao, ITanker{

	public Pistola()throws SlickException
	{
		dano = 10;
		precisao = 70;
		municao = 40;
		
		imagem = new Image("imagens/pistola.png");
	}
}
