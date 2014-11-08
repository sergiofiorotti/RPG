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
import Classes.Humano.Engenheiro;
import Classes.Humano.Espiao;
import Classes.Humano.Soldado;

import Main.Classe;

public class PersonagemState extends BasicGameState {

	
	private Image imagemBackground;
	private Image soldado;
	private Image engenheiro;
	private Image espiao;
	private static Classe<?> classe;
	
	public PersonagemState(int state){
			
		}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		imagemBackground = new Image("imagens/menuBackground.png");
		soldado = new Image("imagens/soldadoText.png");
		engenheiro = new Image("imagens/engenheiroText.png");
		espiao = new Image("imagens/espiaoText.png");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException{
		g.drawImage(imagemBackground, 0, 0);
		g.drawImage(soldado, 140, 80);
		g.drawImage(engenheiro, 40, 230);
		g.drawImage(espiao, 160, 400);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)throws SlickException {
		Input input = gc.getInput();
		int xpos = input.getMouseX();
		int ypos = input.getMouseY();
		
		if(input.isKeyDown(Input.KEY_ESCAPE)){
			sbg.enterState(0, new FadeOutTransition(), new FadeInTransition());
		}
		
		if((xpos>140 && xpos<694) && (ypos>80 && ypos<180)){
			if(input.isMouseButtonDown(0)){
				sbg.enterState(1, new FadeOutTransition(), new FadeInTransition());
				Inicio.stopMucica();
				MapaState.playMusica();
				PersonagemState.classe = new Soldado();
			}
		}
		if((xpos>40 && xpos<780) && (ypos>230 && ypos<350)){
			if(input.isMouseButtonDown(0)){
				sbg.enterState(1, new FadeOutTransition(), new FadeInTransition());
				Inicio.stopMucica();
				MapaState.playMusica();
				PersonagemState.classe = new Engenheiro();
			}
		}
		if((xpos>160 && xpos<650) && (ypos>400 && ypos<500)){
			if(input.isMouseButtonDown(0)){
				sbg.enterState(1, new FadeOutTransition(), new FadeInTransition());
				Inicio.stopMucica();
				MapaState.playMusica();
				PersonagemState.classe = new Espiao();
			}
		}
	}

	@Override
	public int getID() {
		return 5;
	}
	
	public static Classe<?> getClasse(){
		return classe;
	}
}

