package com.leave.leaveproject.restcontrollers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leave.leaveproject.repository.DepartmentRepository;
import com.leave.leaveproject.beans.Department;
import com.leave.leaveproject.exceptions.ApplicationException;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.service.Contact;

@RestController
@RequestMapping("/api/")
public class DepartmentController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@GetMapping("department")
	@ApiOperation(value="Retrieve all department details", response = Contact.class)
	public ResponseEntity<List<Department>> getDepartmentList(){
		List<Department> department = (List<Department>) departmentRepository.findAll();
		return new ResponseEntity<>(department, HttpStatus.OK);
	}
	
	@PostMapping("department")
	public ResponseEntity addDepartment(@RequestBody Department department) throws ApplicationException {
		System.out.println(department.getName());
		LOGGER.trace("Entering the new department adding method...");
		LOGGER.info("Add New Department Method...");
		try {
			departmentRepository.save(department);
			return new ResponseEntity<>(department.getName() + " has been added successfully.", HttpStatus.OK);
		} catch (Exception e) {
			throw new ApplicationException("Unable to store department details.");
		}

	}
	
	@PutMapping("department/{id}")
	public ResponseEntity updateDepartment(@PathVariable("id") int id, @RequestBody Department department) {
		Department departments = departmentRepository.searchByID(id);
		if (departments != null) {
			departments.setName(department.getName());
			try {
				departmentRepository.save(departments);
				LOGGER.info("Updated the Department " + departments.getName());
				return new ResponseEntity<>(departments.getName() + " details have been updated successfully.",
						HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>("Unable to update department details.", HttpStatus.ACCEPTED);
			}

		} else {
			return new ResponseEntity<>("Department detail is not found.", HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("department/{id}")
	public ResponseEntity removeUser(@PathVariable("id") int id) {
		Department departments = departmentRepository.searchByID(id);
		System.out.println(departments);
		if (departments != null) {
			try {
				departmentRepository.deleteById(id);
				LOGGER.info("Removed Department " + departments.getName());
				return new ResponseEntity<>(departments.getName() + " has been removed.", HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>("Unable to remove department from database", HttpStatus.FORBIDDEN);
			}
		} else {
			return new ResponseEntity<>("Department detail is not found.", HttpStatus.NOT_FOUND);
		}
	}

}
