package com.leave.leaveproject.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.leave.leaveproject.beans.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer> {

	@Query("select d from Department d where d.id= :id")
	public Department searchByID(@Param("id") int id);
}
