package Armas;

import org.newdawn.slick.Image;
import Interfaces.IClasse;

public abstract class Arma implements IClasse {

	protected int dano;
	
	protected Image imagem;
	
	protected int precisao;

	public abstract int attack();
	
	public Image getImagem(){
		return imagem;
	}
}
