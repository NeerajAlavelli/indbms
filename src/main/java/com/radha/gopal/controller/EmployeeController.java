package com.radha.gopal.controller;

import com.radha.gopal.model.Customer;
import com.radha.gopal.model.Employee;
import com.radha.gopal.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class EmployeeController{


    @Autowired
    private EmployeeRepository employeeRepository;



    @ModelAttribute("employeeform")
    private Employee formattribute(){
        return new Employee();
    }

    @GetMapping("admin/employee")
    public String employeeForm(Model model) {

        return "Employeeform";
    }

    @PostMapping("admin/employee")
    public String checkReturnInfo(@Valid Employee employee, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.toString());
            return "Employeeform";
        }

        employeeRepository.save(employee);


        return "redirect:/admin/employee";
    }
    @GetMapping("admin/employeelist")
    public ModelAndView employeeList(Model model) {


        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("Employeelist");

        List<Employee> employeeList=employeeRepository.findAll();

        modelAndView.addObject("list",employeeList);

        return modelAndView ;
    }
}