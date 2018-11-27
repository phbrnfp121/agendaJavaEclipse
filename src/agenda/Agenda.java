package agenda;

public class Agenda {
	private Evenement[] contenu;
	private int nbEvenements;
	public Agenda() {
		contenu = new Evenement[10];
		nbEvenements = 0;
	}
	public void ajoute(Evenement e) {
		contenu[nbEvenements] = e;
		nbEvenements++;
	}
	public int taille() {
		return nbEvenements;
	}
	public void afficher() {
		for(int i = 0, numero = 1; i < nbEvenements; i++, numero++) {
			System.out.print(numero);
			System.out.println(") " + contenu[i]);
		}
	}
}
