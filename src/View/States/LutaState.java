package View.States;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import java.util.Random;

import Interfaces.IClasse;
import Main.Classe;
import Armas.Arma;
import Armas.ArmaFogo;


public class LutaState extends BasicGameState {

	private Classe<?> player;
	private int playerAcertou;
	private int enemyAcertou;
	private Classe<?> enemy;
	private Image imagemBackground;
	private IClasse[] listaArmas;
	private IClasse[] listaArmasInimigo;
	private int armaEscolhida;
	private int aleatorio;
	private Boolean rodadaOk=false;
	
	private static Music musica;
	
	public LutaState(int state){
	}
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)throws SlickException {
		imagemBackground = new Image("imagens/lutaBackground.png");
		musica = new Music("musicas/op2Batalha.wav");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException {
		
		// Desenha fundo
		g.drawImage(imagemBackground, 0, 0);
		
		// Desenha o inimigo
		if (enemy != null && enemy.isLife())
			g.drawImage(enemy.getImagem(), (int)500, (int)200);
		else{
			enemy = MapaState.getEnemy();
		}
		
		// Desenha o personagem
		player = PersonagemState.getClasse();
		g.drawImage(player.getImagem(), 50, 200);
		
		// Desenha as armas
		listaArmas = (IClasse[]) player.getArmas();
		listaArmasInimigo = (IClasse[]) enemy.getArmas();
		int x = 0;
		for(int i = 0; i < listaArmas.length; i++){
			if (listaArmas[i] != null){
				g.drawImage(((Arma)listaArmas[i]).getImagem(), (x + 40 * (i + 1)), 500);
				int numero = i + 1;
				g.drawString("[PRESS " + numero + "]", (x + 40 * (i + 1)), 487);
				try{
					ArmaFogo armaFogo = (ArmaFogo)listaArmas[i];
					g.drawString(""+armaFogo.getMunicao(), x+40*(i+1), 580);
				}catch(Exception e){
					
				}
				
				x += 80;
			}
		}
		
		if(!(rodadaOk)){
			g.drawString("Escolha a sua arma ", 180, 450);
		}else{
			g.drawString("Arma escolhida = " + (armaEscolhida+1), 180, 450);
			g.drawString("Pressione ENTER para atacar", 180, 430);
			
			if(playerAcertou == 0){
				g.drawString("ERROU!", 100, 100);
			}
			
			if(enemyAcertou == 0){
				g.drawString("ERROU!", 500, 100);
			}
		}
		g.setColor(Color.black);

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
		
		//Escolhendo as armas
		if(input.isKeyDown(Input.KEY_1)){
			armaEscolhida = 0;
			rodadaOk = true;
		}
		if(input.isKeyDown(Input.KEY_2)){
			armaEscolhida = 1;
			rodadaOk = true;
		}
		if(input.isKeyDown(Input.KEY_3)){
			armaEscolhida = 2;
			rodadaOk = true;
		}
		if(input.isKeyDown(Input.KEY_4)){
			armaEscolhida = 3;
			rodadaOk = true;
		}
		if(input.isKeyDown(Input.KEY_5)){
			armaEscolhida = 4;
			rodadaOk = true;
		}
		
		if(rodadaOk){
			if(input.isKeyDown(Input.KEY_ENTER)){
				aleatorio = new Random().nextInt(3);
				
				playerAcertou=((Arma)listaArmasInimigo[aleatorio]).attack();
				enemyAcertou=((Arma)listaArmas[armaEscolhida]).attack();
				player.subHp(enemyAcertou);
				enemy.subHp(playerAcertou);
				rodadaOk = false;
			}
		}
		
		if(player.getHp()==0){
			sbg.enterState(2, new FadeOutTransition(), new FadeInTransition());
		}
		
		if(enemy.getHp()==0){
			enemy=null;
			sbg.enterState(1,new FadeOutTransition(), new FadeInTransition());
			LutaState.stopMusica();
			MapaState.playMusica();
			
		}
		
	}

	@Override
	public int getID() {
		return 3;
	}
	public static void playMusica(){
		musica.play(1,1);
	}
	
	public static void stopMusica(){
		musica.stop();
	}
}
