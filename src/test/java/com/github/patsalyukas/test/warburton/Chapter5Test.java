package com.github.patsalyukas.test.warburton;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Chapter5Test {

    Chapter5 cp5 = new Chapter5();

    @Test
    void getNamesAndPlacesInUpperCase() {
        Artist artist1 = new Artist("Madonna", "USA");
        Artist artist2 = new Artist("Vera Brezhneva", "Russia");
        Artist artist3 = new Artist("John Lennon", new HashSet<>(), "UK");
        Stream<Artist> artists = Stream.of(artist1, artist2, artist3);
        List<String> list = cp5.getNamesAndPlacesInUpperCase(artists);
        assertEquals("MADONNA-USA", list.get(0));
        assertEquals("VERA BREZHNEVA-RUSSIA", list.get(1));
        assertEquals("JOHN LENNON-UK", list.get(2));
    }

    @Test
    void totalOfArtists() {
        Artist artist1 = new Artist("Madonna", "USA");
        Artist artist2 = new Artist("Vera Brezhneva", "Russia");
        Artist artist3 = new Artist("John Lennon", new HashSet<>(), "UK");
        List<Artist> artists = new ArrayList<>();
        artists.add(artist1);
        artists.add(artist2);
        artists.add(artist3);
        assertEquals(3, cp5.totalOfArtists(artists));
    }
}