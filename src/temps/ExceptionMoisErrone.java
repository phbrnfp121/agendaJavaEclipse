package temps;

@SuppressWarnings("serial")
public class ExceptionMoisErrone extends Exception {
	public ExceptionMoisErrone(int valeur) {
		super("Echec d'initialisation d'une date avec un mois (" + valeur + ") en dehors de [1, 12] !");
	}
}
