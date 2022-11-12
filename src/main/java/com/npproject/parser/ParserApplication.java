package com.npproject.parser;


import com.npproject.parser.parsers.bmparts.woocomerceApi.WooCommerce;
import java.io.IOException;
import java.util.List;

import com.npproject.parser.models.BmModels.BmModel;
import com.npproject.parser.parsers.bmparts.BmProductInfoParser;
import com.npproject.parser.parsers.bmparts.BmProductPriceParser;
import com.npproject.parser.parsers.bmparts.WooCommerceProductUpdate;


public class ParserApplication {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
//        PageParser parser = new PageParser();

//        WooCommerce wooCommerce = new WooCommerce();
//        wooCommerce.getProducts();

        BmProductPriceParser adParser = new BmProductPriceParser();
        BmProductInfoParser bmProductInfoParser = new BmProductInfoParser();
        WooCommerceProductUpdate wooCommerceProductUpdate = new WooCommerceProductUpdate();

//        List<BmModel> bmModelsList = adParser.getBmModelsList();
        List<BmModel> bmModelsList = adParser.getBmModelsList();
        bmProductInfoParser.getProductsInfo(bmModelsList);
//        List<BmModel> productsWithInfo = bmProductInfoParser.getProductsInfo();

//        wooCommerceProductUpdate.updateProduct(productsWithInfo);





//			 parser.getDocument();


        //new CsvConverter().generateCvs(parser.getProductList());
    }

}
