package View.Items;

import java.util.Random;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class Bau {

	public Bau(int quantidade, TiledMap map, Boolean[][] bloqueado) throws SlickException{
		image = new Image("imagens/bau.png");
		
		this.quantidade = quantidade;
		posicao = new int[quantidade][2];
		SortearBau(map, bloqueado);;
		
		bau = new Boolean[map.getWidth()][map.getHeight()];
		BauMapa(map);
	}
	
	private Boolean[][] bau;
	private Image image;
	private int quantidade;
	private int[][] posicao; 
	
	public Boolean temBau(float x, float y){
		int xBau = (int)x / Mapa.size;
        int yBau = (int)y / Mapa.size;
        return bau[xBau][yBau];
	}
	
	public void abrirBau(float x, float y){
		int xBau = (int)x / Mapa.size;
        int yBau = (int)y / Mapa.size;
        bau[xBau][yBau] = true;
	}
	
	public Image getImage(){
		return image;
	}
	
	public int getQuantidade(){
		return quantidade;
	}
	
	public int[][] getPosicao(){
		return posicao;
	}
	
	public void BauMapa(TiledMap map){
        for (int x=0; x < map.getWidth(); x++){
             for (int y=0; y < map.getHeight(); y++){
            	 bau[x][y] = null;
            	 for(int i = 0; i < quantidade; i++){
            		 if (posicao[i][0] == x * 20 && posicao[i][1] == y * 20){
            			 bau[x][y] = false;
            		 }
            	 }
             }
        }
	}
	
	public int[][] SortearBau(TiledMap map, Boolean[][] bloqueado){
		for	(int i = 0; i < quantidade; i++){
			int x,y;
			do{
				x = new Random().nextInt(800) / Mapa.size;
				y = new Random().nextInt(600) / Mapa.size;
			}while(bloqueado[x][y]);
			posicao[i][0] = x * Mapa.size;
			posicao[i][1] = y * Mapa.size;
		}
		return posicao;
	}
}
