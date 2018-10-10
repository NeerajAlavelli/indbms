package com.radha.gopal.controller;

import com.radha.gopal.model.Brand;
import com.radha.gopal.model.Supplier;
import com.radha.gopal.model.Voucher;
import com.radha.gopal.repository.BrandRepository;
import com.radha.gopal.repository.VoucherRepository;
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
public class VoucherController{


    @Autowired
    private VoucherRepository voucherRepository;

    @ModelAttribute("voucherform")
    private Voucher formattribute(){
        return  new Voucher();
    }

    @GetMapping("admin/voucher")
    public String voucherForm(Model model) {

        return "Voucherform";
    }

    @PostMapping("admin/voucher")
    public String checkReturnInfo(@Valid Voucher voucher, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.toString());
            return "Voucherform";
        }

        voucherRepository.save(voucher);


        return "redirect:/admin/brand";
    }
    @GetMapping("admin/voucherlist")
    public ModelAndView voucherList(Model model) {


        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("Voucherlist");

        List<Voucher> voucherList=voucherRepository.findAll();

        modelAndView.addObject("list",voucherList);

        return modelAndView ;
    }
}