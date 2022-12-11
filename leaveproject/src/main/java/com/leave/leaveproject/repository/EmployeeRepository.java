package com.leave.leaveproject.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.leave.leaveproject.beans.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

	@Query("select e from Employee e where e.id= :id")
	public Employee searchByID(@Param("id") int id);
}
