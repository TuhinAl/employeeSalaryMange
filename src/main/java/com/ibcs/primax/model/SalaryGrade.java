package com.ibcs.primax.model;

import java.util.Arrays;

public enum SalaryGrade {

    GRADE_ONE("one"),
    GRADE_TWO("two"),
    GRADE_THREE("three"),
    GRADE_FOUR("four"),
    GRADE_FIVE("five"),
    GRADE_SIX("six");

    String status;

    SalaryGrade(String status) {
        this.status = status;
    }

    public String getString() {
        return status;
    }

    public static SalaryGrade returnGradeStatus(String status) {
        return Arrays.stream(values()).filter(
                    p -> p.status.equalsIgnoreCase(status)).findFirst().orElse(null);
    }
}
