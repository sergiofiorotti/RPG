package View.Items;

import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import Classes.Alienigena.Engineer;
import Classes.Alienigena.Soldier;
import Classes.Alienigena.Tanker;
import Main.Classe;

public class Chefao {
	
	public Chefao(int quantidade, TiledMap map, Boolean[][] bloqueado) throws SlickException{
		this.quantidade = quantidade;
		posicao = new ChefaoModel[quantidade];
		SortearChefao(map, bloqueado);
		
		chefao = new Boolean[map.getWidth()][map.getHeight()];
		ChefaoMapa(map);
	}
	
	public Image[] images;
	public Boolean[][] chefao;
	public ChefaoModel[] posicao;
	public int quantidade;
	
	public Boolean temChefao(float x, float y){
		int xChefao = (int)x / Mapa.getSize();
        int yChefao = (int)y / Mapa.getSize();
        return chefao[xChefao][yChefao];
	}
	
	public ChefaoModel[] getPosicao(){
		return posicao;
	}
	
	public int getQuantidade(){
		return quantidade;
	}
	
	public Classe<?> getPosicao(float xChefao, float yChefao){
		for (int i=0; i < quantidade; i++){
			if (posicao[i].getX() / Mapa.getSize() == (int)(xChefao / Mapa.getSize()) && posicao[i].getY() / Mapa.getSize() == (int)(yChefao / Mapa.getSize())){
				return posicao[i].getClasse();
			}
		}
		return null;
	}
	
	public void ChefaoMapa(TiledMap map){
        for (int x=0; x < map.getWidth(); x++){
             for (int y=0; y < map.getHeight(); y++){
            	 chefao[x][y] = false;
            	 for(int i = 0; i < quantidade; i++){
            		 if (posicao[i].getX() == x * 20 && posicao[i].getY() == y * 20){
            			 chefao[x][y] = true;
            		 }
            	 }
             }
        }
	}
	
	public ChefaoModel[] SortearChefao(TiledMap map, Boolean[][] bloqueado) throws SlickException{
		for	(int i = 0; i < quantidade; i++){
			int x,y,z;
			do{
				x = new Random().nextInt(800) / Mapa.getSize();
				y = new Random().nextInt(600) / Mapa.getSize();
				z = new Random().nextInt(3);
			}while(bloqueado[x][y]);
			
			x *= Mapa.getSize();
			y *= Mapa.getSize();
			
			switch (z) {
			case 0:
				posicao[i] = new ChefaoModel(x, y, new Engineer());
				break;
			case 1:
				posicao[i] = new ChefaoModel(x, y, new Soldier());
				break;
			case 2:
				posicao[i] = new ChefaoModel(x, y, new Tanker());
				break;
			default:
				break;
			}
		}
		return posicao;
	}
}
