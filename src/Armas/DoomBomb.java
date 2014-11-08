package Armas;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import Interfaces.*;

public class DoomBomb extends ArmaFogo implements IEngenheiro, IEspiao, ISoldado, IEngineer, ISoldier, ITanker {

	public DoomBomb()throws SlickException
	{
		dano = 9000;
		precisao = 100;
		municao = 1;
		
		imagem = new Image("imagens/ultraDoom.png");
	}
}
