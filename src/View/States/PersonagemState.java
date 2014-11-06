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
		g.drawImage(soldado, 300, 100);
		g.drawImage(engenheiro, 300, 200);
		g.drawImage(espiao, 300, 300);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)throws SlickException {
		Input input = gc.getInput();
		int xpos = input.getMouseX();
		int ypos = input.getMouseY();
		
		if((xpos>300 && xpos<450) && (ypos>100 && ypos<150)){
			if(input.isMouseButtonDown(0)){
				sbg.enterState(1, new FadeOutTransition(), new FadeInTransition());
				PersonagemState.classe = new Soldado();
			}
		}
		if((xpos>300 && xpos<450) && (ypos>200 && ypos<250)){
			if(input.isMouseButtonDown(0)){
				sbg.enterState(1, new FadeOutTransition(), new FadeInTransition());
				PersonagemState.classe = new Engenheiro();
			}
		}
		if((xpos>300 && xpos<450) && (ypos>300 && ypos<350)){
			if(input.isMouseButtonDown(0)){
				sbg.enterState(1, new FadeOutTransition(), new FadeInTransition());
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

