package Armas;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import Interfaces.IEngenheiro;
import Interfaces.IEngineer;

public class Bazuca extends ArmaFogo implements IEngenheiro, IEngineer {

	public Bazuca() throws SlickException
	{
		dano = 100;
		precisao = 80;
		municao = 5;
		
		imagem = new Image("imagens/bazooka.png");
	}
}
