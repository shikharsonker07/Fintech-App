package com.peerlender.lendingengine.application;

import java.util.List;

import com.peerlender.lendingengine.application.model.LoanRequest;
import com.peerlender.lendingengine.domain.model.LoanApplication;
import com.peerlender.lendingengine.domain.model.User;
import com.peerlender.lendingengine.domain.repository.LoanApplicationRepository;
import com.peerlender.lendingengine.domain.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

    private final LoanApplicationRepository loanApplicationRepository;
    private final UserRepository userRepository;

    @Autowired
    public LoanController(LoanApplicationRepository loanApplicationRepository, UserRepository userRepository) {
        this.loanApplicationRepository = loanApplicationRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/loan/request")
    public void addLoadRequest(@RequestBody final LoanRequest loanRequest) {
        User borrower = userRepository.getById(loanRequest.getBorrowerId());
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
