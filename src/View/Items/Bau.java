package View.Items;

import java.util.Random;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import Armas.ArmaFogo;
import Armas.DoomBomb;
import Interfaces.IClasse;
import Main.Classe;

public class Bau {

	public Bau(int quantidade, TiledMap map, Boolean[][] bloqueado) throws SlickException{
		image = new Image("imagens/bau.png");
		
		this.quantidade = quantidade;
		posicao = new BauModel[quantidade];
		SortearPosicaoBau(map, bloqueado);
		
		bau = new Boolean[map.getWidth()][map.getHeight()];
		BauMapa(map);
	}
	
	private Boolean[][] bau;
	private Image image;
	private int quantidade;
	private BauModel[] posicao; 
	
	public Boolean temBau(float x, float y){
		int xBau = (int)x / Mapa.getSize();
        int yBau = (int)y / Mapa.getSize();
        return bau[xBau][yBau];
	}
	
	public void abrirBau(float x, float y){
		int xBau = (int)x / Mapa.getSize();
        int yBau = (int)y / Mapa.getSize();
        bau[xBau][yBau] = true;
	}
	
	public Image getImage(){
		return image;
	}
	
	public int getQuantidade(){
		return quantidade;
	}
	
	public BauModel[] getPosicao(){
		return posicao;
	}
	
	public BauModel getPosicao(float xBau, float yBau){
		for (int i=0; i < quantidade; i++){
			if (posicao[i].getX() / Mapa.getSize() == (int)xBau / Mapa.getSize() && posicao[i].getY() / Mapa.getSize() == (int)yBau / Mapa.getSize()){
				return posicao[i];
			}
		}
		return null;
	}
	
	public void BauMapa(TiledMap map){
        for (int x=0; x < map.getWidth(); x++){
             for (int y=0; y < map.getHeight(); y++){
            	 bau[x][y] = false;
            	 for(int i = 0; i < quantidade; i++){
            		 if (posicao[i].getX() == x * 20 && posicao[i].getY() == y * 20){
            			 bau[x][y] = true;
            		 }
            	 }
             }
        }
	}
	
	public BauModel[] SortearPosicaoBau(TiledMap map, Boolean[][] bloqueado){
		for	(int i = 0; i < quantidade; i++){
			int x,y,item;
			do{
				x = new Random().nextInt(800) / Mapa.getSize();
				y = new Random().nextInt(600) / Mapa.getSize();
				item = new Random().nextInt(4);
			}while(bloqueado[x][y]);
			x *= Mapa.getSize();
			y *= Mapa.getSize();
			posicao[i] = new BauModel(x, y, item);
		}
		return posicao;
	}
	
	public String SortearItemBau(Classe<?> classe, BauModel bau) throws SlickException{
		String retornar = "";
		switch (bau.getItem()) {
		case 0:
			retornar = "Bau vazio!";
			break;
		case 1:
			classe.addHp((int)(classe.getHp() * 1.5));
			retornar = "Voce ganhou mais vida";
			break;
		case 2:
			int quantidadeArmas = classe.getArmas().length;
			int sortearArma = new Random().nextInt(quantidadeArmas);
			IClasse arma = (IClasse) classe.getArmas()[sortearArma];
			ArmaFogo armaFogo;
			try{
				armaFogo = (ArmaFogo) arma;
				int balas = new Random().nextInt(10) + 1;
				armaFogo.addMunicao(balas);
				classe.setArmas(armaFogo, sortearArma);
				retornar = "Voce ganhou " + balas + " bala(s)!";
			}
			catch(Exception e){
				retornar = "Voce nao tem sorte mesmo!";
				break;
			}
			break;
		case 3:
			int sortearDoomBomb = new Random().nextInt(2);
			if (sortearDoomBomb == 1){
				classe.setArmas(new DoomBomb(), 4);
				retornar = "Voce ganhou a Doom Bomb!";
			}
			retornar = "Alguem roubou a Doom Bomb do bau!";
			break;
		}
		
		return retornar;
	}
}
