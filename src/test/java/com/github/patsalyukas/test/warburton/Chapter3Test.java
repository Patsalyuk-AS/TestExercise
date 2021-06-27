package com.github.patsalyukas.test.warburton;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Chapter3Test {

    Chapter3 cp3 = new Chapter3();

    @Test
    void addUp() {
        Stream<Integer> stream =Stream.of(1, 3, 5);
        int sum = cp3.addUp(stream);
        System.out.println(sum);
        assertEquals(9, sum);
    }

    @Test
    void getNamesAndPlaces() {
        Artist artist1 = new Artist("Madonna", "USA");
        Artist artist2 = new Artist("Vera Brezhneva", "Russia");
        Artist artist3 = new Artist("John Lennon", new HashSet<>(), "UK");
        Stream<Artist> artists = Stream.of(artist1, artist2, artist3);
        System.out.println(cp3.getNamesAndPlaces(artists));
    }
}