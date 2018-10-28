package com.sagarandcompany.mongodemo.service;

import com.sagarandcompany.mongodemo.domain.Employee;
import com.sagarandcompany.mongodemo.repository.EmployeeRepository;
import com.sagarandcompany.mongodemo.util.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    public ResponseDTO save(Employee employee) {
        Employee emp = employeeRepository.save(employee);
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("Document is saved successfluu");
        responseDTO.setStatus(true);
        return responseDTO;
    }

    public ResponseDTO get(String id) {
        Employee emp = employeeRepository.findById(id).get();
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData(emp);
        return responseDTO;
    }

    public ResponseDTO getAll() {
        List<Employee> employeeList = employeeRepository.findAll();
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData(employeeList);
        return responseDTO;
    }

    public ResponseDTO delete(String id) {
        employeeRepository.deleteById(id);
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("Document is deleted successfluu");
        responseDTO.setStatus(true);
        return responseDTO;
    }

    public ResponseDTO findandmodify(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        Update update = new Update();
        update.set("email", "sagarmal624@gmail.com");
        Employee employee = mongoTemplate.findAndModify(query, update, Employee.class);
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData(employee);
        return responseDTO;
    }

    public ResponseDTO findEmployeeByCriteria(String name, Integer age) {
        Query query = new Query();
        if (Objects.nonNull(name) && Objects.nonNull(age)) {
            query.addCriteria(Criteria.where("name").is(name));
            query.addCriteria(Criteria.where("age").is(age));
        } else if (Objects.nonNull(name)) {
            query.addCriteria(Criteria.where("name").is(name));
        } else if (Objects.nonNull(age)) {
            query.addCriteria(Criteria.where("age").is(age));
        }
        List<Employee> employees = mongoTemplate.find(query, Employee.class);
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData(employees);
        return responseDTO;
    }

    
}
