package temps;

/**
 * Heure représente un instant de la journée
 *
 * @author LICINFO20182019
 * @version 5
 */
public class Heure extends Temps {
	/**
	 * initialise une heure
	 *
	 * @param h un entier qui fixe la valeur heure de l'instant de la journée
	 * @param m un entier qui fixe la minute de l'heure considérée
	 */
	public Heure(int h, int m) throws ExceptionHeureErronee, ExceptionMinuteErronee {
		super(h, m, "d'une heure", true);
	}

	/**
	 * initialise une heure
	 *
	 * @param texte une chaîne de caractères au format 99:99
	 */
	public Heure(String texte) throws ExceptionHeureErronee, ExceptionMinuteErronee {
		super(texte, ":", "d'une heure", true);
	}

	/**
	 * retranche une minute à l'heure considérée
	 */
	public void moins1minute() {
		if (minute > 0) {
			minute--;
		} else {
			minute = 59;
			moins1heure();
		}
	}

	/**
	 * ajoute une heure à l'instant considéré
	 */
	public void plus1heure() {
		heure++;
		if (heure == 24) {
			heure = 0;
		}
	}

	/**
	 * retranche une heure à l'instant considéré
	 */
	public void moins1heure() {
		if (heure > 0)
			heure--;
		else
			heure = 23;
	}

	/**
	 * construit un texte notant l'instant considéré
	 *
	 * @return une chaine de caractères au format hh:mm
	 */
	public String toString() {
		String s = "";
		if (heure < 10)
			s += "0";
		s += heure;
		s += ":";
		if (minute < 10)
			s += "0";
		s += minute;
		return s;
	}
}
