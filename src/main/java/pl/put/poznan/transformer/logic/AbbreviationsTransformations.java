package pl.put.poznan.transformer.logic;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * An object of this class should be used to edit text: make abbreviations or expand them
 * Abbreviations are based on data read from file and stored in HashMaps:
 *  abbr(used to abbreviate whole words)
 *  exp(used to expand abbreviations into whole words)
 * String sequence is the text to be tranformed
 *
 * @author mw121
 */
public class AbbreviationsTransformations {

    private HashMap<String, String> abbr;
    private HashMap<String, String> exp;
    private String sequence;

    public AbbreviationsTransformations() {
        abbr = new HashMap<>();
        exp = new HashMap<>();
        readFile("skroty.csv");
    }

    public AbbreviationsTransformations(String sequence) {
        abbr = new HashMap<>();
        exp = new HashMap<>();
        readFile("skroty.csv");
        this.sequence = sequence;
    }

    /**
     * reads abbrevations and their meaning and puts the data into HashMaps
     * (abbr and exp) for later use; data in the file should be written
     * according to the pattern: abbreviation.;meaning for instance: n.;noun All
     * letter should be in lower case.
     *
     * @param csvFile -name of file to read data from
     * @return 0 if succeds, -1 if fails
     */
    public int readFile(String csvFile) {
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] words = line.split(cvsSplitBy);
                this.getAbbr().put(words[1], words[0]);
                this.getExp().put(words[0], words[1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return 0;
    }

    /**
     * checks if original words starts with upper letters and changes the result
     * of transofrmation accordingly if the tranfsormation expands an
     * abbreviation, only the result's first word would be affected
     *
     * @param oryginal - words to tranform in the original form
     * @param result - words that oryginal is going to tranform into
     * @return final form of transformed result
     */
    public String getWord(String oryginal, String result) {
        String[] words = oryginal.split(" ");
        char[] results = result.toCharArray();
        boolean[] upper = new boolean[words.length];
        for (int i = 0; i < words.length; i++) {
            if (Character.isUpperCase(words[i].toCharArray()[0]) == true) {
                results[i] = Character.toUpperCase(results[i]);
            }
        }
        return new String(results);
    }

    /**
     * iterates through given HashMap and checks if string to be tranformed
     * contains any of words that are stored by the HashMap; if one word is
     * found, it is then tranformed according to data stored in the HashMap
     *
     * @param map - contains all pair that are possible to tranform
     * @return 1 if a word is found and transformed, 0 otherwise
     */
    public int findAndChange(HashMap<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String s_lower = sequence.toLowerCase();
            int intIndex = s_lower.indexOf(key);
            if (intIndex > -1) {
                String w = map.get(key);
                String word = getWord(sequence.substring(intIndex, intIndex + key.length()), w);
                sequence = sequence.substring(0, intIndex) + word + sequence.substring(intIndex + key.length());
                return 1;
            }
        }
        return 0;
    }

    /**
     * finds full words in the given sentence and transforms them into abbreviations
     * @param s - sentence to be tranformed
     * @return tranformed sequence
     */
    public String abbreviate(String s) {
        setSequence(s);
        while (findAndChange(abbr) == 1) {
        }
        return sequence;
    }

    /**
     * finds abbreviations in the given sentence and transforms them into full words
     * @param s - sentence to be tranformed
     * @return tranformed sequence
     */
    public String expand(String s) {
        setSequence(s);
        while (findAndChange(exp) == 1){}
        return sequence;
    }

    /**
     * @return the abbr
     */
    public HashMap<String, String> getAbbr() {
        return abbr;
    }

    /**
     * @return the exp
     */
    public HashMap<String, String> getExp() {
        return exp;
    }

    /**
     * @return the sequence
     */
    public String getSequence() {
        return sequence;
    }

    /**
     * @param sequence the sequence to set
     */
    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

}