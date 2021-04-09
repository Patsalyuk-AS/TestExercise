package com.github.patsalyukas.test.innerclasses;

import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class StringSorter {

    private List<String> strings;

    public List<String> naturalSort() {
        Collections.sort(strings);
        return strings;
    }

    public List<String> naturalSortWithStreams() {
        return strings.stream().sorted().collect(Collectors.toList());
    }

    public List<String> lengthSort() {
        Collections.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        return strings;
    }

    public List<String> lengthSortWithLambda() {
        Collections.sort(strings, (o1, o2) -> o1.length() - o2.length());
        return strings;
    }

    public List<String> lengthSortWithStream() {
        return strings.stream().sorted((o1, o2) -> Integer.compare(o1.length(), o2.length())).collect(Collectors.toList());
    }

}
