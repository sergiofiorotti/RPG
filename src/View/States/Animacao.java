package View.States;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;

public class Animacao {
	
	public Animacao(Image sprite)
	{
		this.movimentoUp = new Image[] {sprite.getSubImage(54, 0, 15, 21), sprite.getSubImage(72, 0, 15, 21), sprite.getSubImage(90, 0, 15, 21)};
		this.up = new Animation(movimentoUp, duration, false);
		
		this.movimentoDown = new Image[] {sprite.getSubImage(0, 0, 15, 21), sprite.getSubImage(18, 0, 15, 21), sprite.getSubImage(36, 0, 15, 21)};
		this.down = new Animation(movimentoDown, duration, false);
		
		this.movimentoLeft = new Image[] {sprite.getSubImage(90, 25, 15, 20), sprite.getSubImage(72, 25, 15, 20),sprite.getSubImage(54, 25, 15, 20)};
		this.left = new Animation(movimentoLeft, duration, false);
		
		this.movimentoRight = new Image[] {sprite.getSubImage(0, 25, 15, 20), sprite.getSubImage(18, 25, 15, 20), sprite.getSubImage(36, 25, 15, 20)};
		this.right = new Animation(movimentoRight, duration, false);
	}
	
	final static int[] duration = {300, 300, 300}; 
	
	private Image[] movimentoUp;
	private Animation up;
	
	private Image[] movimentoDown;
	private Animation down;
	
	private Image[] movimentoLeft ;
	private Animation left;
	
	private Image[] movimentoRight;
	private Animation right;
	
	public Animation Up(){
		return up;
	}
	
	public Animation Down(){
		return down;
	}
	
	public Animation Left(){
		return left;
	}
	
	public Animation Right(){
		return right;
	}
}
