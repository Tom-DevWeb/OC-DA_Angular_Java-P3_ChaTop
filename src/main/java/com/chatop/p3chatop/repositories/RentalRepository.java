package com.chatop.p3chatop.repositories;

import com.chatop.p3chatop.entities.Rental;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepository extends CrudRepository<Rental, Integer> {
}
