package View.States;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.state.transition.RotateTransition;

import Main.Classe;
import View.Items.*;
import View.States.PersonagemState;

public class MapaState extends BasicGameState {

	// Mapa
	private Mapa map;
	private Bloqueado bloqueado;
	private Bau bau;
	private Inimigo inimigo;
	
	// Personagem
	private Classe<?> classe;
	private Animation sprite;
	private float x = 20f, y = 20f;
	
	public MapaState(int state){
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		map = new Mapa();
		bloqueado = new Bloqueado(map);
		bau = new Bau(2, map.getMap(), bloqueado.getBloqueado());
		inimigo = new Inimigo(4, map.getMap(), bloqueado.getBloqueado());
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int i)
			throws SlickException {
		Input input = gc.getInput();
		if(input.isKeyDown(Input.KEY_ESCAPE)){
			sbg.enterState(4, new FadeOutTransition(), new FadeInTransition());
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
		
		Boolean temInimigo = inimigo.temInimigo(x, y);
		if (temInimigo){
			sbg.enterState(3, new FadeOutTransition(), new RotateTransition());
		}
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		
		if (classe != null)
			sprite.draw((int)x, (int)y);
		else{
			classe = PersonagemState.getClasse();
			sprite = classe.getAnimacao().Right();
		}
		
		// Renderiza o mapa
		map.getMap().render(0, 0);
		
		// Desenha o personagem
		sprite.draw((int)x, (int)y);
		
		// Desenha os baús
		for(int i=0; i < bau.getQuantidade(); i++){
			g.drawImage(bau.getImage(), bau.getPosicao()[i][0], bau.getPosicao()[i][1]);
		}
		
		// Desenha os inimigos
		for(int i=0; i < inimigo.getQuantidade(); i++){
			g.drawImage(inimigo.getImagens()[inimigo.getPosicao()[i][2]], inimigo.getPosicao()[i][0], inimigo.getPosicao()[i][1]);
		}
		
		/* Passou por cima de um baú sinaliza uma mensagem 
		se o baú está aberto ou fechado */
		Boolean temBau = bau.temBau(x, y);
		if (temBau != null){
			if (!temBau)
				g.drawString("Bau fechado! [PRESS A]", x - 100, y + 20);
			else if (temBau)
				g.drawString("Bau aberto!", x - 100, y + 20);
		}
		
		
	}

	@Override
	public int getID() {
		return 1;
	}
}
