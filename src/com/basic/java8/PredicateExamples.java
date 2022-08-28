package com.basic.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateExamples {

    public static void main(String[] args) {

        //Consumer example
        Consumer<String> consumer = s -> System.out.println(s);

        consumer.accept("Consumer accepts only inputs and does not return anything");

        //Predicate test condition
        Predicate<Integer> greaterThanTen = i -> i > 10;
        Predicate<Integer> lowerThanTwenty = i -> i < 20;

        Integer i = 15;
        //predicate chaining
        boolean result = greaterThanTen.and(lowerThanTwenty).test(i);
        System.out.println("i is greater then 10 and less then 20: " + result);
        // Calling Predicate method
        boolean result2 = greaterThanTen.and(lowerThanTwenty).negate().test(15);
        System.out.println(result2);
        //Calling predicate on List
        Predicate<Employee> predicate= e-> e.name.contains("B") || e.name.contains("b");
        List<Employee> list=new ArrayList<>();
        list.add(new Employee(1,"Bhushan"));
        list.add(new Employee(2,"Sagar"));
        list.add(new Employee(3,"Abhilash"));
        System.out.println(filterEmployeeListByName(list,predicate));

    }
    static List<Employee>  filterEmployeeListByName(List<Employee> list,Predicate<Employee> predicate){
        List<Employee> newList=new ArrayList<>();
        for(Employee e:list) {
            if(predicate.test(e)){
                newList.add(e);
            }
        }
        return newList;
    }
}
class Employee {

    int id;
    String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}