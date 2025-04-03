package com.K21CNT2.Ntt_account.repository;

import com.K21CNT2.Ntt_account.entity.NttAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NttAccountRepository extends JpaRepository<NttAccount, Long> {
}
