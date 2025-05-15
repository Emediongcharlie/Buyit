package com.buyit.buyit.service;

import com.buyit.buyit.dtos.requests.FarmerLoginRequest;
import com.buyit.buyit.dtos.requests.FarmerRegisterRequest;
import com.buyit.buyit.dtos.requests.SearchByNameRequest;
import com.buyit.buyit.dtos.response.FarmerLoginResponse;
import com.buyit.buyit.dtos.response.FarmerRegisterResponse;
import com.buyit.buyit.dtos.response.SearchByNameResponse;
import org.springframework.stereotype.Service;

@Service
public interface FarmerService{

    FarmerRegisterResponse registerFarmer(FarmerRegisterRequest registerRequest);
    FarmerLoginResponse loginFarmer(FarmerLoginRequest loginRequest);

}
