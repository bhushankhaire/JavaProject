package com.basic.design.patterns.creational.abstractfactory;

public interface AbstractDatabaseFactory {

    Database getDatabase(DBENUM dbenum);
}
