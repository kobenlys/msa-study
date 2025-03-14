package com.msa.authentication_server.service;

import com.msa.authentication_server.domain.Account;
import com.msa.authentication_server.dto.AccountDto;
import com.msa.authentication_server.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    public Account selectAccount(AccountDto accountDto) {
        Optional<Account> account = accountRepository.findById(accountDto.getAccountId());
        if (account.isPresent()) {
            Account user =  account.get();
            if (user.getPassword().equals(accountDto.getPassword())) {
                return user;
            }
        }
        return null;
    }

    public void saveAccount(AccountDto accountDto, String token) {
        Account account = Account.builder()
                .accountId(accountDto.getAccountId())
                .password(accountDto.getPassword())
                .token(token)
                .build();
        accountRepository.save(account);
    }
}
