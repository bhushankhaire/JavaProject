package com.basic.design.patterns.creational.abstractfactory.noSqldatabase;

import com.basic.design.patterns.creational.abstractfactory.Database;

public class RedisDBImpl implements Database {
    @Override
    public RedisDB createConnection() {
        RedisDB db=new RedisDB();
        db.createConnection();
        return db;
    }
}
