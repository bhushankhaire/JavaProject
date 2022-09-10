package com.basic.examples;

public class EnumInSwitch {


    public static void main(String args[]) {

        Day[] daysOfWeek = Day.values();

        for (Day today : daysOfWeek) {

            //Using Enum in Switch case statement

            switch (today) {
                case MONDAY:
                    System.err.println("Today is Monday learn example of How to use Java Enum in Switch");
                    break;
                case TUESDAY:
                    System.err.println("Tuesday, apply Enum in Switch just link primitive int");
                    break;
                case WEDNESDAY:
                    System.err.println("Wednesday, I confirm Java Enum can be used in Switch case");
                    break;
                case THURSDAY:
                    System.err.println("Thursday, Java Enum values() method return all enum in an array");
                    break;
                case FRIDAY:
                    System.err.println("Friday, Enum can also be used in case statement");
                    break;
                case SATURDAY:
                    System.err.println("Saturday, Enum in Java are compile time constant");
                    break;
                case SUNDAY:
                    System.err.println("Sunday, Using Enum in Switch is very easy");
                    break;

            }
        }
    }
}
