package com.booktown.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.booktown.backend.entity.UserCredentials;

public interface UserCredentialsRepository extends JpaRepository<UserCredentials, Integer>{
	
	@Query("select uc from UserCredentials uc where uc.username=:username")
	public UserCredentials findByUsername(@Param(value="username") String username);
	
}
