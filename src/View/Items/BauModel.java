package View.Items;

public class BauModel {
	
	private int x;
	private int y;
	private boolean aberto;
	private int item;
	private String achouBau;
	
	public BauModel(int x, int y, int item){
		aberto = false;
		this.x = x;
		this.y = y;
		this.item = item;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int getItem(){
		return item;
	}
	
	public boolean bauAberto(){
		return aberto;
	}
	
	public void abrirBau(){
		aberto = true;
	}
	
	public String getAchouBau(){
		return achouBau;
	}
	
	public void setAchouBau(String achouBau){
		this.achouBau = achouBau;
	}
	
}
