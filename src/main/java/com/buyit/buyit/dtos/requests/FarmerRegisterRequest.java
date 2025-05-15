package com.buyit.buyit.dtos.requests;

import com.buyit.buyit.data.model.Customer;
import com.buyit.buyit.data.model.ProductStatus;

public class FarmerRegisterRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    private String farmName;
    private String bio;
    private ProductStatus verificationStatus;
    private Customer customers;

    public FarmerRegisterRequest(String firstName, String lastName, String email, String password, String phoneNumber, String address, String farmName, String bio, ProductStatus verificationStatus) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.farmName = farmName;
        this.bio = bio;
        this.verificationStatus = verificationStatus;


    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getFarmName() {
        return farmName;
    }
    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }
    public String getBio() {
        return bio;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }
    public ProductStatus getVerificationStatus() {
        return verificationStatus;
    }
    public void setVerificationStatus(ProductStatus verificationStatus) {
        this.verificationStatus = verificationStatus;
    }
    public Customer getCustomers() {
        return customers;
    }
    public void setCustomers(Customer customers) {
        this.customers = customers;
    }

}
