package View.Items;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class Mapa {
	
	public Mapa() throws SlickException{
		map = new TiledMap("imagens/map.tmx");
	}
	
	private static TiledMap map;
	public static int size = 20;
	
	public TiledMap getMap(){
		return map;
	}
	
	public int getSize(){
		return size;
	}
}
