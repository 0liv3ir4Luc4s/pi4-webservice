package com.piiv.piiv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piiv.piiv.entities.RentingProposal;

public interface RentingProposalRepository extends JpaRepository<RentingProposal, Long> {
}