package com.ibcs.primax.service.serviceImpl;

import com.ibcs.primax.model.Bank;
import com.ibcs.primax.repository.BankRepository;
import com.ibcs.primax.service.interfaces.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tuhin
 * @created_on 7/6/21 at 2:03 AM
 * @project primax
 **/
@Service
public class BankServiceImpl implements BankService {

    @Autowired
    BankRepository bankRepository;


    @Override
    public List<Bank> getAllBank() {

        List<Bank> bankListInfos = bankRepository.findAll();

        return bankListInfos;
    }
}
