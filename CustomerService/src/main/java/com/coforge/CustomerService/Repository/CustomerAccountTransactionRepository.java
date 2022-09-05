package com.coforge.CustomerService.Repository;

import com.coforge.CustomerService.Entity.CustomerAccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerAccountTransactionRepository extends JpaRepository<CustomerAccountTransaction, Long> {

    @Query("from CustomerAccountTransaction t where t.transactionType=?1")
    List<CustomerAccountTransaction> findAllByTransactionType(String type);

    @Query("from CustomerAccountTransaction t where t.transactionType=?1 and accountNumber=?2")
    List<CustomerAccountTransaction> findAllByTransactionTypeAndAccountNumber(String type, long accountNumber);

    @Query("from CustomerAccountTransaction t where accountNumber=?1")
    List<CustomerAccountTransaction> findAllByAccountNumber(long accountNumber);
}
