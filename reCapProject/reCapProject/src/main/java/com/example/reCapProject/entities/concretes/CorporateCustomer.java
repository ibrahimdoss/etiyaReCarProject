package com.example.reCapProject.entities.concretes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Table(name="corporate_customers")
@Entity

public class CorporateCustomer extends Customer{
	
	@Column(name="tax_number")
	private String taxNumber;
	
	@Column(name="company_name")
	private String companyName;

	
	
}
