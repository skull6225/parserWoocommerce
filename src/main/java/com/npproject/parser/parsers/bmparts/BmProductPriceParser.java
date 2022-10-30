package com.npproject.parser.parsers.bmparts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

import com.npproject.parser.models.BmModels.BmModel;
import com.npproject.parser.parsers.utils.ParserUtil;

public class BmProductPriceParser extends ParserUtil {

    public List<BmModel> getBmModelsList() throws IOException, InterruptedException {
        String fooResourceUrl = "https://api.bm.parts/prices/list";

            String body = "{\n" +
                    "  \"currency\": \"A358000C2947F7AE11E23F5617780B16\"\n" +
                    "}";

            HttpClient client = new HttpClient();
            PostMethod method = new PostMethod(fooResourceUrl);
            method.setRequestBody(body);
            method.setRequestHeader("Accept", "application/json");
            method.setRequestHeader("User-Agent", "Awesome-BM-Parts-App");
            method.setRequestHeader("Authorization", "56a8c7fe-bd3f-482f-850f-4fe0f5bf31bf.GfXBi-e9SO1OrJ9TKhRYvoYTKGE");

        int responseStatus = client.executeMethod(method);

        if (responseStatus != 200) {
            TimeUnit.MINUTES.sleep(61);
            getBmModelsList();
        }

        String responseBodyAsString = method.getResponseBodyAsString();

            List<BmModel> bmModels = convertResponse(responseBodyAsString);

            return bmModels;
    }

    private List<BmModel> convertResponse(String response) {
        List<BmModel> bmModelList = new ArrayList<>();
        response.lines().collect(Collectors.toList())
                .stream().skip(2)
                .forEach(f -> {
                    String[] split = f.split("\",\"");
                    double price = Double.parseDouble(split[4]);
                    double newPrice = price + (0.25 * price);
                    bmModelList.add(BmModel.builder()
                            .id(split[0].replace("\"", ""))
                            .article(split[1])
                            .brand(split[2])
                            .name(split[3])
                            .priceUah(split[4])
                            .newPriceUah(String.valueOf(newPrice))
                            .vinnica(split[5])
                            .dnipro(split[6])
                            .franyk(split[7])
                            .kyiv(split[8])
                            .lutsk(split[9])
                            .lviv(split[10])
                            .rivne(split[11])
                            .uzgorod(split[12])
                            .khm(split[13])
                            .hust(split[14])
                            .chernivci(split[15].replace("\"", ""))
                            .build());
                });

        return bmModelList;
    }
}
