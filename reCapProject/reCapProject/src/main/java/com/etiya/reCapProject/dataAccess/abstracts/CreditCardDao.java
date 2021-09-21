package com.etiya.reCapProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etiya.reCapProject.entities.concretes.CreditCard;

public interface CreditCardDao extends JpaRepository<CreditCard, Integer> {

}
