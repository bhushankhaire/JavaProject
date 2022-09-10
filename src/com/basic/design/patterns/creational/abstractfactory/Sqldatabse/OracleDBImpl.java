package com.basic.design.patterns.creational.abstractfactory.Sqldatabse;

import com.basic.design.patterns.creational.abstractfactory.Database;

public class OracleDBImpl implements Database {
    @Override
    public OracleDB createConnection() {
        OracleDB db=new OracleDB();
        db.createConnection();
        return db;
    }
}
