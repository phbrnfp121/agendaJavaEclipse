package agenda;

import java.io.Serializable;

public class Agenda implements Serializable {
	private Evenement[] contenu;
	private int nbEvenements;
	public Agenda() {
		contenu = new Evenement[10];
		nbEvenements = 0;
	}
	private int placeDe(Evenement e) {
		int deb, fin, mil = 0, dif = -1;
		deb = 0;
		fin = nbEvenements - 1;
		while(dif != 0 && fin >= deb) {
			mil = (deb + fin) / 2;
			dif = contenu[mil].compareA(e);
			if (dif < 0) deb = mil + 1;
			else if (dif > 0) fin = mil - 1;
		}
		if (fin < deb) return deb;
		return mil;
	}
	public void ajoute(Evenement e) {
		if (nbEvenements == contenu.length) {
			Evenement[] nouveauContenu = new Evenement[nbEvenements * 2];
			for(int i = 0; i < nbEvenements; i++) {
				nouveauContenu[i] = contenu[i];
				contenu[i] = null;
			}
			contenu = nouveauContenu;
		}
		int ou = placeDe(e);
		for (int i = nbEvenements; i > ou; i--) contenu[i] = contenu[i - 1];
		contenu[ou] = e;
		nbEvenements++;
	}
	public int taille() {
		return nbEvenements;
	}
	public boolean estVide() {
		return nbEvenements == 0;
	}
	/**
	 * supprimer un événement de l'agenda
	 * 
	 * @param numero un entier qui précise l'événement à supprimer entre 0 et nbEvenements
	 */
	public void supprimer(int numero) {
		for (int i = numero + 1; i < nbEvenements; i++)
			contenu[i - 1] = contenu[i];
		nbEvenements--;
		contenu[nbEvenements] = null;
	}
	public void afficher() {
		for(int i = 0, numero = 1; i < nbEvenements; i++, numero++) {
			System.out.print(numero);
			System.out.println(") " + contenu[i]);
		}
	}
	public Evenement evenement(int numero) {
		return contenu[numero];
	}
}
