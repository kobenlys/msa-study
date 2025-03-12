package com.msa.item.controller;

import com.msa.item.dto.ItemRequest;
import com.msa.item.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/item")
public class ItemController {

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody ItemRequest itemRequest) {
        ResponseDto.ResponseDtoBuilder responseDtoBuilder = ResponseDto.builder();
        log.debug("request add item id  : {}", itemRequest.getId());
        responseDtoBuilder.code("200").message("success");
        return ResponseEntity.ok(responseDtoBuilder.build());
    }


}
