package Classes.Alienigena;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import Armas.Espada;
import Armas.Metralhadora;
import Armas.Missel;
import Interfaces.IClasse;
import Interfaces.ISoldier;
import Main.Classe;

final public class Soldier extends Classe<ISoldier>{

	public Soldier() throws SlickException{
		super(150, 50, new Image("imagens/personagens/Soldier.png"));
		
		armas = new ISoldier[5];
		armas[0] = new Espada();
		armas[1] = new Metralhadora();
		armas[2] = new Missel();
		
		
		imagem = new Image("imagens/personagens/SoldierG.png");
	}
	
	public ISoldier[] armas;
	
	@Override
	public ISoldier[] getArmas() {
		return armas;
	}

	@Override
	public void setArmas(IClasse arma, int posicao) {
		armas[posicao] = (ISoldier) arma;
	}
}
