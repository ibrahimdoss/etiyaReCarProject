package com.etiya.reCapProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.etiya.reCapProject.entities.concretes.Customers;

@Repository
public interface CustomerDao extends JpaRepository<Customers, Integer> {
	
	
	@Query("Select c.findeksScore FROM Customers c Where c.customerId=:customerId")
	int getFindeksScoreByCustomerId(int customerId);
}
