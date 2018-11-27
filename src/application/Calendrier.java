package application;

import agenda.*;
import temps.*;
import outils.IN;

public class Calendrier {
	private static Date nouvelleDate() {
		Date d = null;
		boolean erreur;
		do {
			erreur = false;
			System.out.println("Date ?");
			try {
				d = new Date(IN.getString());
			} catch(ExceptionJourErrone ej) {
				erreur = true;
				System.out.println("le jour de cette date ne convient pas !");
			} catch(ExceptionMoisErrone em) {
				erreur = true;
				System.out.println("le mois de cette date ne convient pas !");
			} catch(ExceptionAnneeErronee ea) {
				erreur = true;
				System.out.println("l'année de cette date ne convient pas !");
			}
		} while(erreur);
		return d;
	}
	private static Heure nouvelleHeure() {
		Heure h = null;
		boolean erreur;
		do {
			erreur = false;
			System.out.println("Heure ?");
			try {
				h = new Heure(IN.getString());
			} catch(ExceptionHeureErronee eh) {
				erreur = true;
				System.out.println("l'heure de cet horaire ne convient pas !");
			} catch(ExceptionMinuteErronee em) {
				erreur = true;
				System.out.println("les minutes de cet horaire ne conviennent pas !");
			}
		} while(erreur);
		return h;
	}
	private static Evenement nouvelEvenement() {
		Date d;
		Heure h;
		String nom;
		System.out.println("Intitulé ?");
		nom = IN.getString();
		d = nouvelleDate();
		h = nouvelleHeure();
		return new Evenement(nom, d, h);
	}
	public static void main(String[] args) {
		Agenda agenda = new Agenda();
		Evenement e;
		char choix;
		do {
			agenda.afficher();
			System.out.print("a)jouter un événement  q)quitter : ");
			choix = IN.getChar();
			switch(choix) {
				case 'a' :
					e = nouvelEvenement();
					agenda.ajoute(e);
					break;
				case 'q' :
			}
		} while(choix != 'q');
	}
}
