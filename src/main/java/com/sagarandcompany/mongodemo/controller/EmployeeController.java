package com.sagarandcompany.mongodemo.controller;

import com.sagarandcompany.mongodemo.domain.Employee;
import com.sagarandcompany.mongodemo.service.EmployeeService;
import com.sagarandcompany.mongodemo.util.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/save")
    public ResponseDTO save(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @RequestMapping("/get/{id}")
    public ResponseDTO get(@PathVariable String id) {
        return employeeService.get(id);
    }

    @RequestMapping("/get")
    public ResponseDTO getAll() {
        return employeeService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDTO delete(@PathVariable String id) {
        return employeeService.delete(id);
    }

    @RequestMapping("/find")
    public ResponseDTO find(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "age", required = false) Integer age) {
        return employeeService.findEmployeeByCriteria(name, age);
    }

    @RequestMapping("/findandmodify")
    public ResponseDTO findandmodify(@RequestParam(value = "name") String name) {
        return employeeService.findandmodify(name);
    }

}
