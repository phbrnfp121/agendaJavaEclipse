package agenda;

import temps.*;

/**
 * La classe Evenement décrit des éléments d'un agenda.
 *
 * @author LICINFO20182019
 * @see Agenda
 */
public class Evenement {
	private String libelle;
	private String description;
	private Date dateDebut;
	private Heure heureDebut;
	private Duree duree;
	/**
	 * constructeur d'un événement sans description et d'une durée de 1 heure
	 *
	 * @param nom une chaîne de caractères désignant l'événement
	 * @param d une instance de Date précisant la date de début
	 * @param h une instance de Heure précisant l'heure de début
	 */
	public Evenement(String nom, Date d, Heure h) {
		libelle = nom;
		description = null;
		dateDebut = d;
		heureDebut = h;
		try { duree = new Duree(1, 0); } catch(Exception e) { }
	}
	/**
	 * retarde l'événement d'un jour
	 */
	public void unJourPlusTard() {
		dateDebut.passerAuLendemain();
	}
	/**
	 * avance l'événement d'un jour
	 */
	public void unJourPlusTot() {
		dateDebut.passerALaVeille();
	}
	/**
	 * retarde l'événement d'une heure
	 */
	public void uneHeurePlusTard() {
		heureDebut.plus1heure();
		if (heureDebut.enMinutes() < 60) dateDebut.passerAuLendemain();
	}
	/**
	 * avance l'événement d'une heure
	 */
	public void uneHeurePlusTot() {
		heureDebut.moins1heure();
		if (heureDebut.enMinutes() >= 1380) dateDebut.passerALaVeille();
	}
	/**
	 * produit un texte décrivant l'événement
	 *
	 * @return une chaîne de caractères décrivant l'événement
	 */
	public String toString() {
		String texte = "Le " + dateDebut;
		texte += " à " + heureDebut;
		texte += " (" + duree + ")";
		texte += " : " + libelle;
		return texte;
	}
}
