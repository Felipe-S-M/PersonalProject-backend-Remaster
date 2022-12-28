package com.fixingsolutions.serviceOrder.repository;

import com.fixingsolutions.serviceOrder.entity.ServiceOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceOrderRepository extends JpaRepository<ServiceOrder, Integer> {
}
