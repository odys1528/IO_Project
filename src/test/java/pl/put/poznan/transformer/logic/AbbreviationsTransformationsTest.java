package pl.put.poznan.transformer.logic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AbbreviationsTransformationsTest {
    AbbreviationsTransformations a;

    public AbbreviationsTransformationsTest() {
    }

    @Before
    public void setUp() {
        a = new AbbreviationsTransformations();
    }

//    @Test
//    public void test1() {
//        assertEquals("WF", a.abbreviate("WYCHOWANIE FIZYCZNE"));
//    }

    @Test
    public void test2() {
        assertEquals( "Wf.", a.abbreviate("Wf."));
    }

//    @Test
//    public void test3() {
//        assertEquals("Tj. wf", a.abbreviate("To jest wychowanie fizyczne"));
//    }
//
//    @Test
//    public void test4() {
//        assertEquals("Teraz wf", a.abbreviate("Teraz wychowanie fizyczne"));
//    }
//
//
//    @Test
//    public void test5() {
//        assertEquals("Curriculum vitae ", a.expand("CV "));
//    }
//
//    @Test
//    public void test6() {
//        assertEquals( "doktor", a.expand("dr"));
//    }
//
//    @Test
//    public void test7() {
//        assertEquals("To doktor Kowalski", a.expand("To dr Kowalski"));
//    }
//
//    @Test
//    public void test8() {
//        assertEquals("To znaczy doktor", a.expand("Tzn. dr"));
//    }

}