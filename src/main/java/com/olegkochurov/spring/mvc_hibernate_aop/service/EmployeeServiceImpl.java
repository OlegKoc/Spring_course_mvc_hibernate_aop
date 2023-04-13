package com.olegkochurov.spring.mvc_hibernate_aop.service;

import com.olegkochurov.spring.mvc_hibernate_aop.dao.EmployeeDao;
import com.olegkochurov.spring.mvc_hibernate_aop.entity.Employee;
import com.olegkochurov.spring.mvc_hibernate_aop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    @Transactional   // открытие и закрытие транзакций Spring
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    @Transactional
    @Override
    public void saveEmployee(Employee employee) {
        employeeDao.saveEmployee(employee); // вызываем метод класа Dao

    }

    @Transactional
    @Override
    public Employee getEmployee(int id) {
        return employeeDao.getEmployee(id);
    }

    @Transactional
    @Override
    public void deleteEmployee(int id) {
        employeeDao.deleteEmployee(id);
    }
}
