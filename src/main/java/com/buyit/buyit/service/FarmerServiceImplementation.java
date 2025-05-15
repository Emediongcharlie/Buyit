package com.buyit.buyit.service;

import com.buyit.buyit.data.model.Farmer;
import com.buyit.buyit.data.repository.FarmerRepo;
import com.buyit.buyit.dtos.requests.FarmerLoginRequest;
import com.buyit.buyit.dtos.requests.FarmerRegisterRequest;
import com.buyit.buyit.dtos.response.FarmerLoginResponse;
import com.buyit.buyit.dtos.response.FarmerRegisterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FarmerServiceImplementation implements FarmerService {

    @Autowired
    private FarmerRepo farmerRepo;

    @Override
    public FarmerRegisterResponse registerFarmer(FarmerRegisterRequest registerRequest) {
        Farmer farmer = new Farmer();
        farmer.setFirstName(registerRequest.getFirstName());
        farmer.setLastName(registerRequest.getLastName());
        farmer.setEmail(registerRequest.getEmail());
        farmer.setPassword(registerRequest.getPassword());
        farmer.setAddress(registerRequest.getAddress());
        farmer.setPhoneNumber(registerRequest.getPhoneNumber());
        farmer.setFarmName(registerRequest.getFarmName());
        farmer.setVerificationStatus(registerRequest.getVerificationStatus());
        farmer.setBio(registerRequest.getBio());
        farmerRepo.save(farmer);
        FarmerRegisterResponse registerResponse = new FarmerRegisterResponse();
        registerResponse.setFirstName(farmer.getFirstName());
        registerResponse.setMessage("Successfully Registered");

        return registerResponse;
    }

    @Override
    public FarmerLoginResponse loginFarmer(FarmerLoginRequest loginRequest) {
        Farmer farmer = farmerRepo.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("Email not found"));

        if (!farmer.getPassword().equals(loginRequest.getPassword())) {
            throw new RuntimeException("Incorrect email or Password");
        }

        FarmerLoginResponse loginResponse = new FarmerLoginResponse();
        loginResponse.setEmail(farmer.getEmail());
        loginResponse.setMessage("Successfully Logged In");
        return loginResponse;
    }

}
