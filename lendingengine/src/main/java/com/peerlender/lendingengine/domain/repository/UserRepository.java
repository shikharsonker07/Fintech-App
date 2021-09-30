package com.peerlender.lendingengine.domain.repository;

import com.peerlender.lendingengine.domain.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
