package org.example;

import java.io.FileNotFoundException;

public class DictionaryNumber extends Dictionary<String, String>{

    public DictionaryNumber(String pathToDictionary) throws FileNotFoundException {
        super(pathToDictionary);
    }

    public String findByKey(String key) throws IllegalArgumentException{
        checkEntryRules(key);
        return super.findByKey(key);
    }


    public String putWord(String key, String value) throws IllegalArgumentException{
        checkEntryRules(key);
        checkEntryRules(value);
        return super.putWord(key, value);
    }


    public String deleteByKey(String key) throws IllegalArgumentException{
        checkEntryRules(key);
        return super.deleteByKey(key);
    }

    private Integer checkEntryRules(String wordTested) throws IllegalArgumentException{
        Integer intWordTested = stringToInteger(wordTested);

        if (intWordTested < 100000 && intWordTested >= 10000){
            return intWordTested;
        }
        throw new IllegalArgumentException("Введи число по правилам, будь человеком :)");
    }

    private Integer stringToInteger(String line) throws IllegalArgumentException{
        try {
           return Integer.parseInt(line);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("оу, а это не число");
        }
    }
}
