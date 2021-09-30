package com.peerlender.lendingengine.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public final class LoanApplication {
    @Id
    private long id;
    private int amount;
    @ManyToOne
    private User borrower;
    private int repaymentTermInDays;
    private double interestRate;

    public LoanApplication() {
    }

    public LoanApplication(int amount, User borrower, double interestRate, int repaymentTermInDays) {
        this.amount = amount;
        this.borrower = borrower;
        this.interestRate = interestRate;
        this.repaymentTermInDays = repaymentTermInDays;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public User getBorrower() {
        return borrower;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public int getrepaymentTermInDays() {
        return repaymentTermInDays;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + amount;
        result = prime * result + ((borrower == null) ? 0 : borrower.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        long temp;
        temp = Double.doubleToLongBits(interestRate);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + repaymentTermInDays;
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
        LoanApplication other = (LoanApplication) obj;
        if (amount != other.amount)
            return false;
        if (borrower == null) {
            if (other.borrower != null)
                return false;
        } else if (!borrower.equals(other.borrower))
            return false;
        if (id != other.id)
            return false;
        if (Double.doubleToLongBits(interestRate) != Double.doubleToLongBits(other.interestRate))
            return false;
        if (repaymentTermInDays != other.repaymentTermInDays)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "LoanRequest [amount=" + amount + ", borrower=" + borrower + ", id=" + id + ", interestRate="
                + interestRate + ", repaymentTermInDays=" + repaymentTermInDays + "]";
    }

}
