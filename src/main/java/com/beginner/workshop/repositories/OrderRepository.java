package com.beginner.workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beginner.workshop.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
