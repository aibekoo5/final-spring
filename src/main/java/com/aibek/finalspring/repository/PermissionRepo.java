package com.aibek.finalspring.repository;

import com.aibek.finalspring.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepo extends JpaRepository<Permission, Long> {
    Permission findByName(String name);
}
