package com.ibcs.primax.repository;

import com.ibcs.primax.model.EmployeeAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeAccountRepository extends JpaRepository<EmployeeAccount, Long> {
}
