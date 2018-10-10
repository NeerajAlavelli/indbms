package com.radha.gopal.controller;

import com.radha.gopal.model.Employee;
import com.radha.gopal.model.Expense;
import com.radha.gopal.repository.ExpenseRepository;
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
public class ExpenseController{


    @Autowired
    private ExpenseRepository expenseRepository;



    @ModelAttribute("expenseform")
    private Expense formattribute(){
        return new Expense();
    }

    @GetMapping("admin/expense")
    public String expenseForm(Model model) {

        return "Expenseform";
    }

    @PostMapping("admin/expense")
    public String checkReturnInfo(@Valid Expense expense, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.toString());
            return "Expenseform";
        }

        expenseRepository.save(expense);


        return "redirect:/admin/expense";
    }
    @GetMapping("admin/expenselist")
    public ModelAndView expenseList(Model model) {


        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("Expenselist");

        List<Expense> expenseList=expenseRepository.findAll();

        modelAndView.addObject("list",expenseList);

        return modelAndView ;
    }
}