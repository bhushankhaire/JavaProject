package com.basic.design.patterns.behaviour.chainofresponsebility;

public class Manager implements LoanApprover{
    LoanApprover loanApprover;
    @Override
    public void handleRequest(Loan loan) {
        if (loan.getAmount()<50000){
            System.out.println("Approved by "+this.getClass().getSimpleName());
        }else{
            System.out.println("Loan cannot be provided");
        }
    }
    @Override
    public void setNextHandler(LoanApprover loanApprover) {
        this.loanApprover=loanApprover;
    }
}
