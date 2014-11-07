package View.States;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import Interfaces.IClasse;
import Main.Classe;
import Armas.Arma;


public class LutaState extends BasicGameState {

	private Classe <?> player;
	private Classe <?> enemy;
	private Image imagemBackground;
	private IClasse[] listaArmas;
	
	public LutaState(int state){
	}
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)throws SlickException {
		
		imagemBackground = new Image("imagens/lutaBackground.png");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException {
		
		g.drawImage(imagemBackground, 0, 0);
		
		player = PersonagemState.getClasse();
		g.drawImage(player.getImagem(), 50, 200);
		enemy = MapaState.getEnemy();
		g.drawImage(enemy.getImagem(), 500, 200);
		
		
		listaArmas = (IClasse[]) player.getArmas();
		
		g.drawImage( ((Arma)listaArmas[0]).getImagem(),20, 500);
		g.drawImage( ((Arma)listaArmas[1]).getImagem(),140, 500);
		g.drawImage( ((Arma)listaArmas[2]).getImagem(),260, 500);

		g.drawString("VIDA = "+player.getHp(),50, 100);
		g.drawString("VIDA = "+enemy.getHp(),500, 100);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int i)throws SlickException {
		Input input = gc.getInput();
		if(input.isKeyDown(Input.KEY_ESCAPE)){
			sbg.enterState(6, new FadeOutTransition(), new FadeInTransition());
		}
		
	}

	@Override
	public int getID() {
		return 3;
	}

}
