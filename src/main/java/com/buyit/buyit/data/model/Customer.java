package com.buyit.buyit.data.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Customer {

    @Id
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private String farmName;
    private String password;
    private String bio;
    private ProductStatus verificationStatus;
    @ManyToOne
    @JoinColumn(name = "farmer_id")
    private Farmer farmer;


}
