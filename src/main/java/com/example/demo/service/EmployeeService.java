package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public void addEmployee(Employee employee){
        employeeRepo.save(employee);
    }

    public void updateEmployee(Employee employee){
        employeeRepo.save(employee);
    }

    public void deleteEmployee(Long id){
        employeeRepo.deleteById(id);
    }

    public Iterable<Employee> findAll(){
        return employeeRepo.findAll();
    }

    public Optional<Employee> findById(Long id){
        return employeeRepo.findById(id);
    }

    public List<Employee> findByName(String keyword){
        return employeeRepo.findNameByKeyword(keyword);
    }


}
