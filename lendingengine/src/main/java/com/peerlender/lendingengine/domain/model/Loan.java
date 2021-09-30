package com.peerlender.lendingengine.domain.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Loan {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private User borrower;
    @ManyToOne
    private User lender;
    private int amount;
    private double interestRate;
    private LocalDate dateLent;
    private LocalDate dateDue;

    public Loan() {
    }

    public Loan(User lender, LoanApplication loanApplication) {
        this.borrower = loanApplication.getBorrower();
        this.lender = lender;
        this.amount = loanApplication.getAmount();
        this.interestRate = loanApplication.getInterestRate();
        this.dateLent = LocalDate.now();
        this.dateDue = LocalDate.now().plusDays(loanApplication.getrepaymentTermInDays());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getBorrower() {
        return borrower;
    }

    public void setBorrower(User borrower) {
        this.borrower = borrower;
    }

    public User getLender() {
        return lender;
    }

    public void setLender(User lender) {
        this.lender = lender;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public LocalDate getDateLent() {
        return dateLent;
    }

    public void setDateLent(LocalDate dateLent) {
        this.dateLent = dateLent;
    }

    public LocalDate getDateDue() {
        return dateDue;
    }

    public void setDateDue(LocalDate dateDue) {
        this.dateDue = dateDue;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + amount;
        result = prime * result + ((borrower == null) ? 0 : borrower.hashCode());
        result = prime * result + ((dateDue == null) ? 0 : dateDue.hashCode());
        result = prime * result + ((dateLent == null) ? 0 : dateLent.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        long temp;
        temp = Double.doubleToLongBits(interestRate);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((lender == null) ? 0 : lender.hashCode());
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
        Loan other = (Loan) obj;
        if (amount != other.amount)
            return false;
        if (borrower == null) {
            if (other.borrower != null)
                return false;
        } else if (!borrower.equals(other.borrower))
            return false;
        if (dateDue == null) {
            if (other.dateDue != null)
                return false;
        } else if (!dateDue.equals(other.dateDue))
            return false;
        if (dateLent == null) {
            if (other.dateLent != null)
                return false;
        } else if (!dateLent.equals(other.dateLent))
            return false;
        if (id != other.id)
            return false;
        if (Double.doubleToLongBits(interestRate) != Double.doubleToLongBits(other.interestRate))
            return false;
        if (lender == null) {
            if (other.lender != null)
                return false;
        } else if (!lender.equals(other.lender))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Loan [amount=" + amount + ", borrower=" + borrower + ", dateDue=" + dateDue + ", dateLent=" + dateLent
                + ", id=" + id + ", interestRate=" + interestRate + ", lender=" + lender + "]";
    }

}
