package pl.put.poznan.transformer.logic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringTransformationsTest {

    private StringTransformations sc;

    @Before
    public void setUp(){
        sc=new StringTransformations();
    }

    @After
    public void finish(){
        sc=null;
    }
    @Test
    public void testUpper(){
        assertEquals("MIREK",sc.changeCase("MirEk","upper"));
        assertEquals("ALA MA KOTA",sc.changeCase("Ala Ma KoTa","upper"));
        assertEquals("",sc.changeCase("","upper"));
    }

    @Test
    public void testLower(){
        assertEquals("mirek",sc.changeCase("MirEk","lower"));
        assertEquals("ala ma kota",sc.changeCase("Ala Ma KoTa","lower"));
        assertEquals("",sc.changeCase("","lower"));
    }

    @Test
    public void testCapitalize(){
        assertEquals("MirEk",sc.changeCase("mirEk","capitalize"));
        assertEquals("Ala Ma KoTa",sc.changeCase("ala ma koTa","capitalize"));
        assertEquals("",sc.changeCase("","capitalize"));
    }

    @Test
    public void testInverse(){
        assertEquals("KerIm",sc.inverseCase("MirEk"));
        assertEquals("AtoK aM aLa",sc.inverseCase("Ala Ma KoTa"));
        assertEquals("",sc.inverseCase(""));
    }


}