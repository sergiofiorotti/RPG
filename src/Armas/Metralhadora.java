package Armas;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import Interfaces.ISoldado;
import Interfaces.ISoldier;

public class Metralhadora extends ArmaFogo implements ISoldado, ISoldier {

	public Metralhadora()throws SlickException
	{
		dano = 20;
		precisao = 60;
		municao = 50;
		
		imagem = new Image("imagens/metralhadora.png");
	}
	
}
