package com.basic.design.patterns.creational.abstractfactory.Sqldatabse;

import com.basic.design.patterns.creational.abstractfactory.Database;

public class MySqlDBImpl implements Database {
    @Override
    public MySqlDB createConnection() {
        MySqlDB mySqlDB=new MySqlDB();
        mySqlDB.createConnection();
        return mySqlDB;
    }
}
