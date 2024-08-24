package com.kh.laptopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.laptopshop.domain.Roles;
import java.util.List;

public interface RoleRepository extends JpaRepository<Roles, Long> {
    Roles findRoleByName(String name);

}
