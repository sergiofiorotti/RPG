package View.Items;

import java.util.Random;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;
import Classes.Alienigena.*;
import Main.Classe;

public class Inimigo {

	public Inimigo(int quantidade, TiledMap map, Boolean[][] bloqueado) throws SlickException{
		this.quantidade = quantidade;
		posicao = new InimigoModel[quantidade];
		SortearInimigo(map, bloqueado);
		
		inimigo = new Boolean[map.getWidth()][map.getHeight()];
		InimigoMapa(map);
	}
	
	public Image[] images;
	public Boolean[][] inimigo;
	public InimigoModel[] posicao;
	public int quantidade;
	
	public Boolean temInimigo(float x, float y){
		int xInimigo = (int)x / Mapa.getSize();
        int yInimigo = (int)y / Mapa.getSize();
        return inimigo[xInimigo][yInimigo];
	}
	
	public int getQuantidade(){
		return quantidade;
	}
	
	public InimigoModel[] getPosicao(){
		return posicao;
	}
	
	public Classe<?> getPosicao(float xEnemy, float yEnemy){
		for (int i=0; i < quantidade; i++){
			if (posicao[i].getX() / Mapa.getSize() == (int)(xEnemy / Mapa.getSize()) && posicao[i].getY() / Mapa.getSize() == (int)(yEnemy / Mapa.getSize())){
				return posicao[i].getClasse();
			}
		}
		return null;
	}
	
	public void InimigoMapa(TiledMap map){
        for (int x=0; x < map.getWidth(); x++){
             for (int y=0; y < map.getHeight(); y++){
            	 inimigo[x][y] = false;
            	 for(int i = 0; i < quantidade; i++){
            		 if (posicao[i].getX() == x * 20 && posicao[i].getY() == y * 20){
            			 inimigo[x][y] = true;
            		 }
            	 }
             }
        }
	}
	
	public InimigoModel[] SortearInimigo(TiledMap map, Boolean[][] bloqueado) throws SlickException{
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
				posicao[i] = new InimigoModel(x, y, new Engineer());
				break;
			case 1:
				posicao[i] = new InimigoModel(x, y, new Soldier());
				break;
			case 2:
				posicao[i] = new InimigoModel(x, y, new Tanker());
				break;
			default:
				break;
			}
		}
		return posicao;
	}

}
