package com.coforge.AdminService.Repository;

import com.coforge.AdminService.Entity.BranchDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchDetailsRepository extends JpaRepository<BranchDetails, Long> {
}
