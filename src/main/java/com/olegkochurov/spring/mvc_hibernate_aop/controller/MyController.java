package com.olegkochurov.spring.mvc_hibernate_aop.controller;

import com.olegkochurov.spring.mvc_hibernate_aop.dao.EmployeeDao;
import com.olegkochurov.spring.mvc_hibernate_aop.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping("/")    // метод, который возвращает всех работников
    public String showAllEmployees(Model model) {
        List<Employee> employees =  employeeDao.getAllEmployees(); // сохраняем в employees
        model.addAttribute("allEmps", employees); // по атрибуту получаем работников
        return "all-emplloyees";  // название view
    }
}
