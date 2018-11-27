package temps;

/**
 * Durée représente un laps de temps
 *
 * @author LICINFO20182019
 * @version 2
 */
public class Duree extends Temps {
	/**
	 * initialise une durée
	 *
	 * @param h
	 *            un entier qui fixe la valeur heure de la durée
	 * @param m
	 *            un entier qui fixe la valeur minute de la durée
	 */
	public Duree(int h, int m) throws ExceptionHeureErronee, ExceptionMinuteErronee {
		super(h, m, "d'une durée", false);
	}

	/**
	 * initialise une durée
	 *
	 * @param texte
	 *            une chaîne de caractères au format 9h99
	 */
	public Duree(String texte) throws ExceptionHeureErronee, ExceptionMinuteErronee {
		super(texte, "h", "d'une durée", false);
	}

	/**
	 * retranche une minute à la durée considérée
	 */
	public void moins1minute() throws ExceptionOperationImpossible {
		if (minute > 0) {
			minute--;
		} else {
			if (heure > 0) {
				minute = 59;
				heure--;
			} else
				throw new ExceptionOperationImpossible(
						"Tentative de retirer une minute à une durée trop petite (" + this + ") !");
		}
	}

	/**
	 * ajoute une heure à la durée considérée
	 */
	public void plus1heure() {
		heure++;
	}

	/**
	 * retranche une heure à la durée considérée
	 */
	public void moins1heure() throws ExceptionOperationImpossible {
		if (heure > 0)
			heure--;
		else
			throw new ExceptionOperationImpossible(
					"Tentative de retirer une heure à une durée trop petite (" + this + ") !");
	}

	/**
	 * construit un texte notant la durée considérée
	 *
	 * @return une chaine de caractères au format 9h99
	 */
	public String toString() {
		String s = "";
		s += heure;
		s += "h";
		if (minute < 10)
			s += "0";
		s += minute;
		return s;
	}
}
