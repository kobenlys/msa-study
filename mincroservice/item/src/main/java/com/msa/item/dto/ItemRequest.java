package com.msa.item.dto;

import lombok.Data;

@Data
public class ItemRequest {
    private String id;
    private String name;
    private String description;
    private Long count;
    private String regDts;
    private String updDts;
}
