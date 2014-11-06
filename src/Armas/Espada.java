package Armas;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import Interfaces.ISoldado;
import Interfaces.ISoldier;

public class Espada extends ArmaBranca implements ISoldado, ISoldier {

	public Espada()throws SlickException
	{
		dano = 40;
		precisao = 100;
		imagem = new Image("imagens/espada.png");
	}
}
