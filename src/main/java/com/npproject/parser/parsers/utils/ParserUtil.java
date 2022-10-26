package com.npproject.parser.parsers.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

public class ParserUtil {

    protected static String BASIC_IMAGE_URL = "https://cdn.bm.parts/";

    protected static HttpHeaders headers = new HttpHeaders();

    protected static RestTemplate restTemplate = new RestTemplate();

    static {
        headers.set("Accept", "application/json");
        headers.set("User-Agent", "Awesome-BM-Parts-App");
        headers.set("Authorization", "56a8c7fe-bd3f-482f-850f-4fe0f5bf31bf.GfXBi-e9SO1OrJ9TKhRYvoYTKGE");
    }
}
