package com.basic.design.patterns.creational.simplefactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class ParserFactory {
     
    public static Parser getParser(String type){
        Parser parser = null;
        switch(type){
            case "JSON":
                parser=new JSONParser();
                break;
            case "XML":
                parser=new XMLParser();
                break;    
            
        }
        return parser;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Reader reader = new FileReader("file.txt");
        ParserFactory.getParser("JSON").parse(reader);
    }
}
