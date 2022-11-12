package com.npproject.parser.parsers.bmparts.woocomerceApi;

import com.icoderman.woocommerce.ApiVersionType;
import com.icoderman.woocommerce.EndpointBaseType;
import com.icoderman.woocommerce.WooCommerceAPI;
import com.icoderman.woocommerce.oauth.OAuthConfig;
import com.npproject.parser.models.woomodels.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WooCommerce {
  OAuthConfig config = new OAuthConfig("https://avtozapchastunu.com", "ck_479ec4293e6bd001de1111ec176a5e8b46ff4ce2", "cs_8db1b2c07c989957ec0af01c8399475ee42a1a1c");
  com.icoderman.woocommerce.WooCommerce wooCommerce = new WooCommerceAPI(config, ApiVersionType.V3);


  public void getProducts() {

    try (Connection con = DriverManager
        .getConnection("jdbc:mysql://sql862.main-hosting.eu", "u174649484_dA16H", "I7wnAKBVyV")) {

      Statement stmt = con.createStatement();
      String query = "SELECT * FROM u174649484_jJHKc.wp_wc_product_meta_lookup"; // Your own Query

      ResultSet rs = stmt.executeQuery(query);

      List<Map<String, Integer>> wooProductsList = new ArrayList<>();

      while(rs.next()) {
        Map<String, Integer> productInfo = new HashMap<>();
        int productId = rs.getInt("product_id");
        String sku = rs.getString("sku");
        productInfo.put(sku, productId);

        wooProductsList.add(productInfo);
      }
      System.out.println(1);


      // use con here
    } catch (SQLException e) {
      e.printStackTrace();
    }

    Map<String, Object> map = new HashMap<>();



//    map.put("upsell_ids", List);
    wooCommerce.update(EndpointBaseType.PRODUCTS.getValue(), 12, map);


    System.out.println(1);

  }
}
