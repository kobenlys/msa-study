package com.msa.item.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ResponseDto {
    private String code;
    private String message;
}
