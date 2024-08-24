package com.kh.laptopshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kh.laptopshop.domain.Roles;
import com.kh.laptopshop.domain.User;
import com.kh.laptopshop.domain.dto.RegisterDTO;
import com.kh.laptopshop.repository.RoleRepository;
import com.kh.laptopshop.repository.UserRepository;

@Service
public class UserService {
  private final UserRepository userRepository;
  private final RoleRepository roleRepository;

  public UserService(UserRepository userRepository, RoleRepository roleRepository) {
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
  }

  public List<User> getAllUsers() {
    return this.userRepository.findAll();
  }

  public void handleSaveUser(User user) {
    userRepository.save(user);
  }

  public User getUserById(Long id) {
    return this.userRepository.findOneById(id);
  }

  public void deleteUserById(Long id) {
    this.userRepository.deleteById(id);
  }

  public Roles getRoleByName(String name) {
    return this.roleRepository.findRoleByName(name);
  }

  public User getUserByEmail(String email) {
    return this.userRepository.findByEmail(email);
  }

  public User registerDTOtoUser(RegisterDTO registerDTO) {
    User user = new User();
    user.setFullName(registerDTO.getFirstName() + " " + registerDTO.getLastName());
    user.setEmail(registerDTO.getEmail());
    user.setPassword(registerDTO.getPassword());
    return user;
  }

  public boolean checkEmailExist(String email) {
    return this.userRepository.existsByEmail(email);
  }
}
