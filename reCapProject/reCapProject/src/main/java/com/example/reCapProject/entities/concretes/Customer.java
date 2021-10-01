package com.example.reCapProject.entities.concretes;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler","rentals"})
@Table(name="customers")
//@PrimaryKeyJoinColumn(name="user_id")

public class Customer extends ApplicationUser {
	
	
	@JsonIgnore
	@OneToMany(mappedBy="customer")
	private List<CreditCard> creditCards;
	
    @JsonIgnore
    @OneToMany(mappedBy="customer")
    private List<Rental> rentals;
    

   
    

}
