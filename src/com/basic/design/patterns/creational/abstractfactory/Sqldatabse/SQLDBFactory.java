package com.basic.design.patterns.creational.abstractfactory.Sqldatabse;

import com.basic.design.patterns.creational.abstractfactory.AbstractDatabaseFactory;
import com.basic.design.patterns.creational.abstractfactory.Database;
import com.basic.design.patterns.creational.abstractfactory.DBENUM;

public class SQLDBFactory  implements AbstractDatabaseFactory {
    Database db=null;
    public Database getDatabase(DBENUM dbenum){
        switch(dbenum){
            case ORACLE:
                db=new OracleDBImpl();
                break;
            case MYSQL:
                db=new MySqlDBImpl();
                break;
        }
        return db;
    }

    public static void main(String[] args) {
        SQLDBFactory factory=new SQLDBFactory();

        MySqlDB mysqlDB= (MySqlDB) factory.getDatabase(DBENUM.MYSQL).createConnection();

        OracleDB oracleDB= (OracleDB) factory.getDatabase(DBENUM.ORACLE).createConnection();
    }

}
