package com.example.demo.controller;

import com.example.demo.dto.SearchFormData;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("")
public class HomeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public String save(Employee employee, Model model){
        employeeService.addEmployee(employee);
        return "redirect:/";
    }

    @GetMapping
    public String welcome(Model model){
        String msgs = "Welcome to Employee App";
        model.addAttribute("msg", msgs);
        model.addAttribute("searchForm", new SearchFormData());
        model.addAttribute("employees", employeeService.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("employee", new Employee());
        return "add";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model){
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model){
        model.addAttribute("employee", employeeService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(Employee employee, Model model){
        employeeService.updateEmployee(employee);
        return "redirect:/";
    }

    @PostMapping("/search")
    public String search(SearchFormData searchFormData, Model model){
        String msgs = "Welcome to Employee App";
        model.addAttribute("msg", msgs);
        model.addAttribute("searchForm", searchFormData);
        model.addAttribute("employees", employeeService.findByName(searchFormData.getKeyword()));
        return "index";
    }

}
