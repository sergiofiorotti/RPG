package View.States;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
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
	private static Chefao chefao;
	
	// Personagem
	private Classe<?> classe;
	private Animation sprite;
	private float x = 20f, y = 20f;
	
	private static Music musica;
	private int state;
	
	public MapaState(int state){
		this.state = state;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		map = new Mapa();
		bloqueado = new Bloqueado(map);
		bau = new Bau(5, map.getMap(), bloqueado.getBloqueado());
		inimigo = new Inimigo(3, map.getMap(), bloqueado.getBloqueado());
		chefao = new Chefao(1, map.getMap(), bloqueado.getBloqueado());
		musica = new Music("musicas/Mapa.wav");
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
		Input input = gc.getInput();
		if(input.isKeyDown(Input.KEY_ESCAPE)){
			sbg.enterState(Jogo.menuInGameState, new FadeOutTransition(), new FadeInTransition());
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
			if ((int)(y + (i * 0.1f)) < 585 && !bloqueado.isBloqueado(x, y + (i * 0.1f))){
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
			if ((int)(x + (i * 0.1f)) < 785 && !bloqueado.isBloqueado(x + (i * 0.1f), y)){
				sprite.update(i);
				x += i * 0.1f;
			}
		}
		
		if(!classe.isLife()){
			sbg.enterState(Jogo.gameOverState, new FadeOutTransition(), new FadeInTransition());
		}
		
		
		if (inimigo.temInimigo(x, y) && inimigo.getPosicao(x,y).isLife()){
			enemy = inimigo.getPosicao(x, y);
			MapaState.stopMusica();
			LutaState.playMusica();
			sbg.enterState(Jogo.lutaState, new FadeOutTransition(), new RotateTransition());
			
		}
		
		if (chefao.temChefao(x, y) && chefao.getPosicao(x, y).isLife()){
			boolean mortos = false;
			
			for(int j=0; j < inimigo.getQuantidade();j++){
				if(inimigo.getPosicao()[j].getClasse().isLife()){
					mortos = true;
				}
			}
			if (!mortos){
				enemy = chefao.getPosicao()[0].getClasse();
				MapaState.stopMusica();
				LutaState.playMusicaChefao();
				sbg.enterState(Jogo.lutaState, new FadeOutTransition(), new RotateTransition());
			}
		}
		
		if(input.isKeyDown(Input.KEY_A) && !(bau.getPosicao(x, y).bauAberto())){
			bau.getPosicao(x, y).setAchouBau(bau.SortearItemBau(classe, bau.getPosicao(x, y)));
			bau.getPosicao(x, y).abrirBau();
		}
		
		boolean mortos = false;
		for(int j=0; j<inimigo.getPosicao().length; j++){
			if (inimigo.getPosicao()[j].getClasse().isLife()){
				mortos = true;
			}
		}
		if (mortos == false){
			if (!chefao.getPosicao()[0].getClasse().isLife()){
				MapaState.stopMusica();
				Creditos.playMusica();
				sbg.enterState(Jogo.creditos, new FadeOutTransition(), new FadeInTransition());
			}
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
		
		boolean mortos = false;
		// Desenha o inimigo e o chefao na tela
		for(int i=0; i < inimigo.getQuantidade(); i++){
			if(inimigo.getPosicao()[i].getClasse().isLife()){
				g.drawImage(inimigo.getPosicao()[i].getClasse().getAnimacao().getImage(), inimigo.getPosicao()[i].getX(), inimigo.getPosicao()[i].getY());
				mortos = true;
			}
		}
		if (!mortos){
			g.drawImage(chefao.getPosicao()[0].getImageMenor(), chefao.getPosicao()[0].getX(), chefao.getPosicao()[0].getY());
		}
		
		// Desenha os baús
		for(int i=0; i < bau.getQuantidade(); i++){
			g.drawImage(bau.getImage(), bau.getPosicao()[i].getX(), bau.getPosicao()[i].getY());
		}
		
		/* Passou por cima de um baú sinaliza uma mensagem 
		se o baú está aberto ou fechado */
		if (bau.temBau(x, y)){
			g.setColor(Color.black);
			if (!bau.getPosicao(x, y).bauAberto()){
				String s = "Bau fechado! [PRESS A]";
				g.drawString(s, bau.acertarMensagemBauX((int)x, g.getFont().getWidth(s)), bau.acertarMensagemBauY((int)y, g.getFont().getHeight(s)));
			}
			else{
				String s = bau.getPosicao(x, y).getAchouBau();
				g.drawString(bau.getPosicao(x, y).getAchouBau(), bau.acertarMensagemBauX((int)x, g.getFont().getWidth(s)), bau.acertarMensagemBauY((int)y, g.getFont().getHeight(s)));
			}
		}
	}

	@Override
	public int getID() {
		return state;
	}
	
	public static Classe<?> getEnemy(){
		return enemy;
	}
	
	public static ChefaoModel getChefao(){
		return chefao.getPosicao()[0];
	}
	
	public static void playMusica(){
		musica.play(1,1);
	}
	
	public static void stopMusica(){
		musica.stop();
	}
}
