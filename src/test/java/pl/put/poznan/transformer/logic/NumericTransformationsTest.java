package pl.put.poznan.transformer.logic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumericTransformationsTest {
    private NumericTransformations liczby = null;
    private String wynik;

    @Before
    public void setUp() throws Exception{
        liczby = new NumericTransformations();
    }

    @After
    public void tearDown() throws Exception {
        liczby = null;
    }

    @Test
    public void testLiczbyNaSlowa() throws IllegalArgumentException {
        assertEquals("osiemset dziewięćdziesiąt sześć i trzydzieści cztery setne ", liczby.LiczbyNaSlowa(896.34));
    }

    @Test
    public void testLiczbyNaSlowaJednaSetna() throws IllegalArgumentException {
        assertEquals("jedna setna ", liczby.LiczbyNaSlowa(0.01));
    }

    @Test
    public void testLiczbyNaSlowaZero() throws IllegalArgumentException {
        assertEquals("zero", liczby.LiczbyNaSlowa(0));
    }

    @Test
    public void testLiczbyNaSlowaUpperBound() throws IllegalArgumentException {
        assertEquals("tysiąc ", liczby.LiczbyNaSlowa(1000));
    }

    @Test (expected=IllegalArgumentException.class)
    public void testLiczbyNaSlowaAboveUpperBound() {
        wynik = liczby.LiczbyNaSlowa(1000.01);
    }

    @Test
    public void testLiczbyNaSlowaBelowUpperBound() {
        assertEquals("dziewięćset dziewięćdziesiąt dziewięć i dziewięćdziesiąt dziewięć setnych ", liczby.LiczbyNaSlowa(999.99));
    }

    @Test
    public void testLiczbyNaSlowaLowerBound() throws IllegalArgumentException {
        assertEquals("minus tysiąc ", liczby.LiczbyNaSlowa(-1000));
    }

    @Test
    public void testLiczbyNaSlowaAboveLowerBound() {
        assertEquals("minus dziewięćset dziewięćdziesiąt dziewięć i dziewięćdziesiąt dziewięć setnych ", liczby.LiczbyNaSlowa(-999.99));
    }

    @Test (expected=IllegalArgumentException.class)
    public void testLiczbyNaSlowaBelowLowerBound() {
        wynik = liczby.LiczbyNaSlowa(-1000.01);
    }

    @Test (expected=IllegalArgumentException.class)
    public void testLiczbyNaSlowaTooMuchDecimals() {
        wynik = liczby.LiczbyNaSlowa(5.987);
    }

}