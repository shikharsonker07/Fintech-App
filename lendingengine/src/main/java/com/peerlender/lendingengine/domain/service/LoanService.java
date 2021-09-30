package com.peerlender.lendingengine.domain.service;

import java.util.List;
import java.util.Optional;

import com.peerlender.lendingengine.domain.exception.LoanApplicationNotFoundException;
import com.peerlender.lendingengine.domain.exception.UserNotFoundException;
import com.peerlender.lendingengine.domain.model.Loan;
import com.peerlender.lendingengine.domain.model.LoanApplication;
import com.peerlender.lendingengine.domain.model.User;
import com.peerlender.lendingengine.domain.repository.LoanApplicationRepository;
import com.peerlender.lendingengine.domain.repository.LoanRepository;
import com.peerlender.lendingengine.domain.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoanService {

    private final LoanApplicationRepository loanApplicationRepository;
    private final UserRepository userRepository;
    private final LoanRepository loanRepository;

    @Autowired
    public LoanService(LoanApplicationRepository loanApplicationRepository, UserRepository userRepository,
            LoanRepository loanRepository) {
        this.loanApplicationRepository = loanApplicationRepository;
        this.userRepository = userRepository;
        this.loanRepository = loanRepository;
    }

    public void acceptLoan(final long lenderId, final long loanApplicationId) {
        Optional<User> lenderOptional = userRepository.findById(lenderId);
        if (lenderOptional.isPresent() == false) {
            throw new UserNotFoundException(lenderId);
        }
        Optional<LoanApplication> loanAppOptional = loanApplicationRepository.findById(loanApplicationId);
        if (loanAppOptional.isPresent() == false) {
            throw new LoanApplicationNotFoundException(loanApplicationId);
        }
        User lender = lenderOptional.get();
        LoanApplication loanApplication = loanAppOptional.get();
        loanRepository.save(new Loan(lender, loanApplication));
    }

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }
}
