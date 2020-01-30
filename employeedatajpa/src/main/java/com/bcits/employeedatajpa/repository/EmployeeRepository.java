package com.bcits.employeedatajpa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.bcits.employeedatajpa.bean.EmployeeInfoBean;

public interface EmployeeRepository extends CrudRepository<EmployeeInfoBean, Integer> {

	@Query("from EmployeeInfoBean where empId= :empId  and password= :password")
	public EmployeeInfoBean authenticate( int empId,  String password);
}
