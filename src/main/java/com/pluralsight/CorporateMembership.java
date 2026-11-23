package com.pluralsight;

import java.math.BigDecimal;

public class CorporateMembership extends Membership{

    private BigDecimal employerShare;

    public CorporateMembership(String memberName, int months, BigDecimal baseRate, BigDecimal employerShare) {
        super(memberName, months, baseRate);
        this.employerShare = employerShare;
    }

    @Override
    public BigDecimal getMonthlyPrice(){
        BigDecimal employeeShare = new BigDecimal("1.00");
        employeeShare = employeeShare.subtract(employerShare);

        return getBaseRate().multiply(employeeShare);
    }

    @Override
    public BigDecimal getSignUpFee(){
        return new BigDecimal("0.00");
    }

    @Override
    public String toString() {
        return "Family | " + getMemberName() + " | " + getMonths() +
                " months | employer share: " + employerShare.setScale(2);
    }
}
