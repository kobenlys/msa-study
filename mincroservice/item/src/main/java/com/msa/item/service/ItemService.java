package com.msa.item.service;

import com.msa.item.domain.Item;
import com.msa.item.dto.ItemRequest;
import com.msa.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.type.descriptor.DateTimeUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;


    public void saveItem(ItemRequest itemRequest){
        Item itemEntity = Item.builder()
                .count(itemRequest.getCount())
                .name(itemRequest.getName())
                .description(itemRequest.getDescription())
                .updDts(itemRequest.getUpdDts())
                .regDts(itemRequest.getRegDts())
                .build();
        itemRepository.save(itemEntity);
    }
}
