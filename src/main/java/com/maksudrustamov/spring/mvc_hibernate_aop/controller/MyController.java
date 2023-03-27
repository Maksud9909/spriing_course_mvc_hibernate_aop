package com.maksudrustamov.spring.mvc_hibernate_aop.controller;

import com.maksudrustamov.spring.mvc_hibernate_aop.dao.EmployeeDAO;
import com.maksudrustamov.spring.mvc_hibernate_aop.entity.Employee;
import com.maksudrustamov.spring.mvc_hibernate_aop.service.EmployeeService;
import com.maksudrustamov.spring.mvc_hibernate_aop.service.EmployeeServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    private EmployeeService employeeService;
    @RequestMapping("/")
    public String showAllEmployees(Model model){

        List<Employee> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("allEmps",allEmployees); // view будет брать отсюда информацию

        return "all-employees";
    }
    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model){
        Employee employee = new Employee(); // мы создали эту переменную, так как сюда же мы будем грузить все полученные данные, имя возраст и т.д

        model.addAttribute("employee",employee);

        return "employee-info";

    }
    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){ // мы тут взяли работника с прошлого метода

        employeeService.saveEmployee(employee);

        return "redirect:/";
    }
@RequestMapping("/updateInfo")
    public String updateEmployee(@RequestParam("empId") int id, Model model){

        return "employee-info";
    }
}
