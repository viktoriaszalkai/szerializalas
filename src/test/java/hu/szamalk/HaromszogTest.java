package hu.szamalk;

import hu.szamalk.modell.Haromszog;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HaromszogTest {


    @Test
    void testKonstruktor(){
        Haromszog hsz = new Haromszog();
        Assertions.assertTrue(hsz.getA() > 0);
        Assertions.assertTrue(hsz.getB() > 0);
        Assertions.assertTrue(hsz.getC() > 0);

    }

    @Test
    void testKonstruktorParameteres(){
        Haromszog hsz = new Haromszog(3,3,3);
        Assertions.assertEquals(3,hsz.getA());
        Assertions.assertEquals(3,hsz.getB());
        Assertions.assertEquals(3,hsz.getC());

    }
    @Test
    void testKonstruktorEgyParameteres(){
        Haromszog hsz = new Haromszog(5);
        Assertions.assertEquals(5,hsz.getA());
        Assertions.assertEquals(5,hsz.getB());
        Assertions.assertEquals(5,hsz.getC());

    }
    @Test
    void testKonstruktorNemSzerkesztheto(){
        Assertions.assertThrows(IllegalArgumentException.class,() ->  new Haromszog(1,2,3));
        Assertions.assertThrows(IllegalArgumentException.class,() ->  new Haromszog(1,3,2));
        Assertions.assertThrows(IllegalArgumentException.class,() ->  new Haromszog(2,3,1));
        Assertions.assertThrows(IllegalArgumentException.class,() ->  new Haromszog(2,1,3));
        Assertions.assertThrows(IllegalArgumentException.class,() ->  new Haromszog(3,2,1));
        Assertions.assertThrows(IllegalArgumentException.class,() ->  new Haromszog(3,2,1));
    }

    @Test
    void testSetA_Nemszerk(){
        Haromszog hsz;
        hsz = new Haromszog(2,2,3);
        Assertions.assertThrows(IllegalArgumentException.class,() ->  hsz.setA(1));

    }
    @Test
    void testSetB_Nemszerk(){
        Haromszog hsz;
        hsz = new Haromszog(2,2,3);
        Assertions.assertThrows(IllegalArgumentException.class,() ->  hsz.setB(1));
    }
    @Test
    void testSetC_Nemszerk(){
        Haromszog hsz;
        hsz = new Haromszog(2,3,2);
        Assertions.assertThrows(IllegalArgumentException.class,() ->  hsz.setC(1));
    }


}