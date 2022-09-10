package com.basic.design.patterns.behaviour.observer;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    List<Stock> stock=new ArrayList<>();
    List<Observer> observers=new ArrayList<>();
    public List<Stock> getStock() {
        return stock;
    }
    public void setStock(Stock stock) {
        this.stock.add(stock);
        notifyObserver();
    }
    public void registerObserver( Observer observer){
        this.observers.add(observer);
    }
    public void deregisterObserver( Observer observer){
        this.observers.remove(observer);
    }
    public void notifyObserver() {
        observers.stream().forEach(o->o.update("Stock updated"));
    }

}
class Stock{
    public String name;
}