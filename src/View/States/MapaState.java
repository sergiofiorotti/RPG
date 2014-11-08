package View.States;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
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
	
	// Inimigos
	private Inimigo inimigo;
	private static Classe<?> enemy;
	
	// Personagem
	private Classe<?> classe;
	private Animation sprite;
	private float x = 20f, y = 20f;
	
	private static Music musica;
	
	public MapaState(int state){
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		map = new Mapa();
		bloqueado = new Bloqueado(map);
		bau = new Bau(2, map.getMap(), bloqueado.getBloqueado());
		inimigo = new Inimigo(4, map.getMap(), bloqueado.getBloqueado());
		musica = new Music("musicas/Mapa.wav");
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int i)
			throws SlickException {
		Input input = gc.getInput();
		if(input.isKeyDown(Input.KEY_ESCAPE)){
			sbg.enterState(4, new FadeOutTransition(), new FadeInTransition());
		}
		
		if(input.isKeyDown(Input.KEY_UP)){
			sprite = classe.getAnimacao().Up();
			if (y - (i * 0.1f) > 0 && !bloqueado.isBloqueado(x, y - (i * 0.1f))){
				sprite.update(i);
				y -= i * 0.1f;
			}
		}
		else if(input.isKeyDown(Input.KEY_DOWN)){
			sprite = classe.getAnimacao().Down();
			if (y + (i * 0.1f) < 600 && !bloqueado.isBloqueado(x, y + (i * 0.1f))){
				sprite.update(i);
				y += i * 0.1f;
			}
		}
		else if(input.isKeyDown(Input.KEY_LEFT)){
			sprite = classe.getAnimacao().Left();
			if (x - (i * 0.1f) > 0 && !bloqueado.isBloqueado(x - (i * 0.1f), y)){
				sprite.update(i);
				x -= i * 0.1f;
			}
		}
		else if(input.isKeyDown(Input.KEY_RIGHT)){
			sprite = classe.getAnimacao().Right();
			if (x + (i * 0.1f) < 800 && !bloqueado.isBloqueado(x + (i * 0.1f), y)){
				sprite.update(i);
				x += i * 0.1f;
			}
		}
		
		if(!(classe.isLife())){
			sbg.enterState(2, new FadeOutTransition(), new FadeInTransition());
		}
		
		if (inimigo.temInimigo(x, y) && inimigo.getPosicao(x,y).isLife()){
			enemy = inimigo.getPosicao(x, y);
			sbg.enterState(3, new FadeOutTransition(), new RotateTransition());
			MapaState.stopMusica();
			LutaState.playMusica();
		}
		
		if(input.isKeyDown(Input.KEY_A) && !bau.getPosicao(x, y).bauAberto()){
			bau.getPosicao(x, y).setAchouBau(bau.SortearItemBau(classe, bau.getPosicao(x, y)));
			bau.getPosicao(x, y).abrirBau();
		}
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		
		// Renderiza o mapa
		map.getMap().render(0, 0);
		
		// Desenha o personagem
		if (classe != null)
			sprite.draw((int)x, (int)y);
		else{
			classe = PersonagemState.getClasse();
			sprite = classe.getAnimacao().Right();
		}
		
		// Desenha o inimigo na tela
		for(int i=0; i < inimigo.getQuantidade(); i++){
			if(inimigo.getPosicao()[i].getClasse().isLife())
				g.drawImage(inimigo.getPosicao()[i].getClasse().getAnimacao().getImage(), inimigo.getPosicao()[i].getX(), inimigo.getPosicao()[i].getY());
		}
		
		// Desenha os baús
		for(int i=0; i < bau.getQuantidade(); i++){
			g.drawImage(bau.getImage(), bau.getPosicao()[i].getX(), bau.getPosicao()[i].getY());
		}
		
		/* Passou por cima de um baú sinaliza uma mensagem 
		se o baú está aberto ou fechado */
		if (bau.temBau(x, y)){
			if (!bau.getPosicao(x, y).bauAberto())
				g.drawString("Bau fechado! [PRESS A]", x - 100, y + 20);
			else
				g.drawString(bau.getPosicao(x, y).getAchouBau(), x - 50, y + 20);
		}
	}

	@Override
	public int getID() {
		return 1;
	}
	
	public static Classe<?> getEnemy(){
		return enemy;
	}
	
	public static void playMusica(){
		musica.play(1,1);
	}
	
	public static void stopMusica(){
		musica.stop();
	}
}
