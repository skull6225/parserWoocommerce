package com.npproject.parser;


import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.npproject.parser.models.BmModels.BmModel;
import com.npproject.parser.parsers.bmparts.BmProductInfoParser;
import com.npproject.parser.parsers.bmparts.BmProductPriceParser;
import com.npproject.parser.parsers.bmparts.WooCommerceProductUpdate;


public class ParserApplication {

    public static void main(String[] args) throws IOException, InterruptedException {
//        PageParser parser = new PageParser();

        BmProductPriceParser adParser = new BmProductPriceParser();
        BmProductInfoParser bmProductInfoParser = new BmProductInfoParser();
        WooCommerceProductUpdate wooCommerceProductUpdate = new WooCommerceProductUpdate();

        List<BmModel> bmModelsList = adParser.getBmModelsList();

        List<BmModel> productsWithInfo = bmProductInfoParser.getProductsInfo(bmModelsList);

//        wooCommerceProductUpdate.updateProduct(productsWithInfo);





//			 parser.getDocument();


        //new CsvConverter().generateCvs(parser.getProductList());
    }

}
