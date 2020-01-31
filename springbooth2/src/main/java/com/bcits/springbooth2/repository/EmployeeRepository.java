package com.bcits.springbooth2.repository;

import org.springframework.data.repository.CrudRepository;

import com.bcits.springbooth2.beans.EmployeeInfoBean;

public interface EmployeeRepository extends CrudRepository<EmployeeInfoBean, Integer> {

}
