//package com.npproject.parser.services;
//
//import com.npproject.parser.models.Product;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Slf4j
//public class PageParser {
//
//    public static final String GENETAL_URL = "https://exist.ua";
//    private static final String usrAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) Chrome/67.0.3396.99 Safari/537.36";
//
//    private long startTime = 0;
//
//
//    private final List<Product> productList = new ArrayList<>();
//
//    public void getDocument() throws IOException {
//
//        Document doc = Jsoup.connect(GENETAL_URL + "/pages/all-categories/")
//                .userAgent(usrAgent)
//                .timeout(60 * 1000)
//                .get();
//
//        Elements generalMenuElementsByClass =
//                doc.getElementsByClass("StaticPagestyle__StaticPageText-sc-1bnzw9x-5 iqcayS");
//
//        for (Element generalMenuElement : generalMenuElementsByClass.select("a")) {
//            String name = generalMenuElement.text();
//            String link = generalMenuElement.attr("href");
//            new Thread(() -> {
//                try {
//                    getPageInfo(link, name, null);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }).start();
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            log.info("Menu name: {}", name);
//        }
//    }
//
//    public List<Product> getProductList() {
//        return productList;
//    }
//
//    private void getPageInfo(String link, String menuName, String subMenuName) throws IOException {
//        int pageSize = 1;
//        Boolean pageSizeInfo = true;
//        for (int j = 1; j <= pageSize; j ++) {
//            Document doc = Jsoup.connect(link + "?page=" + j)
//                    .userAgent(usrAgent)
//                    .timeout(60 * 1000)
//                    .get();
//        if(pageSizeInfo) {
//            pageSize = getPageSize(doc);
//            pageSizeInfo = false;
//        }
//
//            Elements elementsByClass = doc.getElementsByClass("ListItemImagestyle__CatalogueListItemImageLink-sc-1xm3m92-0 eCuTmY");
//
//            log.info("Page link {}", link);
//            log.info("Page number {}", j);
//
//            for (Element element : elementsByClass) {
//                log.info("Product link: {}", element.attr("href"));
//                new Thread(() -> {
//                    try {
//                        getProductName(element.attr("href"), menuName, subMenuName);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }).start();
//
//                break;
//            }
//            break;
//        }
//    }
//
//    private int getPageSize(Document doc) {
//        int pageSize;
//        try {
//            pageSize = Integer.parseInt(doc.getElementsByClass("Pagerstyle__PagerContainer-sc-183hzn0-2")
//                    .get(1).select("a")
//                    .stream()
//                    .filter(f -> f.attr("aria-label")
//                            .equals("lastPage"))
//                    .collect(Collectors.toList()).get(0).text());
//        } catch (IndexOutOfBoundsException e) {
//            pageSize = 1;
//        }
//        return pageSize;
//    }
//
//    private void getProductName(String link, String menuName, String subMenuName) throws IOException {
//
//        startTime = System.currentTimeMillis();
//        log.info("Product link: {}", GENETAL_URL + link);
//
//        Document doc = Jsoup.connect(GENETAL_URL + link)
//                .userAgent(usrAgent)
//                .timeout(60 * 1000)
//                .get();
//
//        String price = null;
//        try {
//            price = StringUtils.deleteWhitespace(doc.getElementsByClass("ProductPriceBlockstyle__ProductPriceValue-sc-1pwmnni-6 bbolny").get(0).text());
//        } catch (Exception e) {
//            log.info("price is empty");
//        }
//
//        String name = doc.getElementsByClass("ProductHeaderstyle__ProductHeaderTitle-sc-kgl4sw-5 iRxFJO").text();
//
//        Elements span = doc.getElementsByClass("Productstyle__ProductSubTitleContainer-sc-1upw0zr-1 jyAYkd").select("span");
//
//        String description = doc.getElementsByClass("DropDownButtonstyle__DropDownContent-sc-1in3rp2-0 bozxAp").get(3).text();
//
//        String characteristic = null;
//        try {
//            characteristic = doc.getElementsByClass("ProductTextInfostyle__ProductAttributesTable-sc-3why64-1 eXThBc").get(0).text();
//        } catch (Exception e) {
//            characteristic = "Скоро заполним";
//        }
//
//        Product product = new Product();
//
//        product.setName(name);
//        product.setLink(GENETAL_URL + link);
//        product.setPrice(price);
//        product.setBrand(span.get(0).text());
//        product.setNumber(span.get(1).select("strong").text());
//        product.setDescription(description);
//        product.setCharacteristic(characteristic);
//        product.setMenu(menuName);
//        product.setSubMenu(subMenuName);
//
//        productList.add(product);
//
//        long currentTimee = System.currentTimeMillis();
//
//        log.info("Response time: " + (currentTimee - startTime) + "ms");
//
//        log.info(String.valueOf(productList.size()));
//    }
//}
