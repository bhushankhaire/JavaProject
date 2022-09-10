package com.basic.design.patterns.behaviour.chainofresponsebility;

public interface LoanApprover {
    void handleRequest(Loan loan);
    void setNextHandler(LoanApprover loanApprover);
}
