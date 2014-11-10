package Classes.Alienigena;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import Armas.Faca;
import Armas.MiniGun;
import Armas.Pistola;
import Interfaces.IClasse;
import Interfaces.ITanker;
import Main.Classe;

final public class Tanker extends Classe<ITanker>{

	public Tanker() throws SlickException{
		super(200*5, 60, new Image("imagens/personagens/Tanker.png"));
		
		armas = new ITanker[5];
		armas[0] = new Faca();
		armas[1] = new Pistola();
		armas[2] = new MiniGun();
		
		imagem = new Image("imagens/personagens/TankerG.png");
	}
	
	private ITanker[] armas;
	
	@Override
	public ITanker[] getArmas() {
		return armas;
	}

	@Override
	public void setArmas(IClasse arma, int posicao) {
		armas[posicao] = (ITanker) arma;
	}
}
