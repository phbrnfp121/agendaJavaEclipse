package temps;

@SuppressWarnings("serial")
public class ExceptionAnneeErronee extends Exception {
	public ExceptionAnneeErronee(int valeur) {
		super("Echec d'initialisation d'une date avec une année (" + valeur + ") inférieure à 1 !");
	}
}
