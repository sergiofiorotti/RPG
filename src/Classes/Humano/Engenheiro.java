package Classes.Humano;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import Armas.Bazuca;
import Armas.C4;
import Armas.Granada;
import Armas.Mecha;
import Interfaces.IClasse;
import Interfaces.IEngenheiro;
import Main.Classe;

final public class Engenheiro extends Classe<IEngenheiro>{
	
	public Engenheiro() throws SlickException{
		super(200*5, 50, new Image("imagens/personagens/asiatico.png"));
		
		armas = new IEngenheiro[5];
		armas[0] = new Granada();
		armas[1] = new Bazuca();
		armas[2] = new C4();
		armas[3] = new Mecha();
		
		imagem = new Image("imagens/personagens/AsiaticoG.png");
	}
	
	public IEngenheiro[] armas;

	@Override
	public IEngenheiro[] getArmas() {
		return armas;
	}

	@Override
	public void setArmas(IClasse arma, int posicao) {
		armas[posicao] = (IEngenheiro) arma;
	}
}
