package com.github.patsalyukas.test.warburton;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
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
        List<String> list = cp3.getNamesAndPlaces(artists);
        assertEquals("Madonna-USA", list.get(0));
        assertEquals("Vera Brezhneva-Russia", list.get(1));
        assertEquals("John Lennon-UK", list.get(2));
    }

    @Test
    void albumWithThreeAndMoreTracks() {
        List<Track> tracksEmpty = new ArrayList<>();
        List<Track> tracksWith2Songs = Arrays.asList(new Track("Song1"), new Track("Song2"));
        List<Track> tracksWith3Songs = Arrays.asList(new Track("Song1"), new Track("Song2"), new Track("Song3"));
        List<Track> tracksWith4Songs = Arrays.asList(new Track("Song1"), new Track("Song2"), new Track("Song3"), new Track("Song4"));
        Album album1 = new Album("album1", tracksEmpty, null);
        Album album2 = new Album("album2", tracksWith2Songs, null);
        Album album3 = new Album("album3", tracksWith3Songs, null);
        Album album4 = new Album("album4", tracksWith4Songs, null);
        List<Album> list = cp3.albumWithThreeAndMoreTracks(Stream.of(album1, album2, album3, album4));
        assertEquals(2, cp3.albumWithThreeAndMoreTracks(Stream.of(album1, album2, album3, album4)).size());
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
        assertEquals(3, cp3.totalOfArtists(artists));
    }
}