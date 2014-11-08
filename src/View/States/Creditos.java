package View.States;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Creditos extends BasicGameState {
	
	public Creditos(int state){
		
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		
		g.drawString("GALAXY DESTINY", 300, 100);
		g.drawString("Diretor de áudio                 Leonardo Biazoto",100,300);
		gc.sleep(10000);
		g.drawString("GALAXY DESTINY", 300, 100);
		g.drawString("Diretor de Desenvolvimento       Sergio Fiorotti",100,300);
		gc.sleep(10000);
		g.drawString("GALAXY DESTINY", 300, 100);
		g.drawString("Diretor de Artes                 Felippe Miguel",100,300);
		gc.sleep(10000);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int i)
			throws SlickException {
		
		
	}

	@Override
	public int getID() {
		return 8;
	}
	
	public void esperar(int i){
		try {
		    Thread.sleep(i);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		
	}
}