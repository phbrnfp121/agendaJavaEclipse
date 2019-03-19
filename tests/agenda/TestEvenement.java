package agenda;

import static org.junit.Assert.*;
import org.junit.Test;

import agenda.Evenement;
import temps.*;

public class TestEvenement {
	@Test
	public void test01constructeur() throws Exception {
		Date d = new Date(27, 11, 2018);
		Heure h = new Heure(10, 30);
		Evenement e = new Evenement("Essai", d, h);
		assertEquals("Le 27/11/2018 à 10:30 (1h00) : Essai", e.toString());
	}
	@Test
	public void test02unJourPlusTardEtPlusTot() throws Exception {
		Date d = new Date(27, 11, 2018);
		Heure h = new Heure(10, 30);
		Evenement e = new Evenement("Essai", d, h);
		e.unJourPlusTard();
		assertEquals("Le 28/11/2018 à 10:30 (1h00) : Essai", e.toString());
		e.unJourPlusTot();
		assertEquals("Le 27/11/2018 à 10:30 (1h00) : Essai", e.toString());
	}
	@Test
	public void test03uneHeurePlusTardEtPlusTot() throws Exception {
		Date d = new Date(27, 11, 2018);
		Heure h = new Heure(10, 30);
		Evenement e = new Evenement("Essai", d, h);
		e.uneHeurePlusTard();
		assertEquals("Le 27/11/2018 à 11:30 (1h00) : Essai", e.toString());
		e.uneHeurePlusTot();
		assertEquals("Le 27/11/2018 à 10:30 (1h00) : Essai", e.toString());
	}
	@Test
	public void test04uneHeurePlusTardAvecChangementJour() throws Exception {
		Date d = new Date(27, 11, 2018);
		Heure h = new Heure(23, 00);
		Evenement e = new Evenement("Essai", d, h);
		e.uneHeurePlusTard();
		assertEquals("Le 28/11/2018 à 00:00 (1h00) : Essai", e.toString());
	}
	@Test
	public void test05uneHeurePlusTotAvecChangementJour() throws Exception {
		Date d = new Date(27, 11, 2018);
		Heure h = new Heure(0, 59);
		Evenement e = new Evenement("Essai", d, h);
		e.uneHeurePlusTot();
		assertEquals("Le 26/11/2018 à 23:59 (1h00) : Essai", e.toString());
	}
}
