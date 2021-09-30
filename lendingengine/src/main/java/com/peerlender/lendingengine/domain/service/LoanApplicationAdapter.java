package com.peerlender.lendingengine.domain.service;

import java.util.Optional;

import com.peerlender.lendingengine.application.model.LoanRequest;
import com.peerlender.lendingengine.domain.exception.UserNotFoundException;
import com.peerlender.lendingengine.domain.model.LoanApplication;
import com.peerlender.lendingengine.domain.model.User;
import com.peerlender.lendingengine.domain.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanApplicationAdapter {

    private final UserRepository userRepository;

    @Autowired
    public LoanApplicationAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public LoanApplication transform(LoanRequest loanRequest) {
        Optional<User> borrowerOptional = userRepository.findById(loanRequest.getBorrowerId());
        if (borrowerOptional.isPresent() == false) {
            throw new UserNotFoundException(loanRequest.getBorrowerId());
        } else {
            return new LoanApplication(loanRequest.getAmount(), borrowerOptional.get(), loanRequest.getInterestRate(),
                    loanRequest.getDaysToRepay());
        }
    }
}
