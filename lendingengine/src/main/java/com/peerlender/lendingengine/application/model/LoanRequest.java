package com.peerlender.lendingengine.application.model;

public class LoanRequest {
    private final int amount;
    private final long borrowerId;
    private final int daysToRepay;
    private final double interestRate;

    public LoanRequest(int amount, long borrowerId, int daysToRepay, double interestRate) {
        this.amount = amount;
        this.borrowerId = borrowerId;
        this.daysToRepay = daysToRepay;
        this.interestRate = interestRate;
    }

    public int getAmount() {
        return amount;
    }

    public long getBorrowerId() {
        return borrowerId;
    }

    public int getDaysToRepay() {
        return daysToRepay;
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + amount;
        result = prime * result + (int) (borrowerId ^ (borrowerId >>> 32));
        result = prime * result + daysToRepay;
        long temp;
        temp = Double.doubleToLongBits(interestRate);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LoanRequest other = (LoanRequest) obj;
        if (amount != other.amount)
            return false;
        if (borrowerId != other.borrowerId)
            return false;
        if (daysToRepay != other.daysToRepay)
            return false;
        if (Double.doubleToLongBits(interestRate) != Double.doubleToLongBits(other.interestRate))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "LoanRequest [amount=" + amount + ", borrowerId=" + borrowerId + ", daysToRepay=" + daysToRepay
                + ", interestRate=" + interestRate + "]";
    }

}
