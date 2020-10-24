package com.luv2code.springboot.thymleafdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.luv2code.springboot.thymleafdemo.entity.Record;

public interface RecordRepository extends JpaRepository<Record, Integer> {

	@Query(value="select done from record u where u.id =:userId", nativeQuery=true)
	boolean getDoneById(@Param("userId") String userId);
}
