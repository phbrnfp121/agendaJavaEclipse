package application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
	public static void menu(Agenda a, int n) {
		a.afficher();
		System.out.print("i)nsérer un événement");
		if (!a.estVide()) System.out.print(" s)électionner");
		if (n != 0) System.out.print("{" + n + "}");
		System.out.println();
		if (!a.estVide()) System.out.print("e)nlever");
		if (!a.estVide()) System.out.println("t)itre");
		if (!a.estVide()) System.out.print(" >) repousser d'1j");
		if (!a.estVide()) System.out.print(" <) avancer d'1j");
		if (!a.estVide()) System.out.print(" +) repousser d'1h");
		if (!a.estVide()) System.out.println(" -) avancer d'1h");
		if (!a.estVide()) System.out.print("r) réduire d'1mn");
		if (!a.estVide()) System.out.println(" a) augmenter d'1mn");
		System.out.print("q)uitter : ");
	}
	public static void main(String[] args) {
		Agenda agenda = new Agenda();
		int selection = 0;
		Evenement e;
		char choix;
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("agenda.dat"));
			agenda = (Agenda)ois.readObject();
			ois.close();
		} catch(Exception erreur) {
			System.err.println(erreur.getMessage());
		}
		do {
			menu(agenda, selection);
			choix = IN.getChar();
			switch(choix) {
				case 'i' :
					e = nouvelEvenement();
					agenda.ajoute(e);
					break;
				case 's' :
					do {
						System.out.print("Numéro de l'événement à sélectionner ? ");
						selection = IN.getInt();
					} while(selection < 1 || selection > agenda.taille());
					break;
				case 'e' :
					agenda.supprimer(selection - 1);
					selection = 0;
					break;
				case 't' :
					System.out.println("Nouveau titre ? ");
					String nouveauLibelle = IN.getString();
					agenda.evenement(selection - 1).changerLibelle(nouveauLibelle);
					break;
				case '>' :
					agenda.evenement(selection - 1).unJourPlusTard();
					break;
				case '<' :
					agenda.evenement(selection - 1).unJourPlusTot();
					break;
				case '+' :
					agenda.evenement(selection - 1).uneHeurePlusTard();
					break;
				case '-' :
					agenda.evenement(selection - 1).uneHeurePlusTot();
					break;
				case 'r' :
					agenda.evenement(selection - 1).uneMinuteMoinsLong();
					break;
				case 'a' :
					agenda.evenement(selection - 1).uneMinutePlusLong();
					break;
				case 'q' :
			}
		} while(choix != 'q');
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("agenda.dat"));
			oos.writeObject(agenda);
			oos.close();
		} catch(Exception erreur) {
			System.err.println(erreur.getMessage());
		}
	}
}
