package com.leave.leaveproject.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leave.leaveproject.beans.Employee;
import com.leave.leaveproject.exceptions.ApplicationException;
import com.leave.leaveproject.repository.EmployeeRepository;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.service.Contact;

@RestController
@RequestMapping("/api/")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("employee")
	@ApiOperation(value="Retrieve all employee details", response = Contact.class)
	public ResponseEntity<List<Employee>> getEmployee(){
		List<Employee> employee = (List<Employee>) employeeRepository.findAll();
		
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
	@PostMapping("employee")
	public ResponseEntity addEmployee(@RequestBody Employee employee) throws ApplicationException {
		System.out.println(employee.getFirstName());
		System.out.println(employee.getMiddleName());
		System.out.println(employee.getLastName());
		System.out.println(employee.getDateOfBirth());
		System.out.println(employee.getGender());
		System.out.println(employee.getJoiningDate());
		System.out.println(employee.getLeavingDate());
		System.out.println(employee.getStatus());
		System.out.println(employee.getLocation());		

		try {
			employeeRepository.save(employee);
			return new ResponseEntity<>(employee.getFirstName() + " " + employee.getMiddleName() + " " + employee.getLastName() + " has been added successfully.", HttpStatus.OK);
		} catch (Exception e) {
			throw new ApplicationException("Unable to store employee details.");
		}

	}
	
	@PutMapping("employee/{id}")
	public ResponseEntity updateDepartment(@PathVariable("id") int id, @RequestBody Employee employee) {
		Employee employees = employeeRepository.searchByID(id);
		if (employees != null) {
			employees.setFirstName(employee.getFirstName());
			employees.setMiddleName(employee.getMiddleName());
			employees.setLastName(employee.getLastName());
			employees.setDateOfBirth(employee.getDateOfBirth());
			employees.setGender(employee.getGender());
			employees.setJoiningDate(employee.getJoiningDate());
			employees.setLeavingDate(employee.getLeavingDate());
			employees.setStatus(employee.getStatus());
			employees.setLocation(employee.getLocation());	
			try {
				employeeRepository.save(employees);
				return new ResponseEntity<>(employee.getFirstName() + " " + employee.getMiddleName() + " " + employee.getLastName() + " details have been updated successfully.",
						HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>("Unable to update department details.", HttpStatus.ACCEPTED);
			}

		} else {
			return new ResponseEntity<>("Department detail is not found.", HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("employee/{id}")
	public ResponseEntity removeUser(@PathVariable("id") int id) {
		Employee employee = employeeRepository.searchByID(id);
		System.out.println(employee);
		if (employee != null) {
			try {
				employeeRepository.deleteById(id);
				return new ResponseEntity<>(employee.getFirstName() + " " + employee.getMiddleName() + " " + employee.getLastName() + " has been removed.", HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>("Unable to remove department from database", HttpStatus.FORBIDDEN);
			}
		} else {
			return new ResponseEntity<>("Department detail is not found.", HttpStatus.NOT_FOUND);
		}
	}
	
	
	

}
