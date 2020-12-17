package com.example.service.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.service.model.LeaveLedger;

@Repository
public interface LeaveLedgerRepository extends JpaRepository<LeaveLedger, Integer>
{

}
