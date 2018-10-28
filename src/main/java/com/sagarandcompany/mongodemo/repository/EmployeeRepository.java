package com.sagarandcompany.mongodemo.repository;

import com.sagarandcompany.mongodemo.domain.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
}
