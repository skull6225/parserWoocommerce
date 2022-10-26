package com.npproject.parser.services;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class PageParserTest {

    @Test
    public void runner() throws IOException {
        PageParser parser = new PageParser();
        parser.getDocument();
    }

}