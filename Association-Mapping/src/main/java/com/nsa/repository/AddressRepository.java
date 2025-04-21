package com.nsa.repository;

import com.nsa.entity.Address;
import com.nsa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
