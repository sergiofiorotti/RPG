package Armas;

import org.newdawn.slick.Image;

public abstract class Arma {

	protected int dano;
	
	protected Image imagem;
	
	protected int precisao;

	public abstract int attack();
	
	public Image getImagem(){
		return imagem;
	}
}
