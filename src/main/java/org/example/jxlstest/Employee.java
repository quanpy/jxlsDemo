package org.example.jxlstest;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Ocean
 * @date 2024/4/22 11:30
 * @description Employee
 */
@Data
public class Employee {
    private String name;
    private Date birthDate;
    private BigDecimal payment;
    // getters/setters ...
}