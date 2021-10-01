package com.etiya.reCapProject.entities.concretes;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.etiya.reCapProject.entities.abstracts.Customer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="rentals")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})

public class RentAl {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="rental_id")
	private int rentAlId;
	
	/*
	 * @Column(name="car_id") private int carId;
	 */
	
	/*
	 * @Column(name="customer_id") private int customerId;
	 */
	
	@Column(name="rent_date")
	private Date rentDate;
	
	@Column(name="return_date")
	private Date returnDate;
	
	@Column(name="take_city")
	private String takeCity;
	
	@Column(name="start_kilometer")
	private int startKilometer;
	
	@Column(name="end_kilometer")
	private int endKilometer;
	
	@Column(name="return_city")
	private String returnCity;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customers;
	
	@ManyToOne
	@JoinColumn(name="car_id")
	private Car car;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="invoice_id")
	private Invoice invoice;
	

	
}
