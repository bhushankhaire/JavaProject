package com.basic.design.patterns.creational.simplefactory;

import java.io.Reader;

public class JSONParser implements Parser{
    @Override
    public void parse(Reader reader) {
        System.out.println("parsing json file");
    }
}
