package com.etiya.reCapProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.etiya.reCapProject.entities.concretes.ApplicationUser;

@Repository
public interface ApplicationUserDao extends JpaRepository<ApplicationUser, Integer> {
	
	@Query("Select a.eMail From ApplicationUser a")
	List<String> getEmail();
}
