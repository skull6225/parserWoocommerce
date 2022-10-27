package com.npproject.parser.parsers.bmparts;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.icoderman.woocommerce.ApiVersionType;
import com.icoderman.woocommerce.EndpointBaseType;
import com.icoderman.woocommerce.WooCommerce;
import com.icoderman.woocommerce.WooCommerceAPI;
import com.icoderman.woocommerce.oauth.OAuthConfig;
import com.npproject.parser.models.BmModels.BmModel;

public class WooCommerceProductUpdate {
    OAuthConfig config = new OAuthConfig("https://avtozapchastunu.com", "ck_71b6c7f511fb36b5888c63260006b0b7114b29de", "cs_0cb9e645cd62f37658e8b7dbf84f937575aabdd8");
    WooCommerce wooCommerce = new WooCommerceAPI(config, ApiVersionType.V3);

    public void updateProduct(List<BmModel> bmModel) throws JsonProcessingException, InterruptedException {

        System.out.println("start create");

        for (BmModel product : bmModel) {
            modifyAndUpdate(product);
        }

        System.out.println("end create");

    }

    public void modifyAndUpdate(BmModel product) throws JsonProcessingException, InterruptedException {

        System.out.println("Start update wooCommerce");

        Map<String, Object> newMapProduct = new HashMap<>();

        newMapProduct.put("name", product.getName());
        newMapProduct.put("regular_price", product.getNewPriceUah());
        newMapProduct.put("sku", product.getId());
        newMapProduct.put("description", String.format("%s %s %s",
                getBeautifyJson(product.getInfo().getDetails()),
                System.lineSeparator(),
                getBeautifyJson(product.getInfo().getCars()))
        );
        newMapProduct.put("short_description", String.format("Номер деталі: %s", product.getArticle()));

        newMapProduct.put("meta_data", Arrays.asList(
                transformResourceToMetaFormat("fifu_list_url", product.getInfo().getImages()),
                transformResourceToMetaFormat("_wc_cog_cost", Arrays.asList(product.getPriceUah()))
        ));

        try {
            wooCommerce.create(EndpointBaseType.PRODUCTS.getValue(), newMapProduct);
        } catch (Exception e) {
            System.out.println("Something wrong when upload woocommerce product, wait 10 sec");
            TimeUnit.SECONDS.sleep(10);
            modifyAndUpdate(product);
        }

        System.out.println("end create");
    }

    private String getBeautifyJson(Object object) throws JsonProcessingException {
        String beautifyJson = null;
        try {
            beautifyJson = object.toString()
                    .replace(", ", ", \n")
                    .replace("{", "")
                    .replace("}", "")
                    .replace("[", "")
                    .replace("]", "");
        } catch (OutOfMemoryError | Exception e) {
            beautifyJson = "OutOfMemory";
            System.out.println("OutOfMemory");
        }
        return beautifyJson;
    }

    private Map<String, String> transformResourceToMetaFormat(String metaKeyFieldName, List<String> images) {
        Map<String, String> imageMap = new HashMap<>();

        imageMap.put("key", metaKeyFieldName);
        imageMap.put("value", StringUtils.join(images, "|"));
        return imageMap;
    }
}
