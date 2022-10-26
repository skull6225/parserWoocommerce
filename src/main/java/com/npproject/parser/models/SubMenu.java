package com.npproject.parser.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SubMenu {
    private String name;
    private String description;
    private String link;
}
