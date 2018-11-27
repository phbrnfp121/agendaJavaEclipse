package temps;
import static org.junit.Assert.*;
import org.junit.Test;

import temps.Date;
import temps.ExceptionAnneeErronee;
import temps.ExceptionJourErrone;
import temps.ExceptionMoisErrone;

public class TestDate {
    @Test
    public void test01constructeur()
    throws ExceptionJourErrone, ExceptionMoisErrone, ExceptionAnneeErronee {
        Date d = new Date(6, 11, 2018);
        assertEquals("6/11/2018", d.toString());
    }
    @Test
    public void test02passerAuLendemainEtALaVeille()
    	    throws ExceptionJourErrone, ExceptionMoisErrone, ExceptionAnneeErronee {
        Date d;
        d = new Date(10, 3, 2018);
        d.passerAuLendemain();
        assertEquals("11/03/2018", d.toString());
        d.passerALaVeille();
        assertEquals("10/03/2018", d.toString());
        d = new Date(31, 1, 2018);
        d.passerAuLendemain();
        assertEquals("1/02/2018", d.toString());
        d.passerALaVeille();
        assertEquals("31/01/2018", d.toString());
        d = new Date(31, 12, 2018);
        d.passerAuLendemain();
        assertEquals("1/01/2019", d.toString());
        d.passerALaVeille();
        assertEquals("31/12/2018", d.toString());
    }
    @Test
    public void test03bissextile() {
        assertTrue(Date.bissextile(2016));
        assertFalse(Date.bissextile(2018));
    }
    @Test
    public void test04nombreDeJoursDuMois() {
        assertEquals(31, Date.nombreDeJoursDuMois(1, 2018));
        assertEquals(28, Date.nombreDeJoursDuMois(2, 2018));
        assertEquals(29, Date.nombreDeJoursDuMois(2, 2020));
        assertEquals(31, Date.nombreDeJoursDuMois(3, 2018));
        assertEquals(30, Date.nombreDeJoursDuMois(4, 2018));
        assertEquals(31, Date.nombreDeJoursDuMois(5, 2018));
        assertEquals(30, Date.nombreDeJoursDuMois(6, 2018));
        assertEquals(31, Date.nombreDeJoursDuMois(7, 2018));
        assertEquals(31, Date.nombreDeJoursDuMois(8, 2018));
        assertEquals(30, Date.nombreDeJoursDuMois(9, 2018));
        assertEquals(31, Date.nombreDeJoursDuMois(10, 2018));
        assertEquals(30, Date.nombreDeJoursDuMois(11, 2018));
        assertEquals(31, Date.nombreDeJoursDuMois(12, 2018));
    }
    @Test
    public void test05constructeur()
    	    throws ExceptionJourErrone, ExceptionMoisErrone, ExceptionAnneeErronee {
    	Date d = new Date("3/4/2018");
    	assertEquals("3/04/2018", d.toString());
    }
    @Test(expected=ExceptionAnneeErronee.class)
    public void test06constructeurMauvaiseAnnee()
    throws ExceptionJourErrone, ExceptionMoisErrone, ExceptionAnneeErronee {
    	new Date(1, 1, 0);
    }
    @Test(expected=ExceptionAnneeErronee.class)
    public void test07constructeurMauvaiseAnnee()
    throws ExceptionJourErrone, ExceptionMoisErrone, ExceptionAnneeErronee {
    	new Date("1/1/0");
    }
    @Test(expected=ExceptionMoisErrone.class)
    public void test08constructeurMauvaisMois()
    throws ExceptionJourErrone, ExceptionMoisErrone, ExceptionAnneeErronee {
    	new Date(1, 0, 2018);
    }
    @Test(expected=ExceptionMoisErrone.class)
    public void test09constructeurMauvaisMois()
    throws ExceptionJourErrone, ExceptionMoisErrone, ExceptionAnneeErronee {
    	new Date(1, 13, 2018);
    }
    @Test(expected=ExceptionMoisErrone.class)
    public void test10constructeurMauvaisMois()
    throws ExceptionJourErrone, ExceptionMoisErrone, ExceptionAnneeErronee {
    	new Date("1/0/2018");
    }
    @Test(expected=ExceptionMoisErrone.class)
    public void test11constructeurMauvaisMois()
    throws ExceptionJourErrone, ExceptionMoisErrone, ExceptionAnneeErronee {
    	new Date("1/13/2018");
    }
    @Test(expected=ExceptionJourErrone.class)
    public void test12constructeurMauvaisJour()
    	    throws ExceptionJourErrone, ExceptionMoisErrone, ExceptionAnneeErronee {
    	new Date(0, 1, 2018);
    }
    @Test(expected=ExceptionJourErrone.class)
    public void test13constructeurMauvaisJour()
    	    throws ExceptionJourErrone, ExceptionMoisErrone, ExceptionAnneeErronee {
    	new Date(32, 1, 2018);
    }
    @Test(expected=ExceptionJourErrone.class)
    public void test14constructeurMauvaisJour()
    	    throws ExceptionJourErrone, ExceptionMoisErrone, ExceptionAnneeErronee {
    	new Date("0/1/2018");
    }
    @Test(expected=ExceptionJourErrone.class)
    public void test15constructeurMauvaisJour()
    	    throws ExceptionJourErrone, ExceptionMoisErrone, ExceptionAnneeErronee {
    	new Date("32/1/2018");
    }
    @Test(expected=ExceptionJourErrone.class)
    public void test16constructeurMauvaisJour()
    	    throws ExceptionJourErrone, ExceptionMoisErrone, ExceptionAnneeErronee {
    	new Date(31, 4, 2018);
    }
    @Test(expected=ExceptionJourErrone.class)
    public void test17constructeurMauvaisJour()
    	    throws ExceptionJourErrone, ExceptionMoisErrone, ExceptionAnneeErronee {
    	new Date("31/4/2018");
    }
    @Test(expected=ExceptionJourErrone.class)
    public void test18constructeurMauvaisJour()
    	    throws ExceptionJourErrone, ExceptionMoisErrone, ExceptionAnneeErronee {
    	new Date(29, 2, 2018);
    }
    @Test(expected=ExceptionJourErrone.class)
    public void test19constructeurMauvaisJour()
    	    throws ExceptionJourErrone, ExceptionMoisErrone, ExceptionAnneeErronee {
    	new Date("29/2/2018");
    }
}
