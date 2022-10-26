package com.npproject.parser.models.BmModels;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.npproject.parser.models.BmModels.info.BmProductInfo;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BmModel implements Serializable {
    private String id;
    @JsonProperty("sku")
    private String article;
    private String brand;
    private String name;
    @JsonProperty("_ni_cost_of_good")
    private String priceUah;
    @JsonProperty("regular_price")
    private String newPriceUah;
    private BmProductInfo info;
    private String vinnica;
    private String dnipro;
    private String franyk;
    private String kyiv;
    private String lutsk;
    private String lviv;
    private String rivne;
    private String uzgorod;
    private String khm;
    private String hust;
    private String chernivci;
}
