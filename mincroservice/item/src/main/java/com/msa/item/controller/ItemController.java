package com.msa.item.controller;

import com.msa.item.dto.ItemRequest;
import com.msa.item.dto.ResponseDto;
import com.msa.item.service.ItemService;
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
@RequestMapping("/api/item")
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody ItemRequest itemRequest) {
        ResponseDto.ResponseDtoBuilder responseDtoBuilder = ResponseDto.builder();
        log.info("request add item id  : {}", itemRequest.getId());
        itemService.saveItem(itemRequest);
        responseDtoBuilder.code("200").message("success");
        return ResponseEntity.ok(responseDtoBuilder.build());
    }


}
