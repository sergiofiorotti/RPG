package View.Items;

import org.newdawn.slick.tiled.TiledMap;

public class Bloqueado {
	
	public Bloqueado(Mapa map)
	{
		BloquearMapa(map.getMap());
	}
	
	private Boolean[][] bloqueado;
	
	public Boolean isBloqueado(float x, float y){
		int xBlock = (int)x / Mapa.size;
        int yBlock = (int)y / Mapa.size;
        return bloqueado[xBlock][yBlock];
	}
	
	public void BloquearMapa(TiledMap map){
		bloqueado = new Boolean[map.getWidth()][map.getHeight()];
		
        for (int x=0; x<map.getWidth(); x++)
        {
             for (int y=0; y<map.getHeight(); y++)
             {
                 int tileID = map.getTileId(x, y, 0);
                 String value = map.getTileProperty(tileID, "blocked", "false");
                 if ("true".equals(value)){
                	 bloqueado[x][y] = true;
                	 bloqueado[x][y+1] = true;
                	 bloqueado[x][y-1] = true;
                	 bloqueado[x+1][y] = true;
                	 bloqueado[x+1][y+1] = true;
                	 bloqueado[x+1][y-1] = true;
                	 bloqueado[x-1][y] = true;
                	 bloqueado[x-1][y+1] = true;
                	 bloqueado[x-1][y-1] = true;
                 }
                 else{
                	 if (bloqueado[x][y] == null)
                		 bloqueado[x][y] = false;
                 }
             }
         }
	}
}
