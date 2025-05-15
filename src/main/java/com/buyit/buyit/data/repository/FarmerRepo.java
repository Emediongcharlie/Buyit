package com.buyit.buyit.data.repository;

import com.buyit.buyit.data.model.Farmer;
import com.buyit.buyit.dtos.requests.FarmerLoginRequest;
import com.buyit.buyit.dtos.requests.FarmerRegisterRequest;
import com.buyit.buyit.dtos.requests.SearchByNameRequest;
import com.buyit.buyit.dtos.response.FarmerLoginResponse;
import com.buyit.buyit.dtos.response.FarmerRegisterResponse;
import com.buyit.buyit.dtos.response.SearchByNameResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FarmerRepo extends JpaRepository<Farmer, Long> {

    Optional<Farmer> findByEmail(String email);
}
