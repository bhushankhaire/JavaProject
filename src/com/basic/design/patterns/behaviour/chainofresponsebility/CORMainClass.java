package com.basic.design.patterns.behaviour.chainofresponsebility;

public class CORMainClass {
    public static void main(String[] args) {
        Loan loan=new Loan(1000d);
        LoanApprover assistant=new Assistant();
        LoanApprover manager=new Manager();
        assistant.setNextHandler(manager);
        assistant.handleRequest(loan);

        loan=new Loan(10000d);
        assistant.handleRequest(loan);
    }

}
