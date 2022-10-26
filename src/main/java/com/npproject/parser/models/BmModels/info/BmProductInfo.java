package com.npproject.parser.models.BmModels.info;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.npproject.parser.models.BmModels.info.analog.BmAnalogModelBody;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BmProductInfo implements Serializable {

    private String nodes;

    @SerializedName("default_image")
    private String defaultImage;
    private List<String> images;
    private List<BmCarModel> cars;

    private List<BmAnalogModelBody> analogsList;

    private Object details;

}