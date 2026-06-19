package com.faulttolerancesystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.faulttolerancesystem.entity.FailureAudit;

@Repository
public interface FailureAuditRepository extends JpaRepository<FailureAudit, Long> {

}
