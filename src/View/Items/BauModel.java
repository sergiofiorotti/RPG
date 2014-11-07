package View.Items;

public class BauModel {
	
	int x;
	int y;
	boolean aberto;
	
	public BauModel(int x, int y){
		aberto = false;
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public boolean bauAberto(){
		return aberto;
	}
	
	public void abrirBau(){
		aberto = true;
	}
}
