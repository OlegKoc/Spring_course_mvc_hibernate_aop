package com.olegkochurov.spring.mvc_hibernate_aop.controller;

import com.olegkochurov.spring.mvc_hibernate_aop.dao.EmployeeDao;
import com.olegkochurov.spring.mvc_hibernate_aop.entity.Employee;
import com.olegkochurov.spring.mvc_hibernate_aop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller                 // класс контроллер обращается к классу Сервис, а он обращаются к классу EmployeeDAO
public class MyController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/")    // метод, который возвращает всех работников
    public String showAllEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees(); // сохраняем в employees
        model.addAttribute("allEmps", employees); // теперь в атрибуте allEmps работники которые мы получили из БД
        return "all-emplloyees";  // название view
    }

    @RequestMapping("/addNewEmployee") // метод добавляет работников
    public String addNewEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);  // атрибут "employee" связывается с JSP страницой
        return "employee-info";

    }

    @RequestMapping("/saveEmployee")  // метод сохраняет работников
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @RequestMapping("/updateInfo")  // метод изменяет работника
    public String updateEmployee(@RequestParam("empId") int id, Model model) {
        Employee employee = employeeService.getEmployee(id);   //
        model.addAttribute("employee", employee);
        return "employee-info";

    }
}
