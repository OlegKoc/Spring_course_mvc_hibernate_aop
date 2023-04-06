package com.olegkochurov.spring.mvc_hibernate_aop.dao;

import com.olegkochurov.spring.mvc_hibernate_aop.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    public List<Employee> getAllEmployees();

}
