package View.States;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameOverState extends BasicGameState {
	
	private int state;
	private static Music musica;
	
	public GameOverState(int state){
		this.state = state;
		
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		musica = new Music("musicas/gameOver.wav");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.setColor(Color.white);
		g.drawString(". . . GAME OVER . . .", 300, 300);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int i)
			throws SlickException {
		gc.sleep(2000);
		LutaState.stopMusica();
		Jogo.reiniciar();
	}

	@Override
	public int getID() {
		return state;
	}
	
	public static void playMusica(){
		musica.play(1,1);
	}
	
	public static void stopMusica(){
		musica.stop();
	}
}
