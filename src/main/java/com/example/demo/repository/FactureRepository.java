package com.example.demo.repository;

import com.example.demo.dto.FactureDTO;
import com.example.demo.dto.ClientDTO;
import com.example.demo.entity.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {

    List<Facture> findByClientId(Long clientId);

}
