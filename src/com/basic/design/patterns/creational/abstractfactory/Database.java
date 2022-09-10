package com.basic.design.patterns.creational.abstractfactory;

public interface Database<T> {
   T createConnection();
}
