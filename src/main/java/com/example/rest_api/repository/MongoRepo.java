package com.example.rest_api.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.example.rest_api.model.Employee;
import com.example.rest_api.projection.EmployeeProjection;

public interface MongoRepo extends MongoRepository<Employee,Integer> {

    List<Employee> findByDepartment(String department);

    @Query("{'designation':'account manager'}")
    public List<Employee> findManagers();
    
    List<EmployeeProjection> findAllByManagerId(int id);
    
    List<EmployeeProjection> findAllByManagerIdAndYearsOfExperienceGreaterThanEqual(int id, Integer yearOfExperience);

    List<EmployeeProjection> findAllByYearsOfExperienceGreaterThanEqual(int yearsOfExperience);

    List<Employee> findAllById(Integer employeeId);

    void deleteById(Integer employeeId);

}
