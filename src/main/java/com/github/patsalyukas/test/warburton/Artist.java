package com.github.patsalyukas.test.warburton;

import lombok.Getter;
import lombok.NonNull;

import java.util.HashSet;
import java.util.Set;

@Getter
public class Artist {

    @NonNull private String name;
    @NonNull private Set<String> member;
    @NonNull private String origin;

    public Artist(String name, String origin) {
        this.name = name;
        this.origin = origin;
        member = new HashSet<>();
        member.add(name);
    }

    public Artist(@NonNull String name, @NonNull Set<String> member, @NonNull String origin) {
        this(name, origin);
        if (!member.isEmpty()) {
            this.member = member;
        }
    }
}
