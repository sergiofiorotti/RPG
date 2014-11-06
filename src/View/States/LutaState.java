package View.States;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import Main.Classe;

public class LutaState extends BasicGameState {

	private Classe <?> player;
	private Classe <?> enemy;
	private Animation sprite;
	
	private Image imagemBackground;
	
	public LutaState(int state){
		
	}
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		
		imagemBackground = new Image("imagens/menuBackground.png");
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		
		g.drawImage(imagemBackground, 0, 0);
		
		
		player = PersonagemState.getClasse();
		
		g.drawImage(player.getImagem(), 50, 200);
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		
	}

	@Override
	public int getID() {
		return 3;
	}

}
