package View.States;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class Creditos extends BasicGameState {
	
	private static Music musica;
	private Image felippeNome;
	private Image felippeChar;
	
	private int state;
	
	public Creditos(int state){
		this.state = state;
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		musica = new Music("musicas/creditos.wav");
		
		felippeNome = new Image("imagens/Felippe (2).png");
		felippeChar = new Image("imagens/felippe.png");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		
		g.drawImage(felippeNome,150,170);
		g.drawImage(felippeChar, 600, 400);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int i)
			throws SlickException {
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