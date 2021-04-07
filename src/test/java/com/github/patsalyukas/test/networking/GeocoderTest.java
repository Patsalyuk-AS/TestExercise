package com.github.patsalyukas.test.networking;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GeocoderTest {

    private Geocoder geocoder = new Geocoder();

    @Test
    void encodeAddress() {
        String encoded = geocoder.encodeAddress(Arrays.asList("1600 Ampitheatre Parkway", "Mountain View", "CA"));
        assertEquals("1600+Ampitheatre+Parkway,Mountain+View,CA", encoded);
    }

    @Test
    void getDate() {
        String data = geocoder.getDate(Arrays.asList("1600 Ampitheatre Parkway", "Mountain View", "CA"));
        System.out.println(data);
    }
}