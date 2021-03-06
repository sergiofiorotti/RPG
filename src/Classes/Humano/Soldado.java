package Classes.Humano;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import Armas.Espada;
import Armas.Metralhadora;
import Armas.Sniper;
import Interfaces.IClasse;
import Interfaces.ISoldado;
import Main.Classe;

final public class Soldado extends Classe<ISoldado>{

	public Soldado() throws SlickException{
		super(150*5, 60, new Image("imagens/personagens/mohamed.png"));
		
		armas = new ISoldado[5];
		armas[0] = new Espada();
		armas[1] = new Metralhadora();
		armas[2] = new Sniper();
		
		imagem = new Image("imagens/personagens/MohamedG.png");
	}
	
	private ISoldado[] armas;
	
	@Override
	public ISoldado[] getArmas() {
		return armas;
	}

	@Override
	public void setArmas(IClasse arma, int posicao) {
		armas[posicao] = (ISoldado) arma;
	}
}
