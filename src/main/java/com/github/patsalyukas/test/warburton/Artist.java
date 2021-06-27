package com.github.patsalyukas.test.warburton;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@Getter
@AllArgsConstructor
public class Artist {

    private String name;
    private Set<String> member;
    private String origin;

    public Artist(String name, String origin) {
        this.name = name;
        this.origin = origin;
    }
}
