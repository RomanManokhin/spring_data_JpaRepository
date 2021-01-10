package com.rmanokhin.spring.springboot.spring_data_jpa.empoyeeDAO;



import com.rmanokhin.spring.springboot.spring_data_jpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
//JpaRepository - класс с помощью которого мы можем использовать уже готовые методы для работы с БД
//необходимо указать дженерики 1эй это класс(Entity) который будет использовать репозиторий
//2ой это тип данных у нашего Primary Key
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    public List<Employee> findAllByFirstName(String name);

}
