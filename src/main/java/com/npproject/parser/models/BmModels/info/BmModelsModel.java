package com.npproject.parser.models.BmModels.info;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BmModelsModel implements Serializable {
    @JsonProperty("- - Модель")
    private String model;
    @JsonProperty("- - Двигуни")
    private List<EngineModel> engines;
}
