package View.States;
import org.newdawn.slick.Animation;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import Classes.Humano.Engenheiro;
import Main.Classe;
import View.Items.Bau;
import View.Items.Bloqueado;
import View.Items.Mapa;

public class Teste extends BasicGame{

	// Mapa
	private Mapa map;
	private Bloqueado bloqueado;
	private Bau bau;
	
	// Personagem
	private Classe<?> classe;
	private Animation sprite;
	private float x = 20f, y = 20f;
	
	public Teste(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		map = new Mapa();
		bloqueado = new Bloqueado(map);
//		bau = new Bau(map);
		
		classe = new Engenheiro();
		sprite = classe.getAnimacao().Right();
	}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {
		Input input = gc.getInput();
		
		if (bau.temBau(x, y))
		{
			gc.getGraphics().drawString("OK Achou", x, y);
			
		}
		
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
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		map.getMap().render(0, 0);
		sprite.draw((int)x, (int)y);
	}
}
