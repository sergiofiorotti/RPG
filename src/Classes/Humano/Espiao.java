package Classes.Humano;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import Armas.Faca;
import Armas.Fuzil;
import Armas.Pistola;
import Interfaces.IClasse;
import Interfaces.IEspiao;
import Main.Classe;

final public class Espiao extends Classe<IEspiao>{

	public Espiao() throws SlickException{
		super(100*5, 80, new Image("imagens/personagens/chrono.png"));
		
		armas = new IEspiao[5];
		armas[0] = new Faca();
		armas[1] = new Pistola();
		armas[2] = new Fuzil();
		
		imagem = new Image("imagens/personagens/ChronoG.png");
	}
	
	private IEspiao[] armas;
	
	@Override
	public IEspiao[] getArmas() {
		return armas;
	}

	@Override
	public void setArmas(IClasse arma, int posicao) {
		armas[posicao] = (IEspiao) arma;
	}
}
