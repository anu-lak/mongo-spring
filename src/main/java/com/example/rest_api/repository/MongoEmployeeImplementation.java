package com.example.rest_api.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import com.example.rest_api.model.Employee;
import com.example.rest_api.projection.EmployeeProjection;

@Repository
@Profile("mongo")
public class MongoEmployeeImplementation implements EmployeeRepo {
    @Autowired
    MongoRepo mongoRepo;

    @Override
    public List<Employee> findByDepartment(String department) {
        return mongoRepo.findByDepartment(department);
    }

    @Override
    public List<Employee> findManagers() {
        return mongoRepo.findManagers();
    }

    @Override
    public List<EmployeeProjection> findAllByManagerId(int id) {
        return mongoRepo.findAllByManagerId(id);
    }

    @Override
    public List<EmployeeProjection> findAllByManagerIdAndYearsOfExperienceGreaterThanEqual(int id,
            Integer yearOfExperience) {
        return mongoRepo.findAllByManagerIdAndYearsOfExperienceGreaterThanEqual(id, yearOfExperience);
    }

    @Override
    public List<EmployeeProjection> findAllByYearsOfExperienceGreaterThanEqual(int yearsOfExperience) {
            return mongoRepo.findAllByYearsOfExperienceGreaterThanEqual(yearsOfExperience);
    }

    @Override
    public Optional<Employee> findById(int id) {
        return mongoRepo.findById(null);
    }

    @Override
    public List<Employee> findAllById(Integer employeeId) {
        return mongoRepo.findAllById(employeeId);
    }

    @Override
    public void deleteById(Integer employeeId){
        mongoRepo.deleteById(employeeId);
    }

    @Override
    public void save(Employee emp){
        mongoRepo.save(emp);
    }

    @Override
    public boolean existsById(int id) {
        return mongoRepo.existsById(id);
    }
    
}
