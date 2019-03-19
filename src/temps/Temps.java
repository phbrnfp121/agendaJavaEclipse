package temps;

import java.util.StringTokenizer;
import static java.lang.Integer.parseInt;

import java.io.Serializable;

import outils.Comparable;

/**
 * Temps décrit le temps en heures et minutes
 *
 * @author LICINFO20182019
 * @version 1
 */
abstract public class Temps implements Comparable<Temps>, Serializable {
	protected int heure, minute;
	private void initialise(int h, int m, String quoi, boolean borneSupHeure)
	throws ExceptionHeureErronee, ExceptionMinuteErronee {
		boolean heureOK = borneSupHeure ? h >= 0 && h <= 23 : h >= 0;
		if (heureOK)
			heure = h;
		else
			throw new ExceptionHeureErronee("Echec d'initialisation "
			           + quoi + " avec une valeur (" + h + ") incorrecte de heure !");
		if (m >= 0 && m <= 59)
			minute = m;
		else
			throw new ExceptionMinuteErronee("Echec d'initialisation "
		           + quoi + " avec une valeur (" + m + " ) incorrecte de minute !");
	}
	/**
	 * initialise le temps
	 *
	 * @param h un entier qui fixe la valeur heure du temps
	 * @param m un entier qui fixe la valeur minute du temps
	 */
	public Temps(int h, int m, String quoi, boolean borneSupHeure)
	throws ExceptionHeureErronee, ExceptionMinuteErronee {
		initialise(h, m, quoi, borneSupHeure);
	}

	/**
	 * initialise le temps
	 *
	 * @param texte une chaîne de caractères notant ce temps
	 * @param delimiteur une chaîne de caractères utilisée comme séparateur des heures et minutes
	 */
	public Temps(String texte, String delimiteur, String quoi, boolean borneSupHeure)
	throws ExceptionHeureErronee, ExceptionMinuteErronee {
		StringTokenizer decoupeur = new StringTokenizer(texte, delimiteur);
		int h, m;
		h = parseInt(decoupeur.nextToken());
		m = parseInt(decoupeur.nextToken());
		initialise(h, m, quoi, borneSupHeure);
	}

	/**
	 * ajoute une minute au temps considéré
	 */
	public void plus1minute() {
		minute++;
		if (minute == 60) {
			minute = 0;
			plus1heure();
		}
	}

	/**
	 * retranche une minute au temps considéré
	 */
	abstract public void moins1minute() throws ExceptionOperationImpossible;

	/**
	 * ajoute une heure au temps considéré
	 */
	abstract public void plus1heure();

	/**
	 * retranche une heure au temps considéré
	 */
	abstract public void moins1heure() throws ExceptionOperationImpossible;
	/**
	 * convertit le temps en minutes
	 *
	 * @return un nombre de minutes
	 */
	public int enMinutes() {
		return heure * 60 + minute;
	}
	/**
	 * construit un texte notant le temps considéré
	 *
	 * @return une chaine de caractères
	 */
	abstract public String toString();
	/**
	 * compare un temps à un autre
	 *
	 * @param autre
	 *            un temps
	 * @return un entier nul si les temps sont égaux, négatif si le temps
	 *         considéré est plus petit que autre, positif si le temps considéré
	 *         est plus grand que autre
	 */
	public int compareA(Temps autre) {
		if (heure == autre.heure)
			return minute - autre.minute;
		else
			return heure - autre.heure;
	}
}
