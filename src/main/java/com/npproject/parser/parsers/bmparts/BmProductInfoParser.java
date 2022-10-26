package com.npproject.parser.parsers.bmparts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.npproject.parser.models.BmModels.BmModel;
import com.npproject.parser.models.BmModels.info.BmProductInfo;
import com.npproject.parser.models.BmModels.info.analog.AnalogInfo;
import com.npproject.parser.models.BmModels.info.analog.BmAnalogModelBody;
import com.npproject.parser.parsers.utils.ParserUtil;

public class BmProductInfoParser extends ParserUtil {
    List<BmModel> productListWithInfo = new ArrayList<>();
    WooCommerceProductUpdate wooCommerceProductUpdate = new WooCommerceProductUpdate();

    public List<BmModel> getProductsInfo(List<BmModel> productsList) throws InterruptedException, JsonProcessingException {

        int x = 0;

        for (BmModel product : productsList) {
            try {
                wooCommerceProductUpdate.modifyAndUpdate(etProductInfo(product, x));
                x++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return productListWithInfo;
    }

    private BmModel etProductInfo(BmModel productsList, int finalI) throws IOException, InterruptedException {
        System.out.println(finalI);
        String fooResourceUrl = "https://api.bm.parts/product/" + productsList.getId();

        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod(fooResourceUrl);
        method.setRequestHeader("Accept","application/json");
        method.setRequestHeader("User-Agent","Awesome-BM-Parts-App");
        method.setRequestHeader("Authorization","56a8c7fe-bd3f-482f-850f-4fe0f5bf31bf.GfXBi-e9SO1OrJ9TKhRYvoYTKGE");

        int responceCode = client.executeMethod(method);

        if(responceCode == 403){
            TimeUnit.MINUTES.sleep(10);
            etProductInfo(productsList, finalI);
        }

        String responseBodyAsString = method.getResponseBodyAsString();

        return parseProductInfo(productsList, responseBodyAsString);
    }

    private BmModel parseProductInfo(BmModel product, String responceBody) {
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = (JsonObject) parser.parse(responceBody);
        JsonElement jsonProductElement = jsonObject.get("product");
        BmProductInfo emp = gson.fromJson(jsonProductElement, BmProductInfo.class);

        emp.setDefaultImage(BASIC_IMAGE_URL + emp.getDefaultImage().replace("\\", "/"));
        emp.setImages(emp.getImages().stream().map(m -> {
                    String imageUrl = BASIC_IMAGE_URL + m.replace("\\", "/");
                    return imageUrl; //imageUrl.replace("/photo/", "/photos/320x320/");
                })
                .collect(Collectors.toList()));

        emp.setAnalogsList(getAnalogsInfo(gson, (JsonObject) jsonProductElement));

        product.setInfo(emp);

        return product;
    }

    private List<BmAnalogModelBody> getAnalogsInfo(Gson gson, JsonObject jsonProductElement) {
        List<BmAnalogModelBody> analogs = new ArrayList<>();

        jsonProductElement.get("analogs").getAsJsonObject().entrySet().forEach(f -> {
            String key = f.getKey();
            JsonElement value = f.getValue();
            AnalogInfo analogInfo = gson.fromJson(value, AnalogInfo.class);
            analogInfo.setDefaultImage(BASIC_IMAGE_URL + analogInfo.getDefaultImage().replace("\\", "/"));
            analogs.add(
                    BmAnalogModelBody.builder()
                            .id(key)
                            .analogs(analogInfo)
                            .build()
            );
        });
        return analogs;
    }
}