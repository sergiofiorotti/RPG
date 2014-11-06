package View.Items;

import org.newdawn.slick.tiled.TiledMap;

public class Bloqueado {
	
	private Boolean[][] bloqueado;
	
	public Bloqueado(Mapa map)
	{
		bloqueado = new Boolean[map.getMap().getWidth()][map.getMap().getHeight()];
		BloquearMapa(map.getMap());
	}
	
	public Boolean[][] getBloqueado(){
		return bloqueado;
	}
	
	public Boolean isBloqueado(float x, float y){
		int xBlock = (int)x / Mapa.size;
        int yBlock = (int)y / Mapa.size;
        return bloqueado[xBlock][yBlock];
	}
	
	public void BloquearMapa(TiledMap map){
		for (int x=0; x<map.getWidth(); x++){
             for (int y=0; y<map.getHeight(); y++){
            	 bloqueado[x][y] = false;
                 int tileID = map.getTileId(x, y, 0);
                 String value = map.getTileProperty(tileID, "blocked", "false");
                 if ("true".equals(value)){
                	 bloqueado[x][y] = true;
                 }
             }
        }
        BloquearVizinho(map);
	}
	
	public void BloquearVizinho(TiledMap map){
		Boolean[][] aux = new Boolean[map.getWidth()][map.getHeight()];
		for (int x=0; x<map.getWidth(); x++){
             for (int y=0; y<map.getHeight(); y++){
            	 aux[x][y] = false;
            	 if (x < map.getWidth() - 1 && y < map.getHeight() - 1){
            		 if (bloqueado[x][y] || bloqueado[x][y+1] || 
            			 bloqueado[x+1][y] || bloqueado[x+1][y+1]){
            			 aux[x][y] = true;
            		 }
            	 }
             }
        }
		for (int x=0; x<map.getWidth(); x++){
             for (int y=0; y<map.getHeight(); y++){
            	 if (aux[x][y] == true)
            		 bloqueado[x][y] = true;
             }
        }
	}
}
