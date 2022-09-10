package com.basic.design.patterns.creational.abstractfactory;

import com.basic.design.patterns.creational.abstractfactory.noSqldatabase.NoSQLDBFactory;
import com.basic.design.patterns.creational.abstractfactory.Sqldatabse.SQLDBFactory;

public class DatabaseFactoryProvider {
    static AbstractDatabaseFactory getFactory(DBENUM dbenum) {
        AbstractDatabaseFactory factory = null;

        switch (dbenum) {
            case SQLDB:
                factory = new SQLDBFactory();
                break;
            case NOSQLDB:
                factory = new NoSQLDBFactory();
                break;
        }
        return factory;
    }

    public static void main(String[] args) {
        DatabaseFactoryProvider.getFactory(DBENUM.SQLDB).getDatabase(DBENUM.ORACLE).createConnection();
        DatabaseFactoryProvider.getFactory(DBENUM.NOSQLDB).getDatabase(DBENUM.REDIS).createConnection();
    }
}
