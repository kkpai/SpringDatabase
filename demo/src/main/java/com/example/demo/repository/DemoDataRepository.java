package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.UserData;

import jakarta.transaction.Transactional;

public interface DemoDataRepository extends JpaRepository<UserData, Integer> 
{
	
	@Transactional
	@Modifying
	@Query("update UserData u set u.name = ?1 where u.id = ?2")
	int updateUserData(String name, int id);

}
