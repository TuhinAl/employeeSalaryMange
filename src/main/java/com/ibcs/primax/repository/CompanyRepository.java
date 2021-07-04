package com.ibcs.primax.repository;

import com.ibcs.primax.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
