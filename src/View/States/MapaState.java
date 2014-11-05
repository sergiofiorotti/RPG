package View.States;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import Classes.Humano.Engenheiro;
import Main.Classe;
import View.Items.Bloqueado;
import View.Items.Mapa;

public class MapaState extends BasicGameState {

	// Mapa
	private Mapa map;
	private Bloqueado bloqueado;

	// Personagem
	private Classe<?> classe;
	private Animation sprite;
	private float x = 20f, y = 20f;

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		map = new Mapa();
		bloqueado = new Bloqueado(map);

		classe = new Engenheiro();
		sprite = classe.getAnimacao().Right();
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int i)
			throws SlickException {
		Input input = gc.getInput();
		if(input.isKeyDown(Input.KEY_UP))
		{
			sprite = classe.getAnimacao().Up();
			if (y - (i * 0.1f) > 0 && !bloqueado.isBloqueado(x, y - (i * 0.1f))){
				sprite.update(i);
				y -= i * 0.1f;
			}
		}
		else if(input.isKeyDown(Input.KEY_DOWN))
		{
			sprite = classe.getAnimacao().Down();
			if (y + (i * 0.1f) < 600 && !bloqueado.isBloqueado(x, y + (i * 0.1f))){
				sprite.update(i);
				y += i * 0.1f;
			}
		}
		else if(input.isKeyDown(Input.KEY_LEFT))
		{
			sprite = classe.getAnimacao().Left();
			if (x - (i * 0.1f) > 0 && !bloqueado.isBloqueado(x - (i * 0.1f), y)){
				sprite.update(i);
				x -= i * 0.1f;
			}
		}
		else if(input.isKeyDown(Input.KEY_RIGHT))
		{
			sprite = classe.getAnimacao().Right();
			if (x + (i * 0.1f) < 800 && !bloqueado.isBloqueado(x + (i * 0.1f), y)){
				sprite.update(i);
				x += i * 0.1f;
			}
		}
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		map.getMap().render(0, 0);
		sprite.draw((int)x, (int)y);
	}

	@Override
	public int getID() {
		return 1;
	}
}
