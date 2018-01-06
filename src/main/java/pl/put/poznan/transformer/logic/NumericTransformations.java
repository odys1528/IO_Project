package pl.put.poznan.transformer.logic;


import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Performs translation from numbers to its names in Polish
 *
 */

public class NumericTransformations {

    /**
     * Translates number to name
     *
     * @param liczba
     *            number to be translated
     * @return String Returns name translated from the number
     * @throws IllegalArgumentException
     *             when the argument is less than -1000 or is more than 1000 or its decimal part is longer than 2
     */

    public static String LiczbyNaSlowa (double liczba) throws IllegalArgumentException {

        IllegalArgumentException ponadtysiac = new IllegalArgumentException("Przekroczono zakres liczby (powinna być ona mniejsza od 1000)");
        IllegalArgumentException zaDuzaDokladnosc = new IllegalArgumentException("Za duża dokładność (powinna być do części setnych)");

        String text = Double.toString(Math.abs(liczba));
        int decimalPlaces = text.length() - text.indexOf('.') - 1;

        if (Math.abs(liczba) > 1000){
            throw ponadtysiac;
        }

        if (decimalPlaces > 2){
            throw zaDuzaDokladnosc;
        }

        else{
            String[] jednosci = { "", "jeden ", "dwa ", "trzy ", "cztery ", "pięć ", "sześć ", "siedem ", "osiem ", "dziewięć ", };
            String[] nascie = { "", "jedenaście ", "dwanaście ", "trzynaście ", "czternaście ", "piętnaście ", "szesnaście ", "siedemnaście ", "osiemnaście ", "dziewiętnaście ", };
            String[] dziesiatki = { "", "dziesięć ", "dwadzieścia ", "trzydzieści ", "czterdzieści ", "pięćdziesiąt ", "sześćdziesiąt ", "siedemdziesiąt ", "osiemdziesiąt ", "dziewięćdziesiąt ", };
            String[] setki = { "", "sto ", "dwieście ", "trzysta ", "czterysta ", "pięćset ", "sześćset ", "siedemset ", "osiemset ", "dziewięćset ", };

            String[] ulamki = {"", "jeden ", "dwie ", "trzy ", "cztery ", "pięć ", "sześć ", "siedem ", "osiem ", "dziewięć ",};
            String[][] czesci = {{"dziesiąta ", "dziesiąte ", "dziesiątych "},
                    {"setna ",     "setne ",     "setnych "}};

            // INICJACJA ZMIENNYCH
            int j = 0, n = 0, d = 0, s = 0, t = 0, du = 0, nu = 0, ju = 0, p = 0, q = 0, x = 1; // jednosci, nascie, dziesiatki, setki, tysiac, dziesiatki ulamka, nascie ulamka, setne ulamka;
            String slownie = "" , znak = "", liczbastr = liczba + "";


            String ulamekstr = liczbastr.substring(liczbastr.indexOf('.')+1);
            int ulamek = Integer.parseInt(ulamekstr);

            // ZNAK
            if (liczba < 0) {
                znak = "minus ";
                liczba = Math.abs(liczba); // bierzemy wartość bezwzględną
            }

            if (liczba == 0) {
                znak = "zero";
            }
            if (Math.floor(liczba) == 0) {
                x = 0;
            }

            else {
                t = (int)(Math.floor( liczba/1000 ));
                s = (int)(Math.floor( liczba % 1000 / 100 ));
                d = (int)(Math.floor( liczba % 100 / 10 ));
                j = (int)(Math.floor( liczba % 10 ));

                if (d == 1 & j > 0) // liczby > 10 i < 20 (naście)
                {
                    n = j;
                    d = 0;
                    j = 0;
                }

                if (t == 1){ slownie = "tysiąc ";}
                slownie = slownie + setki[s] + dziesiatki[d] + nascie[n] + jednosci[j];

            }


            if (ulamek != 0){
                if (ulamek % 10 ==0){
                    ulamek = ulamek/10;
                    p = 1;
                }

                du  = (int)Math.floor(ulamek / 10);
                ju  = (int)(Math.floor(ulamek % 10));

                if (ulamekstr.substring(0,1).equals("0")){
                    p = 1;
                }

                if (du == 1 & ju > 0) // liczby > 10 i < 20 (naście)
                {
                    nu = j;
                    du = 0;
                    ju = 0;
                }

                if (x == 1){
                    slownie = slownie + "i ";
                }

                if (ulamek == 1) {
                    slownie = slownie + "jedna " + czesci[p][0];
                }

                else{
                    if (du + nu >0){ p = 1;}
                    if (ju >4 || ju==1 || nu >0){ q = 2; }
                    else { q = 1; }
                    slownie = slownie + dziesiatki[du] + nascie[nu] + ulamki[ju] + czesci[p][q];
                }
            }

            slownie = znak + slownie;

            return slownie;
        }
    }

    /**
     * This is the main method which makes use of LiczbyNaSlowa method.
     * @param args unused
     * @return nothing
     */

//    public static void main(String[] args) {
//        Scanner skaner = new Scanner(System.in);
//        boolean isNotNumber = true;
//
//        do {
//            try {
//                System.out.println("Wprowadź liczbę!");
//                double liczba = skaner.nextDouble();
//                System.out.println(Liczby.LiczbyNaSlowa(liczba));
//                isNotNumber = false;
//            } catch (InputMismatchException ime) {
//                System.err.println("Zły format danych!");
//                skaner.nextLine();
//                System.out.println("Wprowadź dane powownie");
//            } catch (IllegalArgumentException iae) {
//                System.err.println(iae.getMessage());
//                skaner.nextLine();
//                System.out.println("Wprowadź dane powownie");
//            }
//
//        } while (isNotNumber);
//        skaner.close();
//    }




}

