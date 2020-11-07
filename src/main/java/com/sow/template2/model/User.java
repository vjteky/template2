package com.sow.template2.model;

import lombok.Data;

@Data
public class User {
	
	private String name;
    private String email;
    private int miles;
    private double rate;
    private String password;
    private String gender;
    private String note;
    private boolean married;
    private String birthday;
    private String profession;
    private Address address;
}
