package com.aibek.finalspring.repository;

import com.aibek.finalspring.entity.NationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NationRepo extends JpaRepository<NationEntity,Long> {
}
