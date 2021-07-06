package com.ibcs.primax.common.exception;

/**
 * @author tuhin
 * @created_on 7/6/21 at 10:42 AM
 * @project primax
 **/

public class InsufficientBalanceException extends RuntimeException {
    String message;

    public InsufficientBalanceException(String message) {
        super(message);
    }
}
