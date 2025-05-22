package com.buyit.buyit.service;


import com.buyit.buyit.data.model.Farmer;
import com.buyit.buyit.data.repository.FarmerRepo;
import com.buyit.buyit.dtos.requests.FarmerLoginRequest;
import com.buyit.buyit.dtos.requests.FarmerRegisterRequest;
import com.buyit.buyit.dtos.response.FarmerLoginResponse;
import com.buyit.buyit.dtos.response.FarmerRegisterResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FarmerServiceTest {

    @Mock
    FarmerRepo farmerRepo;

    @InjectMocks
    FarmerServiceImplementation farmerService;

    @Test
    void addFarmerTest(){

        FarmerRegisterRequest request = new FarmerRegisterRequest();
        request.setFirstName("Emediong");
        request.setEmail("emediongcharlie@gmail.com");
        request.setPassword("password");

        Farmer savedFarmer = new Farmer();
        savedFarmer.setId(1L);
        savedFarmer.setFirstName(request.getFirstName());
        savedFarmer.setEmail(request.getEmail());
        savedFarmer.setPassword(request.getPassword());

        when(farmerRepo.save(any(Farmer.class))).thenReturn(savedFarmer);
        FarmerRegisterResponse response = farmerService.registerFarmer(request);

        assertNotNull(response);
        assertEquals("Emediong", savedFarmer.getFirstName());
        assertTrue("emediongcharlie@gmail.com".equals(savedFarmer.getEmail()));

    }

    @Test
    void loginFarmerTest(){
        FarmerLoginRequest request = new FarmerLoginRequest();
        request.setEmail("emediongcharlie@gmail.com");
        request.setPassword("password");

        Farmer savedFarmer = new Farmer();
        savedFarmer.setId(1L);
        savedFarmer.setFirstName("Emediong");
        savedFarmer.setEmail("emediongcharlie@gmail.com");
        savedFarmer.setPassword("password");

        when(farmerRepo.findByEmail("emediongcharlie@gmail.com")).thenReturn(Optional.of(savedFarmer));
        FarmerLoginResponse response = farmerService.loginFarmer(request);

        assertNotNull(response);
        assertEquals("emediongcharlie@gmail.com", response.getEmail());
        assertEquals("Successfully Logged In", response.getMessage());
    }

    @Test
    void wrongPasswordTest(){

        FarmerLoginRequest request = new FarmerLoginRequest();
        request.setEmail("emediongcharlie@gmail.com");
        request.setPassword("password");

        Farmer savedFarmer = new Farmer();
        savedFarmer.setId(1L);
        savedFarmer.setFirstName("Emediong");
        savedFarmer.setEmail("emediongcharlie@gmail.com");
        savedFarmer.setPassword("wrongpassword");

        when(farmerRepo.findByEmail("emediongcharlie@gmail.com"))
                .thenReturn(Optional.of(savedFarmer));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            farmerService.loginFarmer(request);
        });

        assertEquals("Incorrect email or Password", exception.getMessage());
    }

}
