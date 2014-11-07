package View.Items;

import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class Inimigo {

	public Inimigo(int quantidade, TiledMap map, Boolean[][] bloqueado) throws SlickException{
		images = new Image[] { 	new Image("imagens/personagens/Engineer.png"), 
								new Image("imagens/personagens/Soldier.png"),
								new Image("imagens/personagens/Tanker.png")};
		
		this.quantidade = quantidade;
		posicao = new int[quantidade][3];
		SortearInimigo(map, bloqueado);
		
		inimigo = new Boolean[map.getWidth()][map.getHeight()];
		InimigoMapa(map);
	}
	
	public Image[] images;
	public Boolean[][] inimigo;
	public int[][] posicao;
	public int quantidade;
	
	public Boolean temInimigo(float x, float y){
		int xInimigo = (int)x / Mapa.size;
        int yInimigo = (int)y / Mapa.size;
        return inimigo[xInimigo][yInimigo];
	}
	
	public Image[] getImagens(){
		return images;
	}
	
	public int getQuantidade(){
		return quantidade;
	}
	
	public int[][] getPosicao(){
		return posicao;
	}
	
	public void InimigoMapa(TiledMap map){
        for (int x=0; x < map.getWidth(); x++){
             for (int y=0; y < map.getHeight(); y++){
            	 inimigo[x][y] = false;
            	 for(int i = 0; i < quantidade; i++){
            		 if (posicao[i][0] == x * 20 && posicao[i][1] == y * 20){
            			 inimigo[x][y] = true;
            		 }
            	 }
             }
        }
	}
	
	public int[][] SortearInimigo(TiledMap map, Boolean[][] bloqueado){
		for	(int i = 0; i < quantidade; i++){
			int x,y,z;
			do{
				x = new Random().nextInt(800) / Mapa.size;
				y = new Random().nextInt(600) / Mapa.size;
				z = new Random().nextInt(images.length);
			}while(bloqueado[x][y]);
			posicao[i][0] = x * Mapa.size;
			posicao[i][1] = y * Mapa.size;
			posicao[i][2] = z;
		}
		return posicao;
	}

}
