package com.bcits.springcoreannotations.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({ DepartmentConfig.class, EmployeeConfig2.class })
@Configuration
public class AllConfigs {

}
