package View.States;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameOverState extends BasicGameState {
	
	private int state;
	private static Music musica;
	private Image imagem;
	
	public GameOverState(int state){
		this.state = state;
		
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		musica = new Music("musicas/gameOver.wav");
		imagem = new Image("imagens/GAME (1).png");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.setColor(Color.white);
		g.drawImage(imagem, 191, 208);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int i)
			throws SlickException {
		gc.sleep(8000);
		LutaState.stopMusica();
		gc.exit();
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
