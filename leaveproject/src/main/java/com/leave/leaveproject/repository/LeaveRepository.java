package com.leave.leaveproject.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.leave.leaveproject.beans.Leave;

public interface LeaveRepository extends CrudRepository<Leave, Integer> {
	
	@Query("select l from Leave l where l.requestedBy= :id")
	public Leave searchByID(@Param("id") int id);
}
