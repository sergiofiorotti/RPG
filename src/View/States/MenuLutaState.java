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

public class MenuLutaState extends BasicGameState {

	
	private Image imagemBackground;
	private Image jogar;
	private Image sair;
	private int state;
	
	public MenuLutaState(int state){
		this.state = state;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		imagemBackground = new Image("imagens/menuBackground.png");
		jogar = new Image("imagens/jogar.png");
		sair = new Image("imagens/sair.png");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException{
		g.drawImage(imagemBackground, 0, 0);
		g.drawImage(jogar, 173, 150);
		g.drawImage(sair, 218, 350);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)throws SlickException {
		Input input = gc.getInput();
		int xpos = input.getMouseX();
		int ypos = input.getMouseY();
		
		if((xpos>173 && xpos<628) && (ypos>150 && ypos<267)){
			if(input.isMouseButtonDown(0))
			sbg.enterState(Jogo.lutaState, new FadeOutTransition(), new FadeInTransition());
		}
		if((xpos>218 && xpos<573) && (ypos>350 && ypos<458)){
			if(input.isMouseButtonDown(0)){
				gc.exit();
			}
		}
	}

	@Override
	public int getID() {
		return state;
	}
}

