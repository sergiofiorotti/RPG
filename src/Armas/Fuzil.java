package Armas;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import Interfaces.IEspiao;

public class Fuzil extends ArmaFogo implements IEspiao{

	public Fuzil()throws SlickException
	{
		dano = 30;
		precisao = 70;
		municao = 30;
		
		imagem = new Image("imagens/famas.png");
	}
	
}
