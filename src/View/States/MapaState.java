package View.States;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.state.transition.RotateTransition;

import Classes.Alienigena.Soldier;
import Main.Classe;
import View.Items.*;
import View.States.PersonagemState;

public class MapaState extends BasicGameState {

	// Mapa
	private Mapa map;
	private Bloqueado bloqueado;
	private Bau bau;
	
	// Personagem
	private Classe<?> classe;
	private Animation sprite;
	private float x = 20f, y = 20f;
	private Image alien;
	private static Classe<?> enemy;
	
	public MapaState(int state){
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		map = new Mapa();
		bloqueado = new Bloqueado(map);
		bau = new Bau(map, 2, bloqueado.getBloqueado());
		
		alien = new Image("imagens/personagens/Soldier.png");
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
		
		if (x > 190 && x < 210  && y > 190 && y < 210)
			sbg.enterState(3, new FadeOutTransition(), new RotateTransition());
			enemy = new Soldier();
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
		
		// Desenha o personagem na tela
		sprite.draw((int)x, (int)y);
		g.drawImage(alien, 200, 200);
		
		// Desenha os baús
		for(int i=0; i < bau.getQuantidade(); i++){
			g.drawImage(bau.getImage(), bau.getPosicao()[i][0], bau.getPosicao()[i][1]);
		}
		
		/* Passou por cima de um baú sinaliza uma mensagem 
		se o baú está aberto ou fechado */
		Boolean temBau = bau.temBau(x, y);
		if (temBau != null){
			if (!temBau)
				g.drawString("Ba� fechado! [PRESS A]", x - 100, y + 20);
			else if (temBau)
				g.drawString("Baú aberto!", x, y + 20);
		}
	}

	@Override
	public int getID() {
		return 1;
	}
	
	public static Classe<?> getEnemy(){
		return enemy;
	}
}
