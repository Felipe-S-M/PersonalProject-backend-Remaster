package com.fixingsolutions.ocupation.repository;

import com.fixingsolutions.ocupation.entity.Ocupation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OcupationRepository extends JpaRepository<Ocupation, Long> {
}
