package com.ibcs.primax.repository;

import com.ibcs.primax.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "SELECT email FROM employee_infos e  WHERE e.id = :id", nativeQuery = true)
    Employee getEmployeeById(@Param("id")Long id);

    List<Employee> findAll();

    Employee findByEmail(String email);

    Employee findEmployeeByEmail(String email);

}
