package com.bcits.springboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bcits.springboot.beans.EmployeeInfoBean;
import com.bcits.springboot.beans.EmployeeResponse;
import com.bcits.springboot.service.EmployeeService;



@RestController
public class EmployeeRestController {

	@Autowired
	private EmployeeService service;

	@GetMapping(path = "/getEmployee", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponse getEmployee(int empId) {

		EmployeeInfoBean infoBean = service.getEmployee(empId);
		EmployeeResponse response = new EmployeeResponse();

		if (infoBean != null) {

			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Employee Deatails Found For ID " + empId);
			response.setEmployeeInfoBean(infoBean);
		} else {

			response.setStatusCode(405);
			response.setMessage("failure");
			response.setDescription("Employee Deatails Does not Exist! " + empId);
		}

		return response;
	}// end of getEmployee()

	@GetMapping(path = "/getAllEmployee", produces = { MediaType.APPLICATION_JSON_VALUE,
			                                           MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponse getAllEmployee() {

		List<EmployeeInfoBean> infoBeans = service.getAllEmployees();

		EmployeeResponse response = new EmployeeResponse();
		if (infoBeans != null) {

			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Employee Deatails Found ");
			response.setEmployeesList(infoBeans);
		} else {

			response.setStatusCode(405);
			response.setMessage("failure");
			response.setDescription("Employee Deatails Does not Exist!");
		}
		return response;
	}// end of grtAllEmployee()

	@DeleteMapping(path = "/deleteEmployee/{employeeId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponse deleteEmployee(@PathVariable(name = "employeeId") int empId) {

		EmployeeResponse response = new EmployeeResponse();
		if (service.deleteEmployee(empId)) {

			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Employee Record Deleted  For ID " + empId);
		} else {

			response.setStatusCode(405);
			response.setMessage("failure");
			response.setDescription("Unable to Delete Employee Record");

		}
		return response;
	} // end of deleteEmployee()

	@PostMapping(path = "/addEmployee", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponse addEmployee(@RequestBody EmployeeInfoBean infoBean) {
		EmployeeResponse response = new EmployeeResponse();
		if (service.addemployee(infoBean)) {

			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Employee Record Added  For ID " + infoBean.getEmpId());

		} else {

			response.setStatusCode(405);
			response.setMessage("failure");
			response.setDescription("Unable to Add Employee Record");

		}
		return response;
	}// End of addEmployee()

	@PutMapping(path = "/updateEmployee", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponse updateEmployee(@RequestBody EmployeeInfoBean infoBean) {
		EmployeeResponse response = new EmployeeResponse();
		if (service.updateEmployee(infoBean)) {

			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Employee Record Upadted  For ID " + infoBean.getEmpId());
		} else {

			response.setStatusCode(405);
			response.setMessage("failure");
			response.setDescription("Unable to update Employee Record");
		}
		return response;
	}

}
