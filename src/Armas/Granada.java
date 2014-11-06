package Armas;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import Interfaces.IEngenheiro;
import Interfaces.IEngineer;

public class Granada extends ArmaFogo implements IEngenheiro, IEngineer {

	public Granada()throws SlickException
	{
		dano = 50;
		precisao = 50;
		municao = 5;
		imagem = new Image("imagens/granada.png");
	}
	
}
