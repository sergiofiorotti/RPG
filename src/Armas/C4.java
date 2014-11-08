package Armas;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import Interfaces.IEngenheiro;
import Interfaces.IEngineer;

public class C4 extends ArmaFogo implements IEngenheiro, IEngineer {

	public C4()throws SlickException
	{
		dano = 50;
		precisao = 70;
		municao = 5;
		imagem = new Image("imagens/c4.png");
	}
}
