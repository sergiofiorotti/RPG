package Main;

import org.newdawn.slick.Image;

import View.States.Animacao;
import Armas.Arma;

public abstract class Classe<T>{
	
	public Classe(int hp, int forca, Image personagem)
	{
		this.hp = hp;
		this.forca = forca;
		this.animacao = new Animacao(personagem);
	}
	
	protected int hp;
	
	protected int forca;
	
	protected Animacao animacao;
	
	public Animacao getAnimacao(){
		return animacao;
	}

	public void subHp(int attack){
		hp -= attack;
		if (hp < 0)
			hp = 0;
	}
	
	public void addHp(int hp){
		this.hp += hp;
	}
	
	public Boolean isLife(){
		if(hp > 0) 
			return true;
		return false;
	}

	public abstract T[] getArmas();
	
	public int attack(Arma arma) {
		if (arma.attack() > 0)
			return arma.attack() + forca;
		return 0;
	}
}
