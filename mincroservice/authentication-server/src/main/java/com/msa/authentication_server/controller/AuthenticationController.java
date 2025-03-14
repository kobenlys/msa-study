package com.msa.authentication_server.controller;

import com.msa.authentication_server.domain.Account;
import com.msa.authentication_server.dto.AccountDto;
import com.msa.authentication_server.dto.ResponseDto;
import com.msa.authentication_server.service.AccountService;
import com.msa.authentication_server.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthenticationController {
    private final AccountService accountService;

    @PostMapping("/login")
    public ResponseEntity<?> joinAccount(@RequestBody AccountDto accountDto) {
        ResponseDto.ResponseDtoBuilder responseDtoBuilder = ResponseDto.builder();
        accountService.saveAccount(accountDto, accountDto.getToken());
        log.info("account id :  {}", accountDto.getAccountId());
        responseDtoBuilder.code("200").message("success");
        return ResponseEntity.ok(responseDtoBuilder.build());
    }

    @PostMapping("/token")
    public ResponseEntity<?> token(@RequestBody AccountDto accountDto) {
        ResponseDto.ResponseDtoBuilder responseDtoBuilder = ResponseDto.builder();
        accountService.saveAccount(accountDto, accountDto.getToken());
        log.info("account id :  {}", accountDto.getAccountId());

        Account account = accountService.selectAccount(accountDto);

        if(account == null){
            responseDtoBuilder.code("101").message("unknown user");
        } else {
            String token = JwtUtil.generateToken(accountDto);
            accountService.saveAccount(accountDto, token);
            responseDtoBuilder.code("200").message("success");
            responseDtoBuilder.token(token);
        }

        return ResponseEntity.ok(responseDtoBuilder.build());
    }


}
