package com.example.demo.repo;

import com.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepo extends CrudRepository<Employee, Long> {

//    List<Employee> findByNameContaining(String keyword);

    @Query("SELECT e FROM Employee e WHERE e.name LIKE %:keyword%")
    public List<Employee> findNameByKeyword(String keyword);
}
