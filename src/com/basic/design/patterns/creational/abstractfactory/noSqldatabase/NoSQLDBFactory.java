package com.basic.design.patterns.creational.abstractfactory.noSqldatabase;

import com.basic.design.patterns.creational.abstractfactory.AbstractDatabaseFactory;
import com.basic.design.patterns.creational.abstractfactory.DBENUM;
import com.basic.design.patterns.creational.abstractfactory.Database;

public class NoSQLDBFactory implements AbstractDatabaseFactory {
    Database db=null;
    public Database getDatabase(DBENUM dbenum){
        switch(dbenum){
            case REDIS:
                db=new RedisDBImpl();
                break;
            case MONGO:
                db=new MongoDBImpl();
                break;
        }
        return db;
    }

    public static void main(String[] args) {
        NoSQLDBFactory factory=new NoSQLDBFactory();

        RedisDB redisDB= (RedisDB) factory.getDatabase(DBENUM.REDIS).createConnection();

        MongoDB mongoDB= (MongoDB) factory.getDatabase(DBENUM.MONGO).createConnection();
    }

}
