package View.States;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class Inicio extends BasicGameState {
	
	private Image imagemBackground;
	private Image galaxyDestiny;
	private static Music musica;
	private int state;
	
	public Inicio(int state){
		this.state = state;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		imagemBackground = new Image("imagens/menuBackground.png");
		galaxyDestiny = new Image("imagens/galaxy.png");
		musica = new Music("musicas/Menu.wav");
		musica.play(1, 1);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException{
		g.drawImage(imagemBackground, 0, 0);
		g.drawImage(galaxyDestiny,90,150);
		
		g.drawString("PRESSIONE ENTER",320,400);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)throws SlickException {
		Input input = gc.getInput();
		if(input.isKeyDown(Input.KEY_ENTER)){
			sbg.enterState(0, new FadeOutTransition(), new FadeInTransition());
		}
		
	}

	@Override
	public int getID() {
		return state;
	}
	
	public static void stopMucica(){
		musica.stop();
	}
}
