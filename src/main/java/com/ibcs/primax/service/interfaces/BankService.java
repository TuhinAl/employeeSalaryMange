package com.ibcs.primax.service.interfaces;

import com.ibcs.primax.model.Bank;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BankService {

    List<Bank> getAllBank();


}
