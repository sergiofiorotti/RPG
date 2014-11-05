package View.Items;

import org.newdawn.slick.tiled.TiledMap;

public class Bau {

	public Bau(Mapa map){
		BauMapa(map.getMap());
	}
	
	private Boolean[][] bau;
	
	public Boolean temBau(float x, float y){
		int xBau = (int)x / Mapa.size;
        int yBau = (int)y / Mapa.size;
        return bau[xBau][yBau];
	}
	
	public void BauMapa(TiledMap map){
		bau = new Boolean[map.getWidth()][map.getHeight()];
		
        for (int x=0; x<map.getWidth(); x++)
        {
             for (int y=0; y<map.getHeight(); y++)
             {
            	 bau[x][y] = null;
                 int tileID = map.getTileId(x, y, 0);
                 String value = map.getTileProperty(tileID, "bau", "false");
                 if ("true".equals(value)){
                	 bau[x][y] = false;
                	 bau[x][y+1] = false;
                	 bau[x][y-1] = false;
                	 bau[x+1][y] = false;
                	 bau[x+1][y+1] = false;
                	 bau[x+1][y-1] = false;
                	 bau[x-1][y] = false;
                	 bau[x-1][y+1] = false;
                	 bau[x-1][y-1] = false;
                 }
             }
         }
	}
}
