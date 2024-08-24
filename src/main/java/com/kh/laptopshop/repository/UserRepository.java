package com.kh.laptopshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kh.laptopshop.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  User save(User user);

  List<User> findAll();

  User findOneById(Long id);

  void deleteById(Long id);

  User findByEmail(String email);

  boolean existsByEmail(String email);

}
