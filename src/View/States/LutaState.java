package View.States;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import Interfaces.IClasse;
import Main.Classe;
import Armas.Arma;


public class LutaState extends BasicGameState {

	private Classe<?> player;
	private Classe<?> enemy;
	private Image imagemBackground;
	private IClasse[] listaArmas;
	
	public LutaState(int state){
	}
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)throws SlickException {
		imagemBackground = new Image("imagens/lutaBackground.png");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException {
		
		// Desenha fundo
		g.drawImage(imagemBackground, 0, 0);
		
		// Desenha o inimigo
		if (enemy != null)
			g.drawImage(enemy.getImagem(), (int)500, (int)200);
		else{
			enemy = MapaState.getEnemy();
		}
		
		// Desenha o personagem
		player = PersonagemState.getClasse();
		g.drawImage(player.getImagem(), 50, 200);
		
		// Desenha as armas
		listaArmas = (IClasse[]) player.getArmas();
		int x = 0;
		for(int i = 0; i < listaArmas.length; i++){
			if (listaArmas[i] != null){
				g.drawImage(((Arma)listaArmas[i]).getImagem(), (x + 40 * (i + 1)), 500);
				int numero = i + 1;
				g.drawString("[PRESS " + numero + "]", (x + 40 * (i + 1)), 487);
				x += 80;
			}
		}

		// Desenha a vida
		g.drawString("VIDA = " + player.getHp(), 50, 450);
		g.drawString("VIDA = " + enemy.getHp(), 500, 450);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int i)throws SlickException {
		Input input = gc.getInput();
		if(input.isKeyDown(Input.KEY_ESCAPE)){
			sbg.enterState(6, new FadeOutTransition(), new FadeInTransition());
		}
	}

	@Override
	public int getID() {
		return 3;
	}
}
