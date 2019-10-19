package com.lanou.newtest.bean;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Emp {
private int empid;
private String account;
private String password;
private int departmentid;
private Object param;
}
