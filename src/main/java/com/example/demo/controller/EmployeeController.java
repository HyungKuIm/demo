package com.example.demo.controller;

import com.example.demo.repository.entity.Employee;
import com.example.demo.service.EmployService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("employee")
public class EmployeeController {

    private final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployService employService;

    @RequestMapping("list")
    public String list(@RequestParam(required = false) Integer pageNumber, Model model) {
        long count = employService.getEmployeeCnt();
        int page = (pageNumber == null) ? 1 : pageNumber;
        int size = 3;

        logger.debug("================");
        logger.debug("page = " + page);

        int totalPages = (int) Math.ceil((double) count / size);

        Pageable pageable = PageRequest.of(page-1, size);

        model.addAttribute("employees", employService.getEmployeeList(pageable));
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("totalPages", totalPages);

        return "employee/list";
    }
}
