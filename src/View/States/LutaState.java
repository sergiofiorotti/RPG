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
	private int cont;
	private Boolean turnoAtaque=false;
	private static Music musica;
	private int state;
	
	public LutaState(int state){
		this.state = state;
	}
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)throws SlickException {
		imagemBackground = new Image("imagens/lutaBackground.jpg");
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
				g.drawString("[PRESS " + numero + "]", (x + 40 * (i + 1)), 495);
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
		}
		else if(!(turnoAtaque)){
			g.drawString("Arma escolhida = " + (armaEscolhida+1), 180, 450);
			g.drawString("Pressione ENTER para iniciar a acao", 180, 430);
		}else{
			g.drawString("", 180, 450);
			g.drawString("", 180, 430);
		}
		
		if(cont==1){
			if(playerAcertou == 0){
				g.drawString("ERROU!", 100, 100);
			}else
				g.drawString("HIT! = "+playerAcertou, 100, 100);
		}
			
		if(cont==2){
			if(enemyAcertou == 0){
				g.drawString("ERROU!", 500, 100);
			}else
				g.drawString("HIT! = "+enemyAcertou, 500, 100);
		}
		
		g.setColor(Color.black);

		// Desenha a vida
		g.drawString("VIDA = " + player.getHp(), 50, 450);
		g.drawString("VIDA = " + enemy.getHp(), 500, 450);
		
		if(!player.isLife()){
			g.drawString("VOC� MORREU", 300, 200);
			g.drawString("APERTE ESPACO",300,215);
		}
		
		if(!enemy.isLife()){
			g.drawString("VOC� VENCEU!", 300, 200);
			g.drawString("APERTE ESPACO",300,215);
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int i)throws SlickException {
		Input input = gc.getInput();
		if(input.isKeyDown(Input.KEY_ESCAPE)){
			sbg.enterState(6, new FadeOutTransition(), new FadeInTransition());
		}
		
		//Escolhendo as armas
		if(input.isKeyDown(Input.KEY_1)&&!(turnoAtaque)){
			if (listaArmas[0] != null){
				armaEscolhida = 0;
				rodadaOk = true;
			}
		}
		if(input.isKeyDown(Input.KEY_2)&&!(turnoAtaque)){
			if (listaArmas[1] != null){
				armaEscolhida = 1;
				rodadaOk = true;
			}
		}
		if(input.isKeyDown(Input.KEY_3)&&!(turnoAtaque)){
			if (listaArmas[2] != null){
				armaEscolhida = 2;
				rodadaOk = true;
			}
		}
		if(input.isKeyDown(Input.KEY_4)&&!(turnoAtaque)){
			if (listaArmas[3] != null){
				armaEscolhida = 3;
				rodadaOk = true;
			}
		}
		if(input.isKeyDown(Input.KEY_5)&&!(turnoAtaque)){
			if (listaArmas[4] != null){
				armaEscolhida = 4;
				rodadaOk = true;
			}
		}
		
		if(input.isKeyDown(Input.KEY_ENTER) && rodadaOk){
			turnoAtaque=true;
			aleatorio = new Random().nextInt(3);
		}
		
		if(turnoAtaque){
			cont+=1;
			gc.sleep(2000);
			
			if (cont==1){
				playerAcertou=(player.attack((Arma)listaArmas[armaEscolhida]));
				enemy.subHp(playerAcertou);
			}
			if(cont==2){
				enemyAcertou=(enemy.attack((Arma)listaArmasInimigo[aleatorio]));
				player.subHp(enemyAcertou);
			}
			if(cont==3){
				rodadaOk = false;
				turnoAtaque=false;
				cont=0;
			}
		}
		
		if(!player.isLife()){
			if(input.isKeyDown(Input.KEY_SPACE)){
				LutaState.stopMusica();
				GameOverState.playMusica();
				sbg.enterState(2, new FadeOutTransition(), new FadeInTransition());
				
			}
		}
		
		if(!enemy.isLife()){
			enemy=null;
			cont=0;
			turnoAtaque=false;
			rodadaOk=false;
			
			if(input.isKeyDown(Input.KEY_SPACE)){
				LutaState.stopMusica();
				MapaState.playMusica();
				sbg.enterState(1,new FadeOutTransition(), new FadeInTransition());
			}
		}
		
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
