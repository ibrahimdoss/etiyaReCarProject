package com.etiya.reCapProject.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="customers")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","creditCards"})
public class Customers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	
	/*
	 * @Column(name="user_id") private int userId;
	 */
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="findeksScore")
	private int findeksScore;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private ApplicationUser applicationUser;
	
	@OneToMany(mappedBy = "customers")
	private List<CreditCard> creditCards;
	
	@JsonIgnore
	@OneToMany(mappedBy = "customers")
	private List<RentAl> rentAls;
}
