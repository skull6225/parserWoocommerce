//package com.npproject.parser.services;
//
//import com.npproject.parser.models.Product;
//import com.opencsv.bean.ColumnPositionMappingStrategy;
//import com.opencsv.bean.StatefulBeanToCsv;
//import com.opencsv.bean.StatefulBeanToCsvBuilder;
//
//import java.io.FileWriter;
//import java.util.ArrayList;
//import java.util.List;
//
//public class CsvConverter {
//    final String CSV_LOCATION = "Employees.csv";
//
//    public void generateCvs(List<Product> products) {
//        try (FileWriter writer = new
//                FileWriter(CSV_LOCATION)) {
//            ColumnPositionMappingStrategy mappingStrategy = new ColumnPositionMappingStrategy();
//            mappingStrategy.setType(Product.class);
//
//            String[] columns = {
//                    "name",
//                    "description",
//                    "link",
//                    "price",
//                    "menu",
//                    "subMenu",
//                    "brand",
//                    "number",
//                    "characteristic"};
//            mappingStrategy.setColumnMapping(columns);
//
//            StatefulBeanToCsv beanWriter = new StatefulBeanToCsvBuilder(writer)
//                    .withMappingStrategy(mappingStrategy)
//                    .build();
//
//            List<Product> productWithTitle = new ArrayList<>();
//
//            Product product = new Product();
//
//            product.setName("name");
//            product.setDescription("description");
//            product.setLink("link");
//            product.setPrice("price");
//            product.setMenu("menu");
//            product.setSubMenu("subMenu");
//            product.setBrand("brand");
//            product.setNumber("number");
//            product.setCharacteristic("characteristic");
//
//            productWithTitle.add(product);
//
//            productWithTitle.addAll(products);
//
//            beanWriter.write(productWithTitle);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
