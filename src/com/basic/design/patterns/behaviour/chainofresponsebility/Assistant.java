package com.basic.design.patterns.behaviour.chainofresponsebility;

public class Assistant implements LoanApprover{
    LoanApprover loanApprover;
    @Override
    public void handleRequest(Loan loan) {
        if (loan.getAmount()<5000){
            System.out.println("Approved by "+this.getClass().getSimpleName());
        }else{
            this.loanApprover.handleRequest(loan);
        }
    }
    @Override
    public void setNextHandler(LoanApprover loanApprover) {
        this.loanApprover=loanApprover;
    }
}
