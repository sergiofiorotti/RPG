package View.Items;

import Main.Classe;

public class Personagem {

	private static Classe<?> classe;

	public static Classe<?> getClasse() {
		return classe;
	}

	public static void setClasse(Classe<?> classe) {
		Personagem.classe = classe;
	}
}
