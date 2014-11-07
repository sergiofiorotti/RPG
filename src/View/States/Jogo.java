package View.States;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Jogo extends StateBasedGame {

	public static final String gameName = "Galaxy Destiny";
	
	public static final int menuState = 0;
	public static final int mapaState = 1;
	public static final int gameOverState = 2;
	public static final int lutaState = 3;
	public static final int menuInGameState = 4;
	public static final int personagemState = 5;
	public static final int menuLutaState = 6;
	public static final int inicio = 7;
	
	
	public Jogo(String gameName){
		super(gameName);
		this.addState(new MenuState(menuState));
		this.addState(new GameOverState(gameOverState));
		this.addState(new LutaState(lutaState));
		this.addState(new MenuInGameState(menuInGameState));
		this.addState(new PersonagemState(personagemState));
		this.addState(new MapaState(mapaState));
		this.addState(new MenuLutaState(menuLutaState));
		this.addState(new Inicio(inicio));
	}
	
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(menuState).init(gc, this);
		this.getState(mapaState).init(gc, this);
		this.getState(lutaState).init(gc, this);
		this.getState(gameOverState).init(gc, this);
		this.getState(menuInGameState).init(gc, this);
		this.getState(personagemState).init(gc, this);
		this.getState(menuLutaState).init(gc, this);
		this.getState(inicio).init(gc, this);
		this.enterState(7);
	}
	
	public static void main(String[] args)
	{
		AppGameContainer appgc;
		try
		{
			appgc= new AppGameContainer(new Jogo(gameName));
			appgc.setDisplayMode(800, 600, false);
			appgc.start();
		}
		catch (SlickException ex)
		{
			Logger.getLogger(Jogo.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}

