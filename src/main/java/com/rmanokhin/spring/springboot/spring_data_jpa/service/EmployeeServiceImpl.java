package com.rmanokhin.spring.springboot.spring_data_jpa.service;

import com.rmanokhin.spring.springboot.spring_data_jpa.empoyeeDAO.EmployeeRepository;
import com.rmanokhin.spring.springboot.spring_data_jpa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        //создаём пустышку
        Employee employee = null;
        //получаем работника
        Optional<Employee> optional = employeeRepository.findById(id);
        //проверяем, получили ли мы работника, если да то присваиваем его пустышке и возвращаем
        if(optional.isPresent()){
            employee = optional.get();
        }
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findAllByFirstName(String name) {
        return employeeRepository.findAllByFirstName(name);
    }
}
