package com.npproject.parser.models.BmModels.info.analog;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnalogInfo {
    private String name;

    @SerializedName("default_image")
    private String defaultImage;

    private String brand;

    private String article;

    private String price;
}
