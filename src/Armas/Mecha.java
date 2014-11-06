package Armas;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import Interfaces.IEngenheiro;
import Interfaces.IEngineer;

public class Mecha extends ArmaFogo implements IEngenheiro, IEngineer{

	public Mecha()throws SlickException
	{
		dano = 40;
		precisao = 60;
		municao = 5;
		
		imagem = new Image("imagens/mecha.png");
	}
}
