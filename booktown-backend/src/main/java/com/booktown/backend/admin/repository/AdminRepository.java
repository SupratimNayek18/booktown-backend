package com.booktown.backend.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.booktown.backend.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
	@Query("select admin from Admin admin where admin.username=:username")
	public Admin findByUsername(@Param("username") String username);

}
