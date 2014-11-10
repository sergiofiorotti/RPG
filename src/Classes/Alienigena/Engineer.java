package Classes.Alienigena;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import Armas.Bazuca;
import Armas.C4;
import Armas.Granada;
import Armas.Mecha;
import Interfaces.IClasse;
import Interfaces.IEngineer;
import Main.Classe;

final public class Engineer extends Classe<IEngineer>{

	public Engineer() throws SlickException {
		super(100*5, 80, new Image("imagens/personagens/Engineer.png"));
		
		armas = new IEngineer[5];
		armas[0] = new Granada();
		armas[1] = new Bazuca();
		armas[2] = new C4();
		armas[3] = new Mecha();
		
		imagem = new Image("imagens/personagens/EngineerG.png");
	}

	private IEngineer[] armas;
	
	@Override
	public IEngineer[] getArmas() {
		return armas;
	}

	public void setArmas(IClasse arma, int posicao) {
		armas[posicao] = (IEngineer) arma;
	}
}
