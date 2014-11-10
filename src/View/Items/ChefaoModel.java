package View.Items;

import java.util.Random;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import Main.Classe;

public class ChefaoModel extends InimigoModel {
	private Image menor;
	private Image maior;
	
	public ChefaoModel(int x, int y, Classe<?> classe) throws SlickException{
		super(x, y, classe);
		
		classe.addHp(1000);
		classe.setChefao(true);
		
		int aleatorio = new Random().nextInt(3);
		maior = getImages(true)[aleatorio];
		menor = getImages(false)[aleatorio];
	}
	
	public static Image[] getImages(boolean grande) throws SlickException{
		if (grande){
			return new Image[] { 
					new Image("imagens/creditos/felippe.png"),
					new Image("imagens/creditos/leo.png"),
					new Image("imagens/creditos/sergio.png")
			};
		}
		else{
			return new Image[] { 
					new Image("imagens/inimigo1.png"),
					new Image("imagens/inimigo2.png"),
					new Image("imagens/inimigo3.png")
			};
		}
	}
	
	public Image getImageMaior(){
		return maior;
	}
	
	public Image getImageMenor(){
		return menor;
	}
}
