package com.coforge.AdminService.Repository;

import com.coforge.AdminService.Entity.AccountDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface AccountDetailsRepository extends JpaRepository<AccountDetails, Long> {

    @Query("select acc.openingBalance from AccountDetails acc where acc.accountNumber=?1")
    Double findBalanceByAccountNumber(long accountNumber);

    @Modifying
    @Transactional
    @Query("update AccountDetails acc set acc.openingBalance=?2 where acc.accountNumber=?1")
    void setOpeningBalance(long accountNumber, double balance);
}
