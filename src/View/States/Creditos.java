package View.States;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.Color;


public class Creditos extends BasicGameState {
	
	private static Music musica;
	private int creditos = 0;
	private int state;
	
	private Image artes;
	private Image desenvolvimento;
	private Image musicas;
	
	private Image felippeNome;
	private Image felippeChar;
	
	private Image leonardoNome;
	private Image leonardoChar;
	
	private Image sergioNome;
	private Image sergioChar;
	
	public Creditos(int state){
		this.state = state;
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		musica = new Music("musicas/creditos.wav");
		
		artes = new Image("imagens/creditos/Arte.png");
		
		desenvolvimento = new Image("imagens/creditos/Desenvolvimento.png");
		musicas = new Image("imagens/creditos/Musicas.png");
		
		felippeNome = new Image("imagens/creditos/FelippeNome.png");
		felippeChar = new Image("imagens/creditos/felippe.png");
		
		leonardoNome = new Image("imagens/creditos/leonardoNome.png");
		leonardoChar = new Image("imagens/creditos/leo.png");
		
		sergioNome = new Image("imagens/creditos/sergioNome.png");
		sergioChar = new Image("imagens/creditos/sergio.png");

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		
		g.setColor(Color.white);
		switch (creditos) {
			case 1:
				g.drawImage(desenvolvimento, 200, 50);
				g.drawImage(felippeNome,20,170);
				g.drawImage(felippeChar, 50, 400);
				
				g.drawImage(leonardoNome,250,170);
				g.drawImage(leonardoChar, 250+50, 400);
				
				g.drawImage(sergioNome,530,170);
				g.drawImage(sergioChar, 530+50, 400);
				break;
			case 2:
				g.drawImage(artes, 330, 50);
				g.drawImage(felippeNome,80,170);
				g.drawImage(felippeChar, 80+30, 400);
				
				g.drawImage(leonardoNome,430,170);
				g.drawImage(leonardoChar, 430+50, 400);
				break;
			case 3:
				g.drawImage(musicas, 300, 50);
				
				g.drawImage(leonardoNome,250,170);
				g.drawImage(leonardoChar, 250+50, 400);
				break;
			case 4: 
				gc.exit();
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int i)
			throws SlickException {
		
		gc.sleep(8000);
		creditos++;
	}

	@Override
	public int getID() {
		return state;
	}
	
	public static void playMusica(){
		musica.play(1,1);
	}
	
	public static void stopMusica(){
		musica.stop();
	}
}