//
package com.github.patsalyukas.test.networking;

import java.net.URL;

public class UrlExample {
    public static void main(String[] args) throws Exception {
        URL myURL = new URL("https://learning.oreilly.com/videos/advanced-java-development/9781491960400/9781491960400-video247582");
        System.out.println("Protocol: " + myURL.getProtocol());
        System.out.println("Authority: " + myURL.getAuthority());
        System.out.println("Host: " + myURL.getHost());
        System.out.println("Port: " + myURL.getPort());
        System.out.println("Path: " + myURL.getPath());
        System.out.println("Query: " + myURL.getQuery());
        System.out.println("File: " + myURL.getFile());
        System.out.println("Ref: " + myURL.getRef());
    }
}
