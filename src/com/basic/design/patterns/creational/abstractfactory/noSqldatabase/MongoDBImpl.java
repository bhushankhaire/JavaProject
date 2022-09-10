package com.basic.design.patterns.creational.abstractfactory.noSqldatabase;

import com.basic.design.patterns.creational.abstractfactory.Database;

public class MongoDBImpl implements Database {
    @Override
    public MongoDB createConnection() {
        MongoDB db=new MongoDB();
        db.createConnection();
        return db;
    }
}
