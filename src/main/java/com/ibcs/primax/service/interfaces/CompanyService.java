package com.ibcs.primax.service.interfaces;

import com.ibcs.primax.dto.requestDto.CompanyDTO;
import org.springframework.stereotype.Service;

@Service
public interface CompanyService {

    void registerCompanyToBank(CompanyDTO companyDTO);

    void depositAmount(double amount, Long id);

    void transferAmount(double amount, Long companyId, Long employeeId);


}
