package com.ibcs.primax.common.exception;

public class EmployeeNotFoundException extends IllegalArgumentException {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
