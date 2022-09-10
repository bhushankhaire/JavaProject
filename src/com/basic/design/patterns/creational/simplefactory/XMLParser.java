package com.basic.design.patterns.creational.simplefactory;

import java.io.Reader;

public class XMLParser implements Parser {
    @Override
    public void parse(Reader reader) {

        System.out.println("parsing xml file");
    }
}
