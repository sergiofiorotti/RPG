package Armas;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import Interfaces.ITanker;

public class MiniGun extends ArmaFogo implements ITanker {

	public MiniGun()throws SlickException
	{
		dano = 20;
		precisao = 40;
		municao = 60;
		
		imagem = new Image("imagens/p90.png");
	}
	
}
