package com.msa.authentication_server.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AccountDto {
    @NotBlank(message = "ID 입력해주세요")
    @Size(max=10, message = "ID 크기 10이하까지 작성가능")
    private String accountId;

    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    private String password;
    private String token;
}
