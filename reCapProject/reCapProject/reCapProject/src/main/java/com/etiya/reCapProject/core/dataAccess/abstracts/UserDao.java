package com.etiya.reCapProject.core.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.etiya.reCapProject.core.entities.concretes.Users;

@Repository
public interface UserDao extends JpaRepository<Users, Integer> {

}
