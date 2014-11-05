package View.States;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Jogo extends StateBasedGame {

	public Jogo(String title) {
		super(title);
	}
	
	public static void main(String[] args)
	{
		try
		{
			AppGameContainer app = new AppGameContainer(new Jogo("Galaxy Destiny"));
			app.setDisplayMode(800, 600, false);
			app.start();
		}
		catch (SlickException ex)
		{
			Logger.getLogger(Jogo.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void initStatesList(GameContainer arg0) throws SlickException {
		this.addState(new MenuState());
		this.addState(new MapaState());
		this.addState(new LutaState());
		this.addState(new GameOverState());
	}
}
