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

import com.leave.leaveproject.beans.Leave;
import com.leave.leaveproject.exceptions.ApplicationException;
import com.leave.leaveproject.repository.LeaveRepository;

@RestController
@RequestMapping("/api/")
public class LeaveController {

	@Autowired
	private LeaveRepository leaveRepository;
	
	@GetMapping("leave")
	public ResponseEntity<List<Leave>> leaveList(){
		List<Leave> leave = (List<Leave>) leaveRepository.findAll();
		
		return new ResponseEntity<>(leave, HttpStatus.OK);
	}
	
	@PostMapping("leave")
	public ResponseEntity addLeave(@RequestBody Leave leave) throws ApplicationException {
		System.out.println(leave.getFromDate());
		System.out.println(leave.getToDate());
		System.out.println(leave.getNumberOfDays());
		System.out.println(leave.getRequestedBy());

		try {
			leaveRepository.save(leave);
			return new ResponseEntity<>(leave.getRequestedBy() + " leave has been submitted successfully.", HttpStatus.OK);
		} catch (Exception e) {
			throw new ApplicationException("Unable to store leave details.");
		}

	}
	
	@PutMapping("leave/{id}")
	public ResponseEntity updateDepartment(@PathVariable("id") int id, @RequestBody Leave leave) {
		Leave leaves = leaveRepository.searchByID(id);
		if (leaves != null) {
			leaves.setFromDate(leave.getFromDate());
			leaves.setToDate(leave.getToDate());
			leaves.setNumberOfDays(leave.getNumberOfDays());
			leaves.setRequestedBy(leave.getRequestedBy());	
			try {
				leaveRepository.save(leaves);
				return new ResponseEntity<>(leave.getRequestedBy()+ " leave request has been updated successfully.",
						HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>("Unable to update leave request details.", HttpStatus.ACCEPTED);
			}

		} else {
			return new ResponseEntity<>("Leave requester detail is not found.", HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("leave/{id}")
	public ResponseEntity removeUser(@PathVariable("id") int id) {
		Leave leave = leaveRepository.searchByID(id);
		System.out.println(leave);
		if (leave != null) {
			try {
				leaveRepository.deleteById(id);
				return new ResponseEntity<>("Leave request has been removed.", HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>("Unable to remove department from database", HttpStatus.FORBIDDEN);
			}
		} else {
			return new ResponseEntity<>("Department detail is not found.", HttpStatus.NOT_FOUND);
		}
	}

}
