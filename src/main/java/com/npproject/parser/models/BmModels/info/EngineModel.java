package com.npproject.parser.models.BmModels.info;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EngineModel implements Serializable {
    @JsonProperty("- - - Тип двигуна")
    @SerializedName("engine_type")
    private String engineType;

    @JsonProperty("- - - Кіньські сили")
    @SerializedName("horse_power")
    private String horsePower;

    @JsonProperty("- - - Потужність двигуна")
    @SerializedName("engine_volume")
    private String engineVolume;

    @JsonProperty("- - - Двигун")
    private String engine;

    @JsonProperty("- - - Останній реліз")
    @SerializedName("end_release")
    private String endRelease;

    @JsonProperty("- - - Тип кузова")
    @SerializedName("body_type")
    private String bodyType;

    @JsonProperty("- - - Початок випуску")
    @SerializedName("begin_release")
    private String beginRelease;

    @JsonProperty("- - - Кількість циліндрів")
    @SerializedName("amount_cylinder")
    private String amountCylinder;
}
