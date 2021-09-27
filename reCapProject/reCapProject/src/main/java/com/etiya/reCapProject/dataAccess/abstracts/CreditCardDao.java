package com.etiya.reCapProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.etiya.reCapProject.entities.concretes.CreditCard;
import com.etiya.reCapProject.entities.concretes.Customer;

@Repository
public interface CreditCardDao extends JpaRepository<CreditCard, Integer> {
	
	Customer getByCustomer_id(int customerId);

	List<CreditCard> getCreditCardByCustomer_id(int customerId);
}
