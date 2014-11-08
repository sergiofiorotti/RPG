package View.States;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Creditos extends BasicGameState {
	
	private static Music musica;
	
	private int state;
	
	public Creditos(int state){
		this.state = state;
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		musica = new Music("musicas/Mapa.wav");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		
		g.drawString("GALAXY DESTINY", 300, 100);
		g.drawString("Diretor de Audio                 Leonardo Biazoto",100,300);
		
		g.drawString("GALAXY DESTINY", 300, 100);
		g.drawString("Diretor de Desenvolvimento       Sergio Fiorotti",100,300);
		
		g.drawString("GALAXY DESTINY", 300, 100);
		g.drawString("Diretor de Artes                 Felippe Miguel",100,300);
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