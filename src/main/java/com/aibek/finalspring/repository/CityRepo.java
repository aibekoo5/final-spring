package com.aibek.finalspring.repository;

import com.aibek.finalspring.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepo extends JpaRepository<CityEntity, Long> {
}
