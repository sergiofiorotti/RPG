package Armas;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import Interfaces.ISoldado;

public class Sniper extends ArmaFogo implements ISoldado{

	public Sniper()throws SlickException
	
	{
		dano = 80;
		precisao = 100;
		municao = 10;
		imagem = new Image("imagens/sniper.png");
	}
	
}
