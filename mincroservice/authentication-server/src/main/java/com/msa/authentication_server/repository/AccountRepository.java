package com.msa.authentication_server.repository;

import com.msa.authentication_server.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {


}
