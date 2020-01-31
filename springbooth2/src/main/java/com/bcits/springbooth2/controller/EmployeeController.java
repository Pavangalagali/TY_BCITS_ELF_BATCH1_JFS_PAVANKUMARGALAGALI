package com.bcits.springbooth2.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bcits.springbooth2.beans.EmployeeInfoBean;
import com.bcits.springbooth2.beans.EmployeeResponse;
import com.bcits.springbooth2.repository.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository repository;

	@GetMapping(path = "/getEmployee", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeInfoBean getEmployee(int empId) {
		Optional<EmployeeInfoBean> employee = repository.findById(empId);

		if (employee.isPresent()) {
			return employee.get();
		} else {
			return null;
		}
	}// end of getEmployee

	@PostMapping(path = "/addEmployee", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeInfoBean addEmployee(@RequestBody EmployeeInfoBean employeeInfoBean) {
		return repository.save(employeeInfoBean);

	}// end of addEmployee();

	@PutMapping(path = "/updateEmployee", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse updateEmployee(@RequestBody EmployeeInfoBean employeeInfoBean) {
		Optional<EmployeeInfoBean> optional = repository.findById(employeeInfoBean.getEmpId());
		EmployeeInfoBean infoBean = null;
		EmployeeResponse response = new EmployeeResponse();
		if (optional.isPresent()) {
			infoBean = repository.save(employeeInfoBean);
			response.setStatusCode(200);
			response.setMessage("success");
			response.setDescription("updated successfully");
			response.setEmployeeInfoBean(infoBean);
		} else {
			response.setStatusCode(400);
			response.setMessage("Failed");
		}
		return response;

	}// end of update Employee()

	@DeleteMapping(path = "/deleteEmployee", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse delete(int empId) {
		Optional<EmployeeInfoBean> optional = repository.findById(empId);
		EmployeeResponse response = new EmployeeResponse();
		if (optional.isPresent()) {
			repository.deleteById(empId);
			response.setStatusCode(200);
			response.setMessage("success");
			response.setDescription("Deleted successfully");
	
		} else {
			response.setStatusCode(400);
			response.setMessage("Failed");
			response.setDescription("Id not Found");
		}
		return response;
	
	}
}
