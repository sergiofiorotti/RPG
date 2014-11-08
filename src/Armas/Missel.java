package Armas;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import Interfaces.ISoldier;

public class Missel extends ArmaFogo implements ISoldier {

	public Missel()throws SlickException
	{
		dano = 100;
		precisao = 100;
		municao = 5;
		
		imagem = new Image("imagens/missil.png");
	}
	
}
