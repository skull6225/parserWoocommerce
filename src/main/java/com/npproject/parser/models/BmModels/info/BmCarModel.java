package com.npproject.parser.models.BmModels.info;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BmCarModel implements Serializable {
    @JsonProperty("- Бренд")
    private String brand;

    @JsonProperty("- Моделі")
    private List<BmModelsModel> models;
}
