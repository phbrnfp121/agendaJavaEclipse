package temps;
import static org.junit.Assert.*;
import org.junit.Test;

import temps.ExceptionHeureErronee;
import temps.ExceptionMinuteErronee;
import temps.Heure;

public class TestHeure {
    @Test
    public void test01constructeur() throws ExceptionHeureErronee, ExceptionMinuteErronee {
        Heure h = new Heure(10, 41);
        assertEquals("10:41", h.toString());
    }
    @Test
    public void test02plus1minute() throws ExceptionHeureErronee, ExceptionMinuteErronee {
        Heure h;
        h = new Heure(10, 41);
        h.plus1minute();
        assertEquals("10:42", h.toString());
        h = new Heure(10, 59);
        h.plus1minute();
        assertEquals("11:00", h.toString());
        h = new Heure(23, 59);
        h.plus1minute();
        assertEquals("00:00", h.toString());
    }
    @Test
    public void test03plus1heure() throws ExceptionHeureErronee, ExceptionMinuteErronee {
        Heure h;
        h = new Heure(10, 41);
        h.plus1heure();
        assertEquals("11:41", h.toString());
        h = new Heure(23, 30);
        h.plus1heure();
        assertEquals("00:30", h.toString());
    }
    @Test
    public void test04moins1heure() throws ExceptionHeureErronee, ExceptionMinuteErronee {
        Heure h;
        h = new Heure(10, 41);
        h.moins1heure();
        assertEquals("09:41", h.toString());
        h = new Heure(0, 30);
        h.moins1heure();
        assertEquals("23:30", h.toString());
    }
    @Test
    public void test05moins1minute() throws ExceptionHeureErronee, ExceptionMinuteErronee {
        Heure h;
        h = new Heure(10, 41);
        h.moins1minute();
        assertEquals("10:40", h.toString());
        h = new Heure(10, 00);
        h.moins1minute();
        assertEquals("09:59", h.toString());
        h = new Heure(0, 00);
        h.moins1minute();
        assertEquals("23:59", h.toString());
    }
    @Test(expected=ExceptionMinuteErronee.class)
    public void test06constructeurMinuteErronee() throws ExceptionHeureErronee, ExceptionMinuteErronee {
    	new Heure(0, -1);
    }
    @Test(expected=ExceptionMinuteErronee.class)
    public void test07constructeurMinuteErronee() throws ExceptionHeureErronee, ExceptionMinuteErronee {
    	new Heure(0, 60);
    }
    @Test(expected=ExceptionMinuteErronee.class)
    public void test08constructeurMinuteErronee() throws ExceptionHeureErronee, ExceptionMinuteErronee {
    	new Heure("0:-1");
    }
    @Test(expected=ExceptionMinuteErronee.class)
    public void test09constructeurMinuteErronee() throws ExceptionHeureErronee, ExceptionMinuteErronee {
    	new Heure("0:60");
    }
    @Test(expected=ExceptionHeureErronee.class)
    public void test10constructeurHeureErronee() throws ExceptionHeureErronee, ExceptionMinuteErronee {
    	new Heure(-1, 0);
    }
    @Test(expected=ExceptionHeureErronee.class)
    public void test11constructeurHeureErronee() throws ExceptionHeureErronee, ExceptionMinuteErronee {
    	new Heure("-1:0");
    }
    @Test(expected=ExceptionHeureErronee.class)
    public void test12constructeurHeureErronee() throws ExceptionHeureErronee, ExceptionMinuteErronee {
    	new Heure(24, 0);
    }
    @Test(expected=ExceptionHeureErronee.class)
    public void test13constructeurHeureErronee() throws ExceptionHeureErronee, ExceptionMinuteErronee {
    	new Heure("24:0");
    }
}
