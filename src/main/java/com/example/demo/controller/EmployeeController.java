package com.example.demo.controller;

import com.example.demo.service.EmployService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private EmployService employService;

    @RequestMapping("list")
    public String list(Model model) {
        model.addAttribute("employees", employService.getEmployeeLIst());

        return "employee/list";
    }
}
