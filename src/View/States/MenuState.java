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

public class MenuState extends BasicGameState {

	
	private Image imagemBackground;
	private Image jogar;
	private Image sair;
	
	public MenuState(int state){
			
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
		g.drawImage(jogar, 350, 100);
		g.drawImage(sair, 350, 200);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)throws SlickException {
		Input input = gc.getInput();
		int xpos = input.getMouseX();
		int ypos = input.getMouseY();
		
		if((xpos>350 && xpos<450) && (ypos>100 && ypos<150)){
			if(input.isMouseButtonDown(0))
			sbg.enterState(5, new FadeOutTransition(), new FadeInTransition());
		}
		if((xpos>350 && xpos<450) && (ypos>200 && ypos<250)){
			if(input.isMouseButtonDown(0)){
				gc.exit();
			}
		}
	}

	@Override
	public int getID() {
		return 0;
	}
}
